package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.model.entity.Player;
import com.olympic.service.OlympicService;

import java.util.Scanner;

public class WelcomePlayerUI {
    public void welcomePlayer(Player player) {

        int userInput;

        Scanner scanner = ScannerBean.getScanner();

        UpdateProfileUI updateProfileUI = new UpdateProfileUI();
        UpdatePasswordUI updatePasswordUI = new UpdatePasswordUI();
        DeleteProfileUI deleteProfileUI = new DeleteProfileUI();
        OlympicService olympicService = new OlympicService();

        System.out.println("##########################-- OLYMPIC SERVICE APP --##########################\n");
        System.out.println("Hi " + player.getName() + ". Welcome to Olympic service application\n");
        System.out.println("Please choose below options to proceed : \n");
        System.out.println("1 - Update Profile\n2 - Update Password\n3 - Delete Profile\n4 - Logout");
        userInput = scanner.nextInt();

        switch (userInput) {
            case (1):
                updateProfileUI.updatePlayerProfile(player);
                break;
            case (2):
                updatePasswordUI.updatePassword(player);
                break;
            case (3):
                deleteProfileUI.deleteProfile(player);
                break;
            case (4):
                olympicService.homePage();
                break;
        }
        welcomePlayer(player);
    }
}
