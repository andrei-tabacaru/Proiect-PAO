package project.classes;

import java.util.Objects;

public abstract class Person {
    static int maxId;
    protected int personId;
    protected String name;
    protected String phoneNumber;
    protected String email;

    public Person(String name, String phoneNumber, String email) {
        Person.maxId += 1;
        this.personId = Person.maxId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Person(int personId, String name, String phoneNumber, String email) {
        this.personId = personId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Person() {
        Person.maxId += 1;
        this.personId = Person.maxId;
        this.name = "";
        this.phoneNumber = "";
        this.email = "";
    }

    public int getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId == person.personId &&
                Objects.equals(name, person.name) &&
                Objects.equals(phoneNumber, person.phoneNumber) &&
                Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, name, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
