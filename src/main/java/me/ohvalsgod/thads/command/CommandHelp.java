package me.ohvalsgod.thads.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommandHelp {

    private String syntax;
    private String description;

}
