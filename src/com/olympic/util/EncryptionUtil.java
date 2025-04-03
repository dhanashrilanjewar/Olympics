package com.olympic.util;

import com.olympic.dao.PlayerDAOService;
import com.olympic.model.entity.User;

import java.util.Base64;

public class EncryptionUtil {

    public static String encryptPassword(String password){
        String encryptedPassword;
        encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return encryptedPassword;
    }

    public static String decryptPassword(String username){
        PlayerDAOService playerDAOService = new PlayerDAOService();

        String decryptedPassword;
        byte[] decodedBytes = Base64.getDecoder().decode(playerDAOService.getPlayerPasswordByUsername(username));
        decryptedPassword = new String(decodedBytes);
        return decryptedPassword;
    }
}
