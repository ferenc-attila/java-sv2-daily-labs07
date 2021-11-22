package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameValidatorTest {

    NameValidator nameValidator = new NameValidator();

    @Test
    void isNameValidTest() {
        boolean result = nameValidator.isNameValid("John Doe");
        assertTrue(result);
        boolean trimmedResult = nameValidator.isNameValid(" John Doe  ");
        assertTrue(trimmedResult);
    }

    @Test
    void isNameValidWithNullTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> nameValidator.isNameValid(null));
        assertEquals("Not a valid name: null!", iae.getMessage());
    }

    @Test
    void isNameValidWithEmptyStringTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> nameValidator.isNameValid(""));
        assertEquals("Not a valid name: !", iae.getMessage());
    }

    @Test
    void isNameValidWithInvalidNameTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> nameValidator.isNameValid("JaneDoe"));
        assertEquals("Not a valid name: JaneDoe!", iae.getMessage());
    }

    @Test
    void isNameValidWithInvalidTrimmedNameTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> nameValidator.isNameValid("  JaneDoe  "));
        assertEquals("Not a valid name: JaneDoe!", iae.getMessage());
    }
}