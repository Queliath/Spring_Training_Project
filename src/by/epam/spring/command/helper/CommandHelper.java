package by.epam.spring.command.helper;

import by.epam.spring.command.Command;

import java.util.Map;

/**
 * Created by Uladzislau_Kastsevic on 11/23/2016.
 */
public class CommandHelper {
    private Map<String, Command> commandMap;

    public void setCommandMap(Map<String, Command> commandMap){
        this.commandMap = commandMap;
    }

    public Command getCommand(String name){
        return commandMap.get(name);
    }
}
