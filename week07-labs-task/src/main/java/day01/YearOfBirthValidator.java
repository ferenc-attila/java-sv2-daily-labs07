package day01;

import java.time.LocalDate;

public class YearOfBirthValidator {

    public boolean isYearValid(int yearOfBirth) {
        int year = LocalDate.now().getYear();
        if (yearOfBirth < year - 120 || yearOfBirth > year) {
            throw new IllegalArgumentException("Not a valid year of birth: " + yearOfBirth + "!");
        }
        return true;
    }
}
