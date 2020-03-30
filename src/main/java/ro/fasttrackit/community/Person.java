package ro.fasttrackit.community;

import java.io.IOException;
import java.util.Objects;

public class Person  {
    private final String name;
    private final int age;
    private int ID;

    public Person(String name, int age) throws IOException {
        if(name == null){
            throw new IOException();
        }else {
            StringBuilder sb = new StringBuilder();
            char[] nameOfPerson = name.toCharArray();
            for (char c : nameOfPerson) {
                if (Character.isDigit(c)) {
                    throw new IOException();
                }
            }
            this.name = name;
            this.age = age;
        }
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getID() {
        return ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                ID == person.ID &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, ID);
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + name + '\'' +
                ", age=" + age +
                ", ID=" + ID +
                '}';
    }
}
