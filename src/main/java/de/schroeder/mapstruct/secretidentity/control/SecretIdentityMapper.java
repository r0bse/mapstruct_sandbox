package de.schroeder.mapstruct.secretidentity.control;

import de.schroeder.mapstruct.person.entity.PersonEntity;
import de.schroeder.mapstruct.secretidentity.boundary.SecretIdentityResource;
import de.schroeder.mapstruct.superhero.entity.SuperheroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper to create SecretIdentityResources from PersonEntities and SuperHeroEntities
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SecretIdentityMapper {

    @Mappings({
        @Mapping(target = "secretIdentity", expression = "java(person.getName() + \" \" + person.getSurname())"),
        @Mapping(target = "superhero", source = "superhero.name")
    })
    SecretIdentityResource createFromEntities(PersonEntity person, SuperheroEntity superhero);
}
