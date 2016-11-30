package by.epam.spring.service.impl;

import by.epam.spring.service.abstraction.MessageReceiver;
import by.epam.spring.service.abstraction.MessageRenderer;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Uladzislau_Kastsevic on 11/21/2016.
 */
@Service("messageRenderer")
public class ConsoleMessageRenderer implements MessageRenderer, InitializingBean, DisposableBean {
    MessageReceiver messageReceiver;

    @Resource(name = "messageReceiver")
    public void setMessageReceiver(MessageReceiver messageReceiver){
        this.messageReceiver = messageReceiver;
    }

    @Override
    public void render() {
        System.out.print(messageReceiver.receiveMessage());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("ConsoleMessageRenderer destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(messageReceiver != null);
    }
}
