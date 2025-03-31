package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.Player;
import com.olympic.util.DateUtil;


public class UpdateProfileUI {

    PlayerDAOService playerDAOService;

    public void updatePlayerProfile(Player player){
        playerDAOService = new PlayerDAOService();
        ScannerBean.getScanner();
        System.out.println("Enter your name : ");
        player.setName(ScannerBean.getScanner().next());
        System.out.println("Enter you DOB : ");
        player.setDob(DateUtil.convertStringtoDate(ScannerBean.getScanner().next()));
        System.out.println("Enter Game type : ");
        player.setGame(ScannerBean.getScanner().next());
        System.out.println("Enter your country : ");
        player.setCountry(ScannerBean.getScanner().next());

        playerDAOService.updatePlayer(player);
    }
}
