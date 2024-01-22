package ui;
import java.util.Scanner;
import mancala.Player;
import mancala.MancalaGame;
import mancala.Saver;
//import mancala.PitNotFoundException;
import mancala.InvalidMoveException;

public class TextUI {
    public static void test(Scanner input, MancalaGame game){
        int num = 0;
        try{
            System.out.println("it is turn of "+game.getCurrentPlayer().getName());
            System.out.println("Enter pit number: ");
            num = input.nextInt();
            game.move(num);        
        }catch(InvalidMoveException err){
            System.out.println(err.getMessage()+" invalid move "+num);
        }
    }

    public static void main(String[]args){
        MancalaGame game = new MancalaGame();
    //   System.out.println("ayo or kalah, it is ayo hardcoded");
        game.setRules(1);
        //System.out.println("Save or lload prgram, saving now ");
        int num =0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter player 1 name: ");
        String name1 = input.nextLine();

        Player player1 = new Player();
        player1.setName(name1);
        System.out.println("Enter player 2 name: ");
        String name2 = input.nextLine();
        Player player2 = new Player();
        player2.setName(name2);
        game.setPlayers(player1, player2);
    //    System.out.println("which version?");
        game.setRules(1);
        game.startNewGame();

        while(!game.isGameOver()){
            test(input, game);
        //     System.out.println("jjkajkaj");
        //     System.out.print("Do you want to save the game? (yes/no): ");
        //  //   String saveInput = input.nextLine();
        //     //if ("yes".equalsIgnoreCase("yes")) {
        //     //System.out.print("Enter file name: ");
        //     String filename = input.nextLine();
        //     Saver save = new Saver();
        //     save.saveObject("hi", "assets.ser");
            //Saver objectSave = new Saver();
           // objectSave.saveObject();
          //  game.saveGame(filename);

        //    System.out.println("Game saved.");
            //}
        
        // System.out.print("Do you want to save the game? (yes/no): ");
        // String saveInput = input.nextLine();
        // if ("yes".equalsIgnoreCase(saveInput.trim())) {
        //     System.out.print("Enter file name: ");
        //     String filename = input.nextLine();
        //     //Saver objectSave = new Saver();
        //    // objectSave.saveObject();
        //     game.saveGame(filename);
        //     System.out.println("Game saved.");
        // }
        }
    }    
}
