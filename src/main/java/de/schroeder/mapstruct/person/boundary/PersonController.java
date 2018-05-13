package de.schroeder.mapstruct.person.boundary;

import de.schroeder.mapstruct.person.control.PersonService;
import java.util.List;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = PersonController.URL, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PersonController {

    static final String URL = "persons";

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PersonResource> getAll(){
        return personService.getAllResources();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}")
    public PersonResource getOne(@PathParam("id") Long id){
        return personService.getOneResource(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createOne(@Valid @RequestBody PersonResource personResource){

    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping
    public void delete(){

    }
}
