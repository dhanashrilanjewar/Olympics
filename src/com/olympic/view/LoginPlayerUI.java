package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.Player;

import java.util.Scanner;

public class LoginPlayerUI {

    public void loginPlayer() {
        String username, password;

        PlayerDAOService playerDAOService = new PlayerDAOService();
        WelcomePlayerUI welcomePlayerUI = new WelcomePlayerUI();

        Scanner scanner = ScannerBean.getScanner();

        System.out.println("enter the username : ");
        username = scanner.next();
        System.out.println("enter the password : ");
        password = scanner.next();

        Player player = playerDAOService.getPlayerByUserIDandPassword(username, password);

        if (player != null) {
            System.out.println("login successfully!");
            welcomePlayerUI.welcomePlayer(player);
        } else {
            System.out.println("Enter correct username and password.");
            loginPlayer();
        }
    }
}