package de.schroeder.mapstruct.marvel.control;

import de.schroeder.mapstruct.marvel.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}
