package ro.fasttrackit.community;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    private PersonService personService;

    @BeforeEach
    void setup(){
        personService = new PersonService(new ArrayList<>());
    }
    @Test
    @DisplayName("WHEN adding a person THEN increment ID")
    void incrementIDTest() {
        personService.addPerson("TestName1",15);
        var result = 0;
        for (Person person:personService.getCommunity()) {
            result++;
            Assertions.assertThat(result).isEqualTo(person.getID());
        }

    }

    @Test
    @DisplayName("WHEN remove unexisting person THEN throw Exception")
    void unexistingPerson(){
        personService.addPerson("Add",13);
        personService.addPerson("Ad",13);
        int id = 4;
        boolean bool = false;
        assertThrows(IOException.class, () -> personService.removePerson(15));

    }
    
    @Test
    @DisplayName("WHEN getting persons older than x THEN return it, lower than 120")
    void getPersonOlderThan120(){
       assertThrows(IllegalArgumentException.class,() -> personService.getPersonsOlderThan(200));
    }

    @Test
    @DisplayName("WHEN returning null from getAllNames THEN throws IOException")
    void nullGetAllNames() throws IOException {
        assertThrows(IOException.class,() -> personService.getAllNames());
    }

    @Test
    @DisplayName("WHEN the person with name was not found THEN return exception")
    void noNameFoundAtGetPerson(){
        assertThrows(IOException.class,() -> personService.getPerson("Peter"));
    }






}