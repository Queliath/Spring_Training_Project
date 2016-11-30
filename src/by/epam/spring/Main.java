package by.epam.spring;

import by.epam.spring.command.Command;
import by.epam.spring.command.helper.CommandHelper;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Uladzislau_Kastsevic on 11/21/2016.
 */
public class Main {

    public static void main(String[] args){
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
        applicationContext.load("by/epam/spring/application-context.xml");
        applicationContext.refresh();

        GenericXmlApplicationContext serviceContext = new GenericXmlApplicationContext();
        serviceContext.load("by/epam/spring/service/service-context-xml.xml");
        serviceContext.refresh();

        GenericXmlApplicationContext commandContext = new GenericXmlApplicationContext();
        commandContext.load("by/epam/spring/command/command-context-xml.xml");
        commandContext.setParent(serviceContext);
        commandContext.refresh();

        CommandHelper commandHelper = commandContext.getBean("commandHelper", CommandHelper.class);

        Command printCommand = commandHelper.getCommand("print");
        Command doublePrintCommand = commandHelper.getCommand("doublePrint");

        printCommand.execute();
        doublePrintCommand.execute();
    }
}
