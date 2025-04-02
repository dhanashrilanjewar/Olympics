package com.olympic.constants;

public class QueryConstant {

    public final static String INSERT_PLAYER_QUERY = "insert into player (playerId, name, dob, gameType, country, username, password) values (?,?,?,?,?,?,?)";
    public static String GET_PLAYER_BY_PLAYERID_QUERY = "select * from player where playerId=";
    public final static String DELETE_PLAYER_BY_PLAYERID_QUERY = "delete from player where playerId=";
    public final static String GET_PLAYER_BY_UNAME_PASSWORD = "select * from player where username='?U' and password= '?P'";
    public final static String GET_LAST_PLAYER_ID = "select playerId from player order by playerId desc limit 1;";
    public final static String CHECK_USERNAME_EXIST_QUERY = "select playerId from player where username='";
    public final static String DELETE_PLAYER = "delete from player where playerId=";
    public final static String UPDATE_PLAYER = "update player set name=?, DOB=?, gameType=?, country=? where playerId=";
    public final static String UPDATE_PASSWORD = "update player set password=? where playerId=";
    public final static String GET_PLAYER_BY_USERNAME_AND_DOB = "select * from player where username='?U' and DOB= '?D'";
}
