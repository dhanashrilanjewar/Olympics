package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.Player;
import com.olympic.service.OlympicService;
import com.olympic.util.DateUtil;

import java.util.Date;
import java.util.Scanner;

public class ForgotPasswordUI {
    public void forgotPassword() {
        Scanner scanner = ScannerBean.getScanner();
        PlayerDAOService playerDAOService = new PlayerDAOService();
        OlympicService olympicService = new OlympicService();
        Player player;
        String username;
        String dob;

        System.out.println("------------------FORGOT PASSWORD------------------\n");
        System.out.println("Enter username : ");
        username = scanner.nextLine();
        System.out.println("Enter player dob : ");
        dob = scanner.nextLine();
        //dob = DateUtil.convertStringtoDate(scanner.nextLine());


        player = playerDAOService.getPlayerByUsernameandDOB(username, dob);
        if (player != null) {
            System.out.println("Your password is : " + player.getPassword()+"\n");
            olympicService.homePage();
        } else {
            System.out.println("User not found. Enter correct username and DOB");
            System.out.println("-----------------------------------------------\n");
            olympicService.homePage();
        }
    }
}
