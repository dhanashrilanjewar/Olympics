package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.User;
import com.olympic.util.DateUtil;
import com.olympic.validations.PlayerValidation;

import java.util.Scanner;


public class UpdateProfileUI {

    public void updatePlayerProfile(User user) {

        Scanner scanner = ScannerBean.getScanner();
        boolean isEmailValid;
        PlayerDAOService playerDAOService = new PlayerDAOService();
        PlayerValidation playerValidation = new PlayerValidation();

        System.out.println("------------------UPDATE PROFILE------------------");
        System.out.println("Enter your name : ");
        user.setName(scanner.next());
        System.out.println("Enter you DOB : ");
        user.setDob(DateUtil.convertStringtoDate(scanner.next()));
        System.out.println("Enter Game type : ");
        user.setGame(scanner.next());
        System.out.println("Enter your country : ");
        user.setCountry(scanner.next());
        System.out.println("Enter your email : ");
        user.setEmail(scanner.next());

        isEmailValid = playerValidation.validateEmail(user.getEmail());
        if(!isEmailValid){
            System.out.println("Invalid email id, please enter valid email id");
            System.out.println("\n");
            updatePlayerProfile(user);
        }

        playerDAOService.updatePlayer(user);
        System.out.println("Player profile is updated");
        System.out.println("------------------------------------\n");
    }
}
