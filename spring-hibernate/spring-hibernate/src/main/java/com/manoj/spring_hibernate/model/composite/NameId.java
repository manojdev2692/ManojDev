package com.manoj.spring_hibernate.model.composite;

import java.io.Serializable;
import java.util.Objects;

public class NameId implements Serializable {

    private String firstName;
    private String lastName;

    public NameId() {}

    public NameId(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof NameId nameId)) return false;

        return Objects.equals(firstName, nameId.firstName) && Objects.equals(lastName, nameId.lastName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(firstName);
        result = 31 * result + Objects.hashCode(lastName);
        return result;
    }
}
