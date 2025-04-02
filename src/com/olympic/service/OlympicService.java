package com.olympic.service;

import com.olympic.bean.ScannerBean;
import com.olympic.view.ForgotPasswordUI;
import com.olympic.view.LoginPlayerUI;
import com.olympic.view.RegisterPlayerUI;

import java.util.Scanner;

public class OlympicService {
    Integer userInput;

    public void homePage() {

        Scanner scanner = ScannerBean.getScanner();

        RegisterPlayerUI registerPlayerUI = new RegisterPlayerUI();
        LoginPlayerUI loginPlayerUI = new LoginPlayerUI();
        ForgotPasswordUI forgotPasswordUI = new ForgotPasswordUI();

        System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*");
        System.out.println("----------Welcome to Olympic App----------");
        System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*");
        System.out.println("\nPlease enter \n  1 for SignUp \n  2 for Login \n  3 forgot Password");
        userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                System.out.println("----------REGISTRATION FORM----------");
                registerPlayerUI.registerPlayer();
                break;
            case 2:
                loginPlayerUI.loginPlayer();
                break;
            case 3:
                forgotPasswordUI.forgotPassword();
                break;
        }
        scanner.close();
        userInput = null;
    }
}