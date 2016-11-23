package by.epam.spring.service.impl;

import by.epam.spring.service.abstraction.MessageReceiver;

/**
 * Created by Uladzislau_Kastsevic on 11/21/2016.
 */
public class HelloMessageReceiver implements MessageReceiver {
    @Override
    public String receiveMessage() {
        return "Hello!";
    }
}
