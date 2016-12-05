package by.epam.jdbc;

import by.epam.jdbc.dao.ContactDAO;
import by.epam.jdbc.domain.Contact;
import by.epam.jdbc.domain.ContactTelDetail;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by Uladzislau_Kastsevic on 12/5/2016.
 */
public class Main {
    public static void main(String[] args){
        GenericXmlApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("by/epam/jdbc/jdbc-context.xml");
        genericXmlApplicationContext.refresh();

        ContactDAO contactDAO = genericXmlApplicationContext.getBean("contactDao", ContactDAO.class);

        List<Contact> contacts = contactDAO.findAllWithDetail();
        for(Contact contact : contacts) {
            System.out.println(contact);
            if(contact.getContactTelDetails() != null) {
                for(ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
                    System.out.println(contactTelDetail);
                }
            }
        }
    }
}
