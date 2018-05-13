package de.schroeder.mapstruct.person.control;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import de.schroeder.mapstruct.person.entity.PersonEntity;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import org.junit.After;
import org.junit.Before;
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
    private PersonEntity person;

    @Before
    public void setup(){
        ZonedDateTime birthday = ZonedDateTime.of(1963, 3, 10, 0, 0, 0, 0, ZoneId.of("UTC"));

        person = new PersonEntity();
        person.setName("Peter");
        person.setSurname("Parker");
        person.setBirthday(birthday);

        personRepository.save(person);
    }

    @After
    public void cleanup(){
        personRepository.deleteAllInBatch();
    }

    @Test
    public void save(){

        assertNotNull(person.getId());
    }

    @Test
    public void get(){

        List<PersonEntity> result = personRepository.findAll();
        assertThat(result.size(), is(1));
    }

    @Test
    public void getOne(){

        PersonEntity result = personRepository.getOne(person.getId());
        assertThat(result, is(equalTo(person)));
    }

    @Test
    public void delete(){
        personRepository.delete(person);
        List<PersonEntity> result = personRepository.findAll();
        assertThat(result, is(empty()));

    }
}