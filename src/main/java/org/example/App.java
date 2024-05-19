package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void printInfo() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    public static class PersonManager {
        private List<Person> people;

        public PersonManager() {
            this.people = new ArrayList<>();
        }

        public void addPerson(String name, int age) {
            Person person = new Person(name, age);
            people.add(person);
        }

        public boolean removePersonByName(String name) {
            return people.removeIf(person -> person.getName().equals(name));
        }

        public Person findPersonByName(String name) {
            for (Person person : people) {
                if (person.getName().equals(name)) {
                    return person;
                }
            }
            return null;
        }

        public void printAllPeople() {
            for (Person person : people) {
                person.printInfo();
            }
        }
    }

    public static void main(String[] args) {
    }
}
