package me.ohvalsgod.thads.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.ohvalsgod.thads.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class ConfigCursor {

    private final FileConfig fileConfig;
    @Setter private String path;

    public boolean exists() {
        return this.exists(path);
    }

    public boolean exists(String path) {
        return this.fileConfig.getConfig().contains(this.path + (path == null ? "" : "." + path));
    }

    public Set<String> getKeys() {
        return this.getKeys(null);
    }

    public Set<String> getKeys(String path) {
        return this.fileConfig.getConfig().getConfigurationSection(this.path + (path == null ? "" : "." + path)).getKeys(false);
    }

    public String getString(String path) {
        return CC.translate(this.fileConfig.getConfig().getString((this.path == null ? "" : this.path + ".") + path));
    }

    public boolean getBoolean(String path) {
        return this.fileConfig.getConfig().getBoolean((this.path == null ? "" : this.path + ".") + "." + path);
    }

    public int getInt(String path) {
        return this.fileConfig.getConfig().getInt((this.path == null ? "" : this.path + ".") + "." + path);
    }

    public long getLong(String path) {
        return this.fileConfig.getConfig().getLong((this.path == null ? "" : this.path + ".") + "." + path);
    }

    public List<String> getStringList(String path) {
        return this.fileConfig.getConfig().getStringList((this.path == null ? "" : this.path + ".") + "." + path);
    }

    public UUID getUuid(String path) {
        return UUID.fromString(this.fileConfig.getConfig().getString(this.path + "." + path));
    }

    public World getWorld(String path) {
        return Bukkit.getWorld(this.fileConfig.getConfig().getString(this.path + "." + path));
    }

    public void set(Object value) {
        this.set(null, value);
    }

    public void set(String path, Object value) {
        this.fileConfig.getConfig().set(this.path + (path == null ? "" : "." + path), value);
    }

    public void save() {
        this.fileConfig.save();
    }

}
