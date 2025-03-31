package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.Player;

public class UpdatePasswordUI {
    public void updatePassword(Player player){
        PlayerDAOService playerDAOService = new PlayerDAOService();
        System.out.println("Enter the new password : ");
        String newPassword = ScannerBean.getScanner().next();

        player.setPassword(newPassword);
        playerDAOService.updatePassword(player);
    }
}
