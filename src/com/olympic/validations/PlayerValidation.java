package com.olympic.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerValidation {
    public boolean validatePassword(String password) {
        Matcher matcher;
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z\\d\\-])[^\\s-]{6,10}$";
        Pattern passwordPattern = Pattern.compile(regex);
        matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }
}
