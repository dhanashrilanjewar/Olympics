package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.Player;
import com.olympic.util.DateUtil;

import java.util.Scanner;


public class UpdateProfileUI {

    PlayerDAOService playerDAOService;
    Scanner scanner = ScannerBean.getScanner();

    public void updatePlayerProfile(Player player){
        playerDAOService = new PlayerDAOService();

        System.out.println("Enter your name : ");
        player.setName(scanner.next());
        System.out.println("Enter you DOB : ");
        player.setDob(DateUtil.convertStringtoDate(scanner.next()));
        System.out.println("Enter Game type : ");
        player.setGame(scanner.next());
        System.out.println("Enter your country : ");
        player.setCountry(scanner.next());

        playerDAOService.updatePlayer(player);
        System.out.println("Player profile is updated");
    }
}
