package de.schroeder.mapstruct.secretidentity.control;

import de.schroeder.mapstruct.person.entity.PersonEntity;
import de.schroeder.mapstruct.superhero.entity.SuperheroEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecretIdentityMapperTest {

    @Autowired
    private SecretIdentityMapper secretIdentityMapper;

    private PersonEntity person;
    private SuperheroEntity superhero;

    @Before
    public void setup(){

        person = new PersonEntity();
        person.setName("Peter");
        person.setSurname("Parker");

        superhero = new SuperheroEntity();
        superhero.setName("Spider-Man");
        superhero.setSecretIdentity(person);
    }

    @Test
    public void createFromEntities() {
    }
}