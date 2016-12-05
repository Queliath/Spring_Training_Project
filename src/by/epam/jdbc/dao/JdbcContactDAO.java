package by.epam.jdbc.dao;

import by.epam.jdbc.domain.Contact;
import by.epam.jdbc.domain.ContactTelDetail;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Uladzislau_Kastsevic on 12/5/2016.
 */
public class JdbcContactDAO implements ContactDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Contact> findAll() {
        String sqlQuery = "select id, first_name, last_name, birth_date from contact";
        return jdbcTemplate.query(sqlQuery, new ContactMapper());
    }

    @Override
    public List<Contact> findAllWithDetail() {
        String sqlQuery = "select c.id, c.first_name, c.last_name, c.birth_date, " +
                "t.id as contact_tel_id, t.tel_type, t.tel_number from contact c " +
                "left join contact_tel_detail t on c.id = t.contact_id";
        return jdbcTemplate.query(sqlQuery, new ContactWithDetailExtractor());
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return jdbcTemplate.queryForObject("select first_name from contact where id = ?", new Object[]{id}, String.class);
    }

    @Override
    public String findLastNameById(Long id) {
        return jdbcTemplate.queryForObject("select last_name from contact where id = ?", new Object[]{id}, String.class);
    }

    @Override
    public void insert(Contact contact) {

    }

    @Override
    public void insertWithDetail(Contact contact) {

    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void delete(Long contactId) {

    }

    private static final class ContactMapper implements RowMapper<Contact> {

        @Override
        public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setFirstName(resultSet.getString("first_name"));
            contact.setLastName(resultSet.getString("last_name"));
            contact.setBirthDate(resultSet.getDate("birth_date"));
            return contact;
        }
    }

    private static final class ContactWithDetailExtractor implements ResultSetExtractor<List<Contact>> {

        @Override
        public List<Contact> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            Map<Long, Contact> map = new HashMap<>();
            Contact contact = null;

            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                contact = map.get(id);

                if(contact == null){
                    contact = new Contact();
                    contact.setId(id);
                    contact.setFirstName(resultSet.getString("first_name"));
                    contact.setLastName(resultSet.getString("last_name"));
                    contact.setBirthDate(resultSet.getDate("birth_date"));
                    contact.setContactTelDetails(new ArrayList<ContactTelDetail>());
                    map.put(id, contact);
                }

                Long contactTelDetailId = resultSet.getLong("contact_tel_id");

                if(contactTelDetailId > 0) {
                    ContactTelDetail contactTelDetail = new ContactTelDetail();
                    contactTelDetail.setId(contactTelDetailId);
                    contactTelDetail.setContactId(id);
                    contactTelDetail.setTelType(resultSet.getString("tel_type"));
                    contactTelDetail.setTelNumber(resultSet.getString("tel_number"));
                    contact.getContactTelDetails().add(contactTelDetail);
                }
            }
            return new ArrayList<>(map.values());
        }
    }
}
