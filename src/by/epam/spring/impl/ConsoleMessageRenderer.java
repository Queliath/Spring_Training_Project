package by.epam.spring.impl;

import by.epam.spring.abstraction.MessageReceiver;
import by.epam.spring.abstraction.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Uladzislau_Kastsevic on 11/21/2016.
 */
@Service("messageRenderer")
public class ConsoleMessageRenderer implements MessageRenderer {
    MessageReceiver messageReceiver;

    @Resource(name = "messageReceiver")
    public void setMessageReceiver(MessageReceiver messageReceiver){
        this.messageReceiver = messageReceiver;
    }

    @Override
    public void render() {
        System.out.print(messageReceiver.receiveMessage());
    }
}
