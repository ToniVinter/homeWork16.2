package ro.fasttrackit.community;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PersonTest {
    private Person person;
    @BeforeEach
    void setup() throws IOException {
        person = new Person("Va345",45);
    }
    @Test
    @DisplayName("WHEN name contains number THEN return exception/message")
    void nameContainingNumber(){
        var result = person.getName();
        Assertions.assertThrows(IOException.class, () -> person.getName());
    }    @Test
    @DisplayName("WHEN name is null THEN return exception/message")
    void nullName(){
        var result = person.getName();
        Assertions.assertThrows(IOException.class, () -> person.getName());
    }
}
