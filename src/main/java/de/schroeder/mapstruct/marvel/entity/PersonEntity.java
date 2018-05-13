package de.schroeder.mapstruct.marvel.entity;

import java.time.ZonedDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table("person")
public class PersonEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;

    private ZonedDateTime birthday;
}
