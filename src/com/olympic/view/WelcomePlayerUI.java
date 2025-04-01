package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.model.entity.Player;

import java.util.Scanner;

public class WelcomePlayerUI {
    public void welcomePlayer(Player player) {

        int userinput;

        UpdateProfileUI updateProfileUI = new UpdateProfileUI();
        UpdatePasswordUI updatePasswordUI = new UpdatePasswordUI();
        DeleteProfileUI deleteProfileUI = new DeleteProfileUI();
        LoginPlayerUI loginPlayerUI = new LoginPlayerUI();

        Scanner scanner = ScannerBean.getScanner();

        System.out.println("Hi "+player.getName()+". Welcome to Olympic service application");
        System.out.println("Please choose below options to proceed : ");
        System.out.println("1 - Update Profile\n2 - Update Password\n3 - Delete Profile\n4 - Logout");
        userinput = scanner.nextInt();

        switch (userinput) {
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
                loginPlayerUI.loginPlayer();
                break;
        }
        welcomePlayer(player);
    }
}
