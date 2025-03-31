package com.olympic.service;

import com.olympic.bean.ScannerBean;
import com.olympic.view.LoginPlayerUI;
import com.olympic.view.RegisterPlayerUI;

import java.util.Scanner;

public class OlympicService {

    private final RegisterPlayerUI registerPlayerUI = new RegisterPlayerUI();//Local
    private final LoginPlayerUI loginPlayerUI = new LoginPlayerUI();//Local
    private Integer userInput;//Local

    public void homePage() {
        Scanner scanner = ScannerBean.getScanner();
        System.out.println("Please enter 1 for SignUp and 2 for Login");
        if (scanner.hasNextInt()) {
            userInput = scanner.nextInt();
        }

        switch (userInput) {
            case (1):
                registerPlayerUI.registerPlayer();
                break;
            case (2):
                loginPlayerUI.loginPlayer();
                break;
        }
        scanner.close();
        userInput = null;
    }

}