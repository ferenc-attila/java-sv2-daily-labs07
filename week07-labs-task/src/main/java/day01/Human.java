package day01;

public class Human {

    YearOfBirthValidator yearOfBirthValidator = new YearOfBirthValidator();
    NameValidator nameValidator = new NameValidator();
    private String name;
    private int yearOfBirth;

    public Human(String name, int yearOfBirth) {
        if (nameValidator.isNameValid(name) && yearOfBirthValidator.isYearValid(yearOfBirth)) {
            name = name.trim();
            this.name = name;
            this.yearOfBirth = yearOfBirth;
        }
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
