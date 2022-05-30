package project.classes;

import java.util.Comparator;
import java.util.Objects;

public class Client extends Person implements Comparable<Client> {
    int age;

    public Client(String name, String phoneNumber, String email, int age) {
        super(name, phoneNumber, email);
        this.age = age;
    }

    public Client(int personId, String name, String phoneNumber, String email, int age) {
        super(personId, name, phoneNumber, email);
        this.age = age;
    }

    public Client() {
        super();
        this.age = 0;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return age == client.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age);
    }

    @Override
    public String toString() {
        return "Client{" +
                "age=" + age +
                ", personId=" + personId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int compareTo(Client ob){
        return this.name.compareTo(ob.name);
    }
}
