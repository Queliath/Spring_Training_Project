package by.epam.spring.command.impl;

import by.epam.spring.command.Command;
import by.epam.spring.service.abstraction.MessageRenderer;

/**
 * Created by Uladzislau_Kastsevic on 11/23/2016.
 */
public class PrintMessageCommand implements Command {
    private MessageRenderer messageRenderer;

    public void setMessageRenderer(MessageRenderer messageRenderer){
        this.messageRenderer = messageRenderer;
    }

    @Override
    public void execute() {
        messageRenderer.render();
    }
}
