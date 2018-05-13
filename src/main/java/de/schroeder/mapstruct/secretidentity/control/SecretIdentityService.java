package de.schroeder.mapstruct.secretidentity.control;

import de.schroeder.mapstruct.person.control.PersonRepository;
import de.schroeder.mapstruct.person.entity.PersonEntity;
import de.schroeder.mapstruct.secretidentity.boundary.SecretIdentityResource;
import de.schroeder.mapstruct.superhero.control.SuperheroRepository;
import de.schroeder.mapstruct.superhero.entity.SuperheroEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SecretIdentityService {

    private final SecretIdentityMapper secretIdentityMapper;
    private final SuperheroRepository superheroRepository;
    private final PersonRepository personRepository;

    public SecretIdentityService(SecretIdentityMapper secretIdentityMapper,
                                 SuperheroRepository superheroRepository,
                                 PersonRepository personRepository) {

        this.secretIdentityMapper = secretIdentityMapper;
        this.superheroRepository = superheroRepository;
        this.personRepository = personRepository;
    }

    public SecretIdentityResource getByPerson(PersonEntity person) {
        SuperheroEntity superhero = superheroRepository.getByPerson(person);
        return secretIdentityMapper.createFromEntities(person, superhero);
    }

    public SecretIdentityResource getBySuperhero(SuperheroEntity superhero) {
        return secretIdentityMapper.createFromEntities(superhero.getSecretIdentity(), superhero);
    }

    public List<SecretIdentityResource> getAll() {

        List<SuperheroEntity> superheroes = superheroRepository.findAll();
        return superheroes.stream()
            .map(hero -> secretIdentityMapper.createFromEntities(hero.getSecretIdentity(), hero))
            .collect(Collectors.toList());
    }
}
