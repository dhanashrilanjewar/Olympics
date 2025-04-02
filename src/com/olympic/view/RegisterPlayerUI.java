package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.Player;
import com.olympic.util.DateUtil;
import com.olympic.validations.PlayerValidation;

import java.util.Scanner;


public class RegisterPlayerUI {

    public void registerPlayer() {

        Scanner scanner = ScannerBean.getScanner();
        boolean isPasswordValid;

        Player player = new Player();

        WelcomePlayerUI welcomePlayerUI = new WelcomePlayerUI();
        PlayerDAOService playerDAOService = new PlayerDAOService();
        PlayerValidation playerValidation = new PlayerValidation();

        System.out.println("Enter player name : ");
        player.setName(scanner.nextLine());
        System.out.println("Enter player dob : ");
        player.setDob(DateUtil.convertStringtoDate(scanner.nextLine()));
        System.out.println("Enter player game : ");
        player.setGame(scanner.nextLine());
        System.out.println("Enter country of the player : ");
        player.setCountry(scanner.nextLine());
        System.out.println("Enter the username you want : ");
        player.setUsername(scanner.nextLine());
        System.out.println("Enter the password : ");
        player.setPassword(scanner.nextLine());

        isPasswordValid = playerValidation.validatePassword(player.getPassword());

        if (!isPasswordValid) {
            System.out.println("\nNote - Password should follow below patter -\n" +
                    "Atleast one capital letter, \natleast one small letter, " +
                    "\natleast one number, \natleast one special character except hyphen, " +
                    "\nno space and length between 6 to 10 \n");
            System.out.println("Please enter the details again.\n");
            registerPlayer();
        }

        if (!playerDAOService.checkUsernameExists(player.getUsername())) {
            playerDAOService.save(player);
            System.out.println("Congratulations! Registration is successful.\n");

            welcomePlayerUI.welcomePlayer(player);
        } else {
            System.out.println("Username already exist. Please enter different username.");
            registerPlayer();
        }
    }
}
