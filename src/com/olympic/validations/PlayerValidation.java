package com.olympic.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerValidation {
    Matcher matcher;
    Pattern passwordPattern;
    Pattern emailPattern;

    public boolean validatePassword(String password) {
        String regex_password = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z\\d\\-])[^\\s-]{6,10}$";
        passwordPattern = Pattern.compile(regex_password);
        matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    public boolean validateEmail(String email) {
        String regex_email = "^[a-z][a-z0-9]{5,12}@[a-z]{3,10}\\.[a-z]{1,3}$";
        emailPattern = Pattern.compile(regex_email);
        matcher = emailPattern.matcher(email);
        return matcher.matches();
    }
}
