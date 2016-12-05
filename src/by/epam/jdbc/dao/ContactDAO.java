package by.epam.jdbc.dao;

import by.epam.jdbc.domain.Contact;

import java.util.List;

/**
 * Created by Uladzislau_Kastsevic on 11/30/2016.
 */
public interface ContactDAO {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    List<Contact> findByFirstName(String firstName);
    String findFirstNameById(Long id);
    String findLastNameById(Long id);
    void insert(Contact contact);
    void insertWithDetail(Contact contact);
    void update(Contact contact);
    void delete(Long contactId);
}
