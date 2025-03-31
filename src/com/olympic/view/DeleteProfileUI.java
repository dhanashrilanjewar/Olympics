package com.olympic.view;

import com.olympic.bean.ScannerBean;
import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.Player;

public class DeleteProfileUI {
    public void deleteProfile(Player player) {

        WelcomePlayerUI welcomePlayerUI = new WelcomePlayerUI();
        PlayerDAOService playerDAOService = new PlayerDAOService();
        LoginPlayerUI loginPlayerUI = new LoginPlayerUI();

        int userInput = 0;

        System.out.println("Do you really want to delete your profile?\n1 - Yes\n2 - No");
        userInput = ScannerBean.getScanner().nextInt();

        switch (userInput) {
            case (1):
                playerDAOService.delete(player);
                loginPlayerUI.loginPlayer();
                break;
            case (2):
                welcomePlayerUI.welcomePlayer(player);
                break;
        }
    }
}
