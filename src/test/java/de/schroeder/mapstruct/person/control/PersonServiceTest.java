package de.schroeder.mapstruct.person.control;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.Mockito.when;

import de.schroeder.mapstruct.person.boundary.PersonResource;
import de.schroeder.mapstruct.person.entity.PersonEntity;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;
    @Mock
    private PersonMapper personMapper;

    private PersonEntity personEntity_1;
    private PersonEntity personEntity_2;
    private List<PersonEntity> entityList;

    private PersonResource personResource_1;
    private PersonResource personResource_2;
    private List<PersonResource> resourceList;

    private PersonService personService;

    @Before
    public void setUp(){

        personService =  new PersonService(personMapper, personRepository);

        ZonedDateTime birthday = ZonedDateTime.of(1963, 3, 10, 0, 0, 0, 0, ZoneId.of("UTC"));

        personEntity_1 = new PersonEntity();
        personEntity_1.setId(1L);
        personEntity_1.setName("Peter");
        personEntity_1.setSurname("Parker");
        personEntity_1.setBirthday(birthday);

        personEntity_2 = new PersonEntity();
        personEntity_2.setId(2L);
        personEntity_2.setName("Someone");
        personEntity_2.setSurname("Else");
        personEntity_2.setBirthday(birthday.minusYears(20));

        personResource_1 = new PersonResource();
        personResource_1.setBirthday(birthday);
        personResource_1.setFullname("Peter Parker");

        personResource_2 = new PersonResource();
        personResource_2.setBirthday(birthday.minusYears(20));
        personResource_2.setFullname("Someone Else");

        entityList = new ArrayList();
        entityList.add(personEntity_1);
        entityList.add(personEntity_2);

        resourceList = new ArrayList();
        resourceList.add(personResource_1);
        resourceList.add(personResource_2);
    }


    @Test
    public void getAllEntities() {

        when(personRepository.findAll()).thenReturn(entityList);

        List<PersonEntity> resultList = personService.getAllEntities();
        assertThat(resultList, is(not(empty())));
        assertThat(resultList, contains(personEntity_1, personEntity_2));
    }

    @Test
    public void getAllResources() {

        when(personRepository.findAll()).thenReturn(entityList);
        when(personMapper.mapToResources(entityList)).thenReturn(resourceList);

        List<PersonResource> resultList = personService.getAllResources();
        assertThat(resultList, is(not(empty())));
        assertThat(resultList, contains(personResource_1, personResource_2));
    }

    @Test
    public void getOneResource() {
        when(personRepository.getOne(personEntity_1.getId())).thenReturn(personEntity_1);
        when(personMapper.mapToResource(personEntity_1)).thenReturn(personResource_1);
        PersonResource resource = personService.getOneResource(personEntity_1.getId());

        assertThat(resource, equalTo(personResource_1));
    }

    @Test
    public void calculateAge() {

        ZonedDateTime birthday = ZonedDateTime.of(1900, 1, 1, 12, 0, 0, 0, ZoneId.of("UTC"));
        Integer expectedAge = ZonedDateTime.now().getYear() - birthday.getYear();

        PersonEntity reallyOldPerson = new PersonEntity();
        reallyOldPerson.setBirthday(birthday);

        Integer actualAge = personService.calculateAge(reallyOldPerson);
        assertThat(expectedAge, is(equalTo(actualAge)));
    }
}