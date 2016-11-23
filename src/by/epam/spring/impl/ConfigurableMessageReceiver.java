package by.epam.spring.impl;

import by.epam.spring.abstraction.MessageReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Uladzislau_Kastsevic on 11/22/2016.
 */
@Service("messageReceiver")
public class ConfigurableMessageReceiver implements MessageReceiver {
    private String message;

    @Autowired
    public ConfigurableMessageReceiver(String message){
        this.message = message;
    }

    @Override
    public String receiveMessage() {
        return message;
    }
}
