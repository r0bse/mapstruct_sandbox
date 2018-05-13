package de.schroeder.mapstruct.secretidentity.boundary;

public class SecretIdentityResource {

    private String superhero;
    private String secretIdentity;

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public String getSuperhero() {
        return superhero;
    }

    public void setSuperhero(String superhero) {
        this.superhero = superhero;
    }
}
