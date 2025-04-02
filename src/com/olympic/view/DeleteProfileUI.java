package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.Player;

public class DeleteProfileUI {
    public void deleteProfile(Player player) {

        int userInput;

        WelcomePlayerUI welcomePlayerUI = new WelcomePlayerUI();
        PlayerDAOService playerDAOService = new PlayerDAOService();
        RegisterPlayerUI registerPlayerUI = new RegisterPlayerUI();

        System.out.println("------------------DELETE PROFILE------------------");
        System.out.println("Do you really want to delete your profile?\n1 - Yes\n2 - No");
        userInput = ScannerBean.getScanner().nextInt();

        switch (userInput) {
            case (1):
                playerDAOService.delete(player.getId());
                System.out.println("Player is deleted.");
                System.out.println("------------------------------------\n");
                registerPlayerUI.registerPlayer();
                break;
            case (2):
                welcomePlayerUI.welcomePlayer(player);
                break;
        }
    }
}
