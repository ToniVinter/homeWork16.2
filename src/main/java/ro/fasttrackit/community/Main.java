package ro.fasttrackit.community;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> community = new ArrayList<>();
        PersonService personService = new PersonService(community);
        personService.addPerson("Ana",15);
        personService.addPerson("An", 14);
        System.out.println(personService.getCommunity());

    }

}
