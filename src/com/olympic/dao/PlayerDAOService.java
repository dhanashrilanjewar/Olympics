package com.olympic.dao;

import com.olympic.config.DBConfigureService;
import com.olympic.constants.QueryConstant;
import com.olympic.model.entity.Player;
import com.olympic.util.DateUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PlayerDAOService {

    public void save(Player player) {
        DBConfigureService dbConfigureService = new DBConfigureService();

        try {
            dbConfigureService.openDBConnection();

            PreparedStatement preparedStatement = dbConfigureService.getConnection().prepareStatement(QueryConstant.INSERT_PLAYER_QUERY);

            preparedStatement.setInt(1, generateSequntialID());
            preparedStatement.setString(2, player.getName());
            preparedStatement.setDate(3, DateUtil.convertUtiltoSQLDate(player.getDob()));
            preparedStatement.setString(4, player.getGame());
            preparedStatement.setString(5, player.getCountry());
            preparedStatement.setString(6, player.getUsername());
            preparedStatement.setString(7, player.getPassword());
            preparedStatement.execute();

            dbConfigureService.closeDBConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private int generateSequntialID() {
        int idSequence = 1;
        DBConfigureService dbConfigureService = new DBConfigureService();
        dbConfigureService.openDBConnection();
        try {
            PreparedStatement preparedStatement = dbConfigureService.getConnection().prepareStatement(QueryConstant.GET_LAST_PLAYER_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                idSequence = resultSet.getInt(1);
                idSequence += 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbConfigureService.closeDBConnection();
        return idSequence;
    }

    public boolean checkUsernameExists(String username) {
        boolean usernameExists = false;

        DBConfigureService dbConfigureService = new DBConfigureService();
        dbConfigureService.openDBConnection();
        try {
            PreparedStatement preparedStatement = dbConfigureService.getConnection().prepareStatement(QueryConstant.CHECK_USERNAME_EXIST_QUERY + username + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                usernameExists = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usernameExists;
    }

    public Player getPlayerByUserIDandPassword(String username, String password) {
        DBConfigureService dbConfigureService = new DBConfigureService();
        Player player = null;
        try {
            dbConfigureService.openDBConnection();
            PreparedStatement preparedStatement = dbConfigureService.getConnection().prepareStatement(QueryConstant.GET_PLAYER_BY_UNAME_PASSWORD.replace("?U", username).replace("?P", password));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                player = new Player();
                player.setId(resultSet.getInt("playerId"));
                player.setName(resultSet.getString("name"));
                player.setDob(resultSet.getDate("dob"));
                player.setGame(resultSet.getString("gameType"));
                player.setCountry(resultSet.getString("country"));
                System.out.println("Player details are : \n" + player + "\n");
            }
            dbConfigureService.closeDBConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    public Player getPlayerByUsernameandDOB(String username, String dob) {
        DBConfigureService dbConfigureService = new DBConfigureService();
        Player player = null;
        try {
            dbConfigureService.openDBConnection();
            PreparedStatement preparedStatement = dbConfigureService.getConnection().prepareStatement(QueryConstant.GET_PLAYER_BY_USERNAME_AND_DOB.replace("?U", username).replace("?D", dob));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                player = new Player();
                player.setId(resultSet.getInt("playerId"));
                player.setName(resultSet.getString("name"));
                player.setDob(resultSet.getDate("dob"));
                player.setGame(resultSet.getString("gameType"));
                player.setCountry(resultSet.getString("country"));
                player.setPassword(resultSet.getString("password"));
                //System.out.println("Player details are : \n" + player + "\n");
            }
            dbConfigureService.closeDBConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    public void updatePlayer(Player player) {
        DBConfigureService dbConfigureService = new DBConfigureService();

        try {
            dbConfigureService.openDBConnection();

            PreparedStatement preparedStatement = dbConfigureService.getConnection().prepareStatement(QueryConstant.UPDATE_PLAYER + player.getId());

            preparedStatement.setString(1, player.getName());
            preparedStatement.setDate(2, DateUtil.convertUtiltoSQLDate(player.getDob()));
            preparedStatement.setString(3, player.getGame());
            preparedStatement.setString(4, player.getCountry());
            preparedStatement.execute();

            dbConfigureService.closeDBConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePassword(Integer playerId, String password) {
        DBConfigureService dbConfigureService = new DBConfigureService();
        try {
            dbConfigureService.openDBConnection();
            PreparedStatement preparedStatement = dbConfigureService.getConnection().prepareStatement(QueryConstant.UPDATE_PASSWORD + playerId);
            preparedStatement.setString(1, password);
            preparedStatement.execute();
            dbConfigureService.closeDBConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int playerId) {
        DBConfigureService dbConfigureService = new DBConfigureService();

        try {
            dbConfigureService.openDBConnection();
            PreparedStatement preparedStatement = dbConfigureService.getConnection().prepareStatement(QueryConstant.DELETE_PLAYER + playerId);
            preparedStatement.execute();
            dbConfigureService.closeDBConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
