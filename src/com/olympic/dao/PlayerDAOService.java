package com.olympic.dao;

import com.olympic.config.DBConfigureService;
import com.olympic.constants.QueryConstant;
import com.olympic.model.entity.User;
import com.olympic.util.DateUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAOService {

    public void save(User user) {
        DBConfigureService dbConfigureService = new DBConfigureService();

        try {
            dbConfigureService.openDBConnection();

            PreparedStatement preparedStatement = dbConfigureService.getConnection().prepareStatement(QueryConstant.INSERT_PLAYER_QUERY);

            preparedStatement.setInt(1, generateSequntialID());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setDate(3, DateUtil.convertUtiltoSQLDate(user.getDob()));
            preparedStatement.setString(4, user.getGame());
            preparedStatement.setString(5, user.getCountry());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getUsername());
            preparedStatement.setString(8, user.getPassword());
            preparedStatement.setString(9,user.getUserType());
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

    public User getPlayerByUserIDandPassword(String username, String password) {
        DBConfigureService dbConfigureService = new DBConfigureService();
        User user = null;
        try {
            dbConfigureService.openDBConnection();
            PreparedStatement preparedStatement = dbConfigureService.getConnection().prepareStatement(QueryConstant.GET_PLAYER_BY_UNAME_PASSWORD.replace("?U", username).replace("?P", password));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("playerId"));
                user.setName(resultSet.getString("name"));
                user.setDob(resultSet.getDate("dob"));
                user.setGame(resultSet.getString("gameType"));
                user.setCountry(resultSet.getString("country"));
                user.setEmail(resultSet.getString("email"));
                System.out.println("Player details are : \n" + user + "\n");
            }
            dbConfigureService.closeDBConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getPlayerByUsernameandDOB(String username, String dob) {
        DBConfigureService dbConfigureService = new DBConfigureService();
        User user = null;
        try {
            dbConfigureService.openDBConnection();
            PreparedStatement preparedStatement = dbConfigureService.getConnection().prepareStatement(QueryConstant.GET_PLAYER_BY_USERNAME_AND_DOB.replace("?U", username).replace("?D", dob));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("playerId"));
                user.setName(resultSet.getString("name"));
                user.setDob(resultSet.getDate("dob"));
                user.setGame(resultSet.getString("gameType"));
                user.setCountry(resultSet.getString("country"));
                user.setPassword(resultSet.getString("password"));
                //System.out.println("Player details are : \n" + player + "\n");
            }
            dbConfigureService.closeDBConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public String getPlayerPasswordByUsername(String username) {
        DBConfigureService dbConfigureService = new DBConfigureService();
        User user = null;
        try {
            dbConfigureService.openDBConnection();
            PreparedStatement preparedStatement = dbConfigureService.getConnection().prepareStatement(QueryConstant.GET_PLAYER_BY_USERNAME+username+"'");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setPassword(resultSet.getString("password"));
            }
            dbConfigureService.closeDBConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user.getPassword();
    }

    public void updatePlayer(User user) {
        DBConfigureService dbConfigureService = new DBConfigureService();

        try {
            dbConfigureService.openDBConnection();

            PreparedStatement preparedStatement = dbConfigureService.getConnection().prepareStatement(QueryConstant.UPDATE_PLAYER + user.getId());

            preparedStatement.setString(1, user.getName());
            preparedStatement.setDate(2, DateUtil.convertUtiltoSQLDate(user.getDob()));
            preparedStatement.setString(3, user.getGame());
            preparedStatement.setString(4, user.getCountry());
            preparedStatement.setString(5, user.getEmail());
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
