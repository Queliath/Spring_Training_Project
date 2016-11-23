package by.epam.spring.impl;

import by.epam.spring.abstraction.MessageReceiver;
import org.springframework.stereotype.Service;

/**
 * Created by Uladzislau_Kastsevic on 11/21/2016.
 */
public class HelloMessageReceiver implements MessageReceiver {
    @Override
    public String receiveMessage() {
        return "Hello!";
    }
}
