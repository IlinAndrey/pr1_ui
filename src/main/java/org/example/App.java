package org.example;
import java.util.ArrayList;
import java.util.List;

public class App
{
    private static class Person {
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
        PersonManager manager = new PersonManager();

        manager.addPerson("Alice", 30);
        manager.addPerson("Bob", 25);
        manager.addPerson("Charlie", 35);

        System.out.println("All people:");
        manager.printAllPeople();

        System.out.println("\nSearching for Bob:");
        Person foundPerson = manager.findPersonByName("Bob");
        if (foundPerson != null) {
            foundPerson.printInfo();
        } else {
            System.out.println("Person not found.");
        }

        System.out.println("\nRemoving Alice:");
        boolean removed = manager.removePersonByName("Alice");
        if (removed) {
            System.out.println("Alice was removed successfully.");
        } else {
            System.out.println("Alice was not found.");
        }

        System.out.println("\nAll people after removal:");
        manager.printAllPeople();
    }
}
