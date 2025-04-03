package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.User;
import com.olympic.util.EncryptionUtil;
import java.util.Scanner;

public class LoginPlayerUI {

    public void loginPlayer() {

        String username, decryptedPassword, password;
        Scanner scanner = ScannerBean.getScanner();

        PlayerDAOService playerDAOService = new PlayerDAOService();
        WelcomePlayerUI welcomePlayerUI = new WelcomePlayerUI();

        System.out.println("------------------LOGIN PAGE------------------");
        System.out.println("Enter the username : ");
        username = scanner.next();
        System.out.println("Enter the password : ");
        password = scanner.next();

        User user = playerDAOService.getPlayerByUserIDandPassword(username, EncryptionUtil.encryptPassword(password));

        if (user != null) {
            welcomePlayerUI.welcomePlayer(user);
        } else {
            System.out.println("Enter correct username and password.");
            loginPlayer();
        }
    }
}