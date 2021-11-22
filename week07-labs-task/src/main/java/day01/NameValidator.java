package day01;

public class NameValidator {

    public boolean isNameValid(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Not a valid name: " + name + "!");
        }
        name = name.trim();
        if (!name.contains(" ")) {
            throw new IllegalArgumentException("Not a valid name: " + name + "!");
        }
        return true;
    }
}
