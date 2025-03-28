import java.sql.*;

public class OlympicServiceDB {

    private final static String INSERT_QUERY = "insert into olympicgame (pId, pName, pAge, pGame, pCountry, pUsername, pPassword) values (?,?,?,?,?,?,?)";
    private final static String RETRIEVE_QUERY = "select * from olympicgame where pId=";
    private final static String DELETEQUERY = "delete from olympicgame where pId=";

    Player player = new Player();

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private String DBUrl = "jdbc:mysql://localhost:3306/db1";
    private String mysqlDriver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String password = "";

    public Connection openDBConnection(){
        try{
            System.out.println("register class");
            Class.forName(mysqlDriver);
            System.out.println("class registered");

            System.out.println("getconnection");
            connection = DriverManager.getConnection(DBUrl,user,password);
            System.out.println("get connection done");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public void closeDBConnection(){
        try{
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void login(String uname, String password){
        String searchQuery = "select * from olympicgame where pUsername='"+uname+"' and pPassword='"+password+"'";
        openDBConnection();
        try{
            preparedStatement = connection.prepareStatement(searchQuery);
            preparedStatement.execute();
            if(preparedStatement !=null){
                OlympicService olympicService = new OlympicService();
                olympicService.startOlympicApp();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void savePlayerDetails(int id, String name, int age, String game, String country, String username, String password){
        try{
            System.out.println("saving player..");
            openDBConnection();
            System.out.println("prepared staement statrt");
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            System.out.println("preparedstatement end");
            System.out.println("set params");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setInt(3,age);
            preparedStatement.setString(4,game);
            preparedStatement.setString(5,country);
            preparedStatement.setString(6,username);
            preparedStatement.setString(7,password);
            System.out.println("set params done");
            System.out.println("execute prepared statement");
            preparedStatement.execute();
            System.out.println("player saved");
            closeDBConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Player is registered successfully.");
    }

    public void getPlayerDetailsDB(int userInputId){
        try{
            openDBConnection();
            preparedStatement = connection.prepareStatement(RETRIEVE_QUERY+userInputId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                player.setId(resultSet.getInt("pId"));
                player.setName(resultSet.getString("pName"));
                player.setAge(resultSet.getInt("pAge"));
                player.setGame(resultSet.getString("pGame"));
                player.setCountry(resultSet.getString("pCountry"));
                System.out.println("Player details are : \n"+player.getId()+"\n"+player.getName()+"\n"+player.getAge()+"\n"+player.getGame()+"\n"+player.getCountry());
            }
            closeDBConnection();
            System.out.println("Player details are fetched...");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removePlayerDetailsDB(int id){
        try{
            openDBConnection();
            preparedStatement = connection.prepareStatement(DELETEQUERY+id);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Player is removed successfully...");
        closeDBConnection();
    }
}
