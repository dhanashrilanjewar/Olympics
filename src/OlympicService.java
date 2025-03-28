import java.util.Scanner;

public class OlympicService {

    private Scanner scanner = new Scanner(System.in);
    OlympicServiceDB olympicServiceDB = new OlympicServiceDB();
    Player player = new Player();
    private int userInput;

    public void startOlympicApp(){

        System.out.println("Select below option to proceed : " +
                "\n 1-Register Player." +
                "\n 2-Get player detail." +
                "\n 3-Delete player detail" +
                "\n 4-Logout");

        userInput = scanner.nextInt();
        switch (userInput){
            case (1): registerPlayer();
                break;
            case (2): getPlayerDetails();
                break;
            case (3): removePlayer();
                break;
            case (4): logout();
            break;
        }startOlympicApp();
    }

    public void signUpandLogin(){
        System.out.println("Please enter 1 for SignUp and 2 for Login");
        userInput = scanner.nextInt();
        switch (userInput){
            case (1) : registerPlayer();
            break;
            case (2) : loginPlayer();
            break;
        }
        startOlympicApp();
    }

    private void loginPlayer(){
        String uname,password;
        System.out.println("enter the username : ");
        uname = scanner.next();
        System.out.println("enter the password : ");
        password = scanner.next();

        olympicServiceDB.login(uname,password);
    }

    private void logout(){
        System.exit(1);
    }

    private void registerPlayer(){
        System.out.println("Enter player id : ");
        player.setId(scanner.nextInt());
        System.out.println("Enter player name : ");
        player.setName(scanner.next());
        System.out.println("Enter player age : ");
        player.setAge(scanner.nextInt());
        System.out.println("Enter player game : ");
        player.setGame(scanner.next());
        System.out.println("Enter country of the player : ");
        player.setCountry(scanner.next());
        System.out.println("Enter the username you want : ");
        player.setUsername(scanner.next());
        System.out.println("Enter the password : ");
        player.setPassword(scanner.next());
        olympicServiceDB.savePlayerDetails(player.getId(),player.getName(),player.getAge(),player.getGame(),player.getCountry(),player.getUsername(),player.getPassword());
        startOlympicApp();
    }

    private void getPlayerDetails(){
        System.out.println("Enter the player id to get details : ");
        player.setId(scanner.nextInt());
        olympicServiceDB.getPlayerDetailsDB(player.getId());
    }

    private void removePlayer(){
        System.out.println("Enter the player id whom you want to remove : ");
        player.setId(scanner.nextInt());
        olympicServiceDB.removePlayerDetailsDB(player.getId());
    }


}