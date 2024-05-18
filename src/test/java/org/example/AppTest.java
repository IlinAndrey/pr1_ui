package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest extends TestCase {

    private App.PersonManager manager;

    public AppTest(String testName) {
        super(testName);
    }

    public static TestSuite suite() {
        return new TestSuite(AppTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        manager = new App.PersonManager();
    }

    public void testAddPerson() {
        manager.addPerson("Alice", 30);
        App.Person person = manager.findPersonByName("Alice");
        assertNotNull(person);
        assertEquals("Alice", person.getName());
        assertEquals(30, person.getAge());
    }

    public void testRemovePersonByName() {
        manager.addPerson("Bob", 25);
        boolean removed = manager.removePersonByName("Bob");
        assertTrue(removed);
        assertNull(manager.findPersonByName("Bob"));
    }

    public void testRemovePersonByNameNotFound() {
        boolean removed = manager.removePersonByName("Nonexistent");
        assertFalse(removed);
    }

    public void testFindPersonByName() {
        manager.addPerson("Charlie", 35);
        App.Person person = manager.findPersonByName("Charlie");
        assertNotNull(person);
        assertEquals("Charlie", person.getName());
        assertEquals(35, person.getAge());
    }

    public void testFindPersonByNameNotFound() {
        App.Person person = manager.findPersonByName("Nonexistent");
        assertNull(person);
    }

    public void testPrintAllPeople() {
        manager.addPerson("Alice", 30);
        manager.addPerson("Bob", 25);
        manager.addPerson("Charlie", 35);

        // Capture the output of printAllPeople() using a ByteArrayOutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        manager.printAllPeople();

        String expectedOutput = "Name: Alice, Age: 30\n" +
                "Name: Bob, Age: 25\n" +
                "Name: Charlie, Age: 35\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());

        // Restore the original System.out
        System.setOut(originalOut);
    }

    public void testApp() {
        assertTrue(true);
    }
}
