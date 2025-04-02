package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.Player;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginPlayerUI {

    public void loginPlayer() {

        String username, password;
        Scanner scanner = ScannerBean.getScanner();

        PlayerDAOService playerDAOService = new PlayerDAOService();
        WelcomePlayerUI welcomePlayerUI = new WelcomePlayerUI();

        System.out.println("------------------LOGIN PAGE------------------");
        System.out.println("Enter the username : ");
        username = scanner.next();
        System.out.println("Enter the password : ");
        password = scanner.next();

        Player player = playerDAOService.getPlayerByUserIDandPassword(username, password);

        if (player != null) {
            welcomePlayerUI.welcomePlayer(player);
        } else {
            System.out.println("Enter correct username and password.");
            loginPlayer();
        }
    }
}