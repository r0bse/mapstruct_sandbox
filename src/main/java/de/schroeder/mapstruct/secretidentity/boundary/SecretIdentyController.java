package de.schroeder.mapstruct.secretidentity.boundary;


import de.schroeder.mapstruct.secretidentity.control.SecretIdentityService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ohh Gosh!!!
 * This controller reveals secret identities of superheros!
 */
@RestController
@RequestMapping(value = SecretIdentyController.URL, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SecretIdentyController {

    static final String URL = "/secretIdentities";
    private final SecretIdentityService secretIdentityService;

    public SecretIdentyController(SecretIdentityService secretIdentityService) {
        this.secretIdentityService = secretIdentityService;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<SecretIdentityResource> getAll(){
        return secretIdentityService.getAll();

    }
}
