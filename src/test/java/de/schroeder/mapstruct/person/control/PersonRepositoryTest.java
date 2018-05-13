package de.schroeder.mapstruct.person.control;

import static org.junit.Assert.assertNotNull;

import de.schroeder.mapstruct.person.entity.PersonEntity;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test for saving in H2 database
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void save(){

        ZonedDateTime birthday = ZonedDateTime.of(1963, 3, 10, 0, 0, 0, 0, ZoneId.of("UTC"));
        PersonEntity person = new PersonEntity();
        person.setName("Peter");
        person.setSurname("Parker");
        person.setBirthday(birthday);

        personRepository.save(person);

        assertNotNull(person.getId());
    }
}