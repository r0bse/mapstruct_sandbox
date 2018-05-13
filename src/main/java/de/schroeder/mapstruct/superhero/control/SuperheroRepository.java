package de.schroeder.mapstruct.superhero.control;

import de.schroeder.mapstruct.person.entity.PersonEntity;
import de.schroeder.mapstruct.superhero.entity.SuperheroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperheroRepository extends JpaRepository<SuperheroEntity, Long> {

    @Query("Select superhero from SuperheroEntity superhero where superhero.secretIdentity = ?1")
    SuperheroEntity getByPerson(PersonEntity person);
}
