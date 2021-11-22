package day01;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class YearOfBirthValidatorTest {

    YearOfBirthValidator yearOfBirthValidator = new YearOfBirthValidator();

    @Test
    void isYearValidTest() {
        boolean result = yearOfBirthValidator.isYearValid(1980);
        assertTrue(result);
        boolean resultOld = yearOfBirthValidator.isYearValid(LocalDate.now().getYear() - 120);
        assertTrue(resultOld);
        boolean resultYoung = yearOfBirthValidator.isYearValid(LocalDate.now().getYear());
        assertTrue(resultYoung);
    }

    @Test
    void isYearValidOlderYearTest() {
        IllegalArgumentException iaeOlder = assertThrows(IllegalArgumentException.class,
                () -> yearOfBirthValidator.isYearValid(LocalDate.now().getYear() - 121));
        assertEquals("Not a valid year of birth: " + (LocalDate.now().getYear() - 121) + "!", iaeOlder.getMessage());
    }

    @Test
    void isYearValidYoungerYearTest() {
        IllegalArgumentException iaeYounger = assertThrows(IllegalArgumentException.class,
                () -> yearOfBirthValidator.isYearValid(LocalDate.now().getYear() + 1));
        assertEquals("Not a valid year of birth: " + (LocalDate.now().getYear() + 1) + "!", iaeYounger.getMessage());
    }

    @Test
    void isYearValidTooOldTest() {
        IllegalArgumentException iaeTooOld = assertThrows(IllegalArgumentException.class,
                () -> yearOfBirthValidator.isYearValid(2050));
        assertEquals("Not a valid year of birth: 2050!", iaeTooOld.getMessage());
    }

    @Test
    void isYearValidTooYoungTest() {
        IllegalArgumentException iaeTooYoung = assertThrows(IllegalArgumentException.class,
                () -> yearOfBirthValidator.isYearValid(1885));
        assertEquals("Not a valid year of birth: 1885!", iaeTooYoung.getMessage());
    }
}