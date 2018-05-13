package de.schroeder.mapstruct.person.boundary;

import java.time.ZonedDateTime;

public class PersonResource {

    private String fullname;
    private ZonedDateTime birthday;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }
}
