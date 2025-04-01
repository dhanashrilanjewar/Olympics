package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.Player;

import java.util.Scanner;

public class UpdatePasswordUI {
    public void updatePassword(Player player){
        PlayerDAOService playerDAOService = new PlayerDAOService();
        Scanner scanner = ScannerBean.getScanner();

        System.out.println("Enter the new password : ");
        String newPassword = scanner.next();
        System.out.println("Confirm the password : ");
        String confirmPassword = scanner.next();

        if(newPassword.equals(confirmPassword)){
            playerDAOService.updatePassword(player.getId(), newPassword);
            System.out.println("Password is updated successfully.");
        }else {
            System.out.println("Password does not match. please enter password again.");
            updatePassword(player);
        }

    }
}
