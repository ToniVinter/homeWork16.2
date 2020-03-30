package ro.fasttrackit.community;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    List<Person> community;
    int idNumber;

    public PersonService(List<Person> community) {
        this.community = new ArrayList<>(community);
        idNumber = community.size();
    }


    public void addPerson(String name, int age) throws IOException {
        idNumber++;
        Person person = new Person(name, age);
        person.setID(idNumber);
        community.add(person);

    }

    public Person removePerson(int id) throws IOException {
        Person personRemoved = null;
        for (Person person : community) {
            if (person.getID() == id) {
                community.remove(person);
                personRemoved = person;
            }
        }
        if (personRemoved == null) {
            throw new IOException("Person not found");
        } else {
            return personRemoved;
        }
    }

    public List<Person> getPersonsOlderThan(int age) {
        if (age < 120 && age > 0) {
            List<Person> olderCommunity = new ArrayList<>();
            for (Person person : community) {
                if (person.getAge() > age) {
                    olderCommunity.add(person);
                }
            }
            return olderCommunity;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getAllNames() throws IOException {
        List<String> names = new ArrayList<>();
        if (idNumber == 0) {
            throw new IOException();
        } else {
            for (Person person : community) {
                names.add(person.getName());
            }
        }
        return names;
    }

    public List<Person> getCommunity() {
        return community;
    }

    public Person getPerson(String name) throws IOException {
        Person foundPerson = null;
        for (Person person : community) {
            if (person.getName().equalsIgnoreCase(name)) {
                foundPerson = person;
            }
        }
        if (foundPerson == null) {
            throw new IOException();
        } else {
            return foundPerson;
        }
    }

    public Person getPersonByID(int id) throws IOException {
        Person foundPerson = null;
        for (Person person : community) {
            if (id == person.getID()) {
                foundPerson = person;
            }
        }
        if (foundPerson == null) {
            throw new IOException();
        } else {
            return foundPerson;
        }
    }

    @Override
    public String toString() {
        return "PersonService{" +
                "community=" + community +
                ", idNumber=" + idNumber +
                '}';
    }
}
