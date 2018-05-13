package de.schroeder.mapstruct.person.control;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import de.schroeder.mapstruct.person.boundary.PersonResource;
import de.schroeder.mapstruct.person.entity.PersonEntity;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;
    private PersonEntity person;

    @Before
    public void setup(){
        ZonedDateTime birthday = ZonedDateTime.of(1963, 3, 10, 0, 0, 0, 0, ZoneId.of("UTC"));

        person = new PersonEntity();
        person.setName("Peter");
        person.setSurname("Parker");
        person.setBirthday(birthday);
    }

    @Test
    public void mapToResources() {

        List<PersonEntity> entities = new ArrayList<>();
        entities.add(person);
        List<PersonResource> personResources = personMapper.mapToResources(entities);

        assertThat(personResources.get(0).getBirthday(), is(equalTo(person.getBirthday())));
        assertThat(personResources.get(0).getFullname(), is(equalTo(person.getName() + " " + person.getSurname())));
    }

    @Test
    public void mapToResource() {
        PersonResource resource = personMapper.mapToResource(person);
        assertThat(resource.getBirthday(), is(equalTo(person.getBirthday())));
        assertThat(resource.getFullname(), is(equalTo(person.getName() + " " + person.getSurname())));
    }
}