package de.schroeder.mapstruct.superhero.entity;

import de.schroeder.mapstruct.person.entity.PersonEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "superhero")
public class SuperheroEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private PersonEntity secretIdentity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonEntity getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(PersonEntity secretIdentity) {
        this.secretIdentity = secretIdentity;
    }
}
