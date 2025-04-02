package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.Player;
import com.olympic.validations.PlayerValidation;

import java.util.Scanner;

public class UpdatePasswordUI {
    public void updatePassword(Player player) {

        boolean isPasswordValid;
        Scanner scanner = ScannerBean.getScanner();
        PlayerDAOService playerDAOService = new PlayerDAOService();
        PlayerValidation playerValidation = new PlayerValidation();

        System.out.println("------------------UPDATE PASSWORD------------------");
        System.out.println("Enter the new password : ");
        String newPassword = scanner.next();
        System.out.println("Confirm the password : ");
        String confirmPassword = scanner.next();

        isPasswordValid = playerValidation.validatePassword(newPassword);
        if (!isPasswordValid) {
            System.out.println("\nNote - Password should follow below patter -\n" +
                    "Atleast one capital letter, \natleast one small letter, " +
                    "\natleast one number, \natleast one special character except hyphen, " +
                    "\nno space and length between 6 to 10 \n");
            System.out.println("Please enter the details again.\n");
            updatePassword(player);
        }

        if (newPassword.equals(confirmPassword)) {
            playerDAOService.updatePassword(player.getId(), newPassword);
            System.out.println("Password is updated successfully.");
            System.out.println("------------------------------------\n");
        } else {
            System.out.println("Password does not match. please enter password again.");
            updatePassword(player);
        }

    }
}
