package com.olympic.view;

import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.User;
import com.olympic.util.DateUtil;
import com.olympic.util.EncryptionUtil;
import com.olympic.validations.PlayerValidation;


import static com.olympic.bean.ScannerBean.readIntInput;
import static com.olympic.bean.ScannerBean.readStringInput;


public class RegisterPlayerUI {

    public void registerPlayer() {

        WelcomePlayerUI welcomePlayerUI = new WelcomePlayerUI();
        PlayerDAOService playerDAOService = new PlayerDAOService();
        User user = new User();


        if (readIntInput("Select 1 for Player and 2 for Admin - ") == 1) {
            user.setUserType("player");
            user.setName(readStringInput("Enter player name : "));
            user.setDob(DateUtil.convertStringtoDate(readStringInput("Enter player dob : ")));
            user.setGame(readStringInput("Enter player game : "));
            user.setCountry(readStringInput("Enter country of the player : "));
            user.setEmail(readStringInput("Enter email address : "));
            user.setUsername(readStringInput("Enter the username you want : "));
            user.setPassword(EncryptionUtil.encryptPassword(readStringInput("Enter the password : ")));
        } else if (readIntInput("") == 2) {
            user.setUserType("admin");
        } else {
            System.out.println("Enter correct input.");
            registerPlayer();
        }

        validateEmail(user.getEmail());
        validatePassword(user.getPassword());
        validateUsername(user.getUsername());

        playerDAOService.save(user);
        System.out.println("Congratulations! Registration is successful.\n");
        welcomePlayerUI.welcomePlayer(user);
    }

    private void validateUsername(String username) {
        if (new PlayerDAOService().checkUsernameExists(username)) {
            System.out.println("Username already exist. Please enter different username.");
            registerPlayer();
        }
    }

    private void validateEmail(String email) {
        if (!new PlayerValidation().validateEmail(email)) {
            System.out.println("Invalid email id, please enter valid email id");
            System.out.println("\n");
            registerPlayer();
        }
    }

    private void validatePassword(String password) {
        if (!new PlayerValidation().validatePassword(password)) {
            System.out.println("\nNote - Password should follow below patter -\n" +
                    "Atleast one capital letter, \natleast one small letter, " +
                    "\natleast one number, \natleast one special character except hyphen, " +
                    "\nno space and length between 6 to 10 \n");
            System.out.println("Please enter the details again.\n");
            registerPlayer();
        }

    }
}
