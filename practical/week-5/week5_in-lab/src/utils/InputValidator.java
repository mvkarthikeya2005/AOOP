// File: src/utils/InputValidator.java
package utils;

public class InputValidator {
    public static boolean isValidName(String name) {
        return name != null && name.matches("^[a-zA-Z ]+$");
    }

    public static boolean isValidId(int id) {
        return id > 0;
    }
}
