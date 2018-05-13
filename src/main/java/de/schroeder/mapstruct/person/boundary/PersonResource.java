package de.schroeder.mapstruct.person.boundary;

import java.time.ZonedDateTime;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "PersonResource{" +
            "fullname='" + fullname + '\'' +
            ", birthday=" + birthday +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonResource that = (PersonResource) o;
        return Objects.equals(fullname, that.fullname) &&
            Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fullname, birthday);
    }
}
