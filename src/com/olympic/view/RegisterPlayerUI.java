package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.Player;
import com.olympic.util.DateUtil;

import java.util.Scanner;


public class RegisterPlayerUI {
    PlayerDAOService playerDAOService;
    WelcomePlayerUI welcomePlayerUI;


    public Player registerPlayer() {
        welcomePlayerUI = new WelcomePlayerUI();
        Scanner scanner = ScannerBean.getScanner();
        playerDAOService = new PlayerDAOService();

        Player player = new Player();
        System.out.println("Enter player name : ");
        player.setName(scanner.next());
        System.out.println("Enter player dob : ");
        player.setDob(DateUtil.convertStringtoDate(scanner.next()));
        System.out.println("Enter player game : ");
        player.setGame(scanner.next());
        System.out.println("Enter country of the player : ");
        player.setCountry(scanner.next());
        System.out.println("Enter the username you want : ");
        player.setUsername(scanner.next());
        System.out.println("Enter the password : ");
        player.setPassword(scanner.next());

        if (!playerDAOService.checkUsernameExists(player.getUsername())) {
            playerDAOService.save(player);
            welcomePlayerUI.welcomePlayer(player);
        } else {
            System.out.println("Username already exist. Please enter different username.");
            registerPlayer();
        }
        System.out.println("Player Registered Successfully....");
        return player;
    }
}
