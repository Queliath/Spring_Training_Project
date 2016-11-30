package by.epam.jdbc.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by Uladzislau_Kastsevic on 11/30/2016.
 */
public class Contact {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private List<ContactTelDetail> contactTelDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ContactTelDetail> getContactTelDetails() {
        return contactTelDetails;
    }

    public void setContactTelDetails(List<ContactTelDetail> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
