package de.schroeder.mapstruct.marvel.control;

import de.schroeder.mapstruct.marvel.boundary.PersonResource;
import de.schroeder.mapstruct.marvel.entity.PersonEntity;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    public PersonService(PersonMapper personMapper,
                         PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    public List<PersonEntity> getAllEntities(){
        return personRepository.findAll();
    }

    public List<PersonResource> getAllResources(){
        return personMapper.mapToResources(personRepository.findAll());
    }
}
