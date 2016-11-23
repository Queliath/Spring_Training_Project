package by.epam.spring;

import by.epam.spring.abstraction.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Uladzislau_Kastsevic on 11/21/2016.
 */
public class Main {
    private static final String APPLICATION_CONTEXT_XML_FILE_PATH = "app-context-xml.xml";
    private static final String APPLICATION_CONTEXT_ANNOTATION_FILE_PATH = "app-context-annotation.xml";

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_ANNOTATION_FILE_PATH);
        MessageRenderer messageRenderer = applicationContext.getBean("messageRenderer", MessageRenderer.class);

        messageRenderer.render();
    }
}
