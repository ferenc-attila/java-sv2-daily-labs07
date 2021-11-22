package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HumanTest {

    @Test
    void createIllegalAgeTest() {
        IllegalArgumentException iaeTooOld = assertThrows(IllegalArgumentException.class,
                () -> new Human(" Jane Doe  ", 1900));
        assertEquals("Not a valid year of birth: 1900!", iaeTooOld.getMessage());
        IllegalArgumentException iaeTooYoung = assertThrows(IllegalArgumentException.class,
                () -> new Human("John Doe", 2055));
        assertEquals("Not a valid year of birth: 2055!", iaeTooYoung.getMessage());
    }

    @Test
    void createIllegalNameTest() {
        IllegalArgumentException iaeNameNUll = assertThrows(IllegalArgumentException.class,
                () -> new Human(null, 1980));
        assertEquals("Not a valid name: null!", iaeNameNUll.getMessage());
        IllegalArgumentException iaeNameEmptyString = assertThrows(IllegalArgumentException.class,
                () -> new Human("", 1980));
        assertEquals("Not a valid name: !", iaeNameEmptyString.getMessage());
        IllegalArgumentException iaeOneName = assertThrows(IllegalArgumentException.class,
                () -> new Human("JaneDoe", 1980));
        assertEquals("Not a valid name: JaneDoe!", iaeOneName.getMessage());
    }

    @Test
    void createTest() {
        Human jackDoe = new Human("Jack Doe", 1980);
        assertEquals("Jack Doe", jackDoe.getName());
        assertEquals(1980, jackDoe.getYearOfBirth());
        Human jillDoe = new Human(" Jill Doe  ", 1980);
        assertEquals("Jill Doe", jillDoe.getName());
        assertEquals(1980, jillDoe.getYearOfBirth());
    }
}