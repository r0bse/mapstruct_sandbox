package de.schroeder.mapstruct.person;

import de.schroeder.mapstruct.person.entity.PersonEntity;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Util class for creating a person and other methods which are used several times
 */
public abstract class PersonUtil {

    public static PersonEntity creatValidPersonEntity() {
        ZonedDateTime birthday = ZonedDateTime.of(1963, 3, 10, 0, 0, 0, 0, ZoneId.of("UTC"));

        PersonEntity person = new PersonEntity();
        person.setName("Peter");
        person.setSurname("Parker");
        person.setBirthday(birthday);

        return person;
    }
}
