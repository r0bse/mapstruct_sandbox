package de.schroeder.mapstruct.person.control;

import de.schroeder.mapstruct.person.boundary.PersonResource;
import de.schroeder.mapstruct.person.entity.PersonEntity;
import java.time.ZonedDateTime;
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

    public PersonResource getOneResource(Long id) {
        return personMapper.mapToResource(personRepository.getOne(id));
    }

    public Integer calculateAge(PersonEntity person){

        ZonedDateTime birthday = person.getBirthday();
        return ZonedDateTime.now().getYear() - birthday.getYear();
    }
}
