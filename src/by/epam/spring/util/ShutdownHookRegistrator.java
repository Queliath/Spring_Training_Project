package by.epam.spring.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by Uladzislau_Kastsevic on 11/28/2016.
 */
public class ShutdownHookRegistrator implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(applicationContext instanceof GenericApplicationContext){
            ((GenericApplicationContext) applicationContext).registerShutdownHook();
        }
    }
}
