package mancala;
import java.util.ArrayList;
import java.util.List;
//import java.util.Objects;
import java.util.logging.Logger;
import java.io.Serializable;
//import java.io.ObjectOutputStream;
//import java.io.ObjectInputStream;
//import java.io.IOException;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;

public class MancalaGame implements Serializable{
    private static final long serialVersionUID = 1L;
   // private String filepath = "./assets";
    final private List<Player> gamePlayers = new ArrayList<>();
    
    private Player one;
    private Player two;
    private Player curr;
    private int counter=0;
    private int total = 0;
   // private Board gameBoard = new Board();
    //private GameRules gameBoard = new GameRules();
    private MancalaDataStructure gameBoard;// = new MancalaDataStructure();
    private GameRules game;
    private AyoRules ayoRules;
    private KalahRules kalahRules;
    private Saver saves;
    private int rule = 0;
    Logger log = Logger.getLogger(MancalaGame.class.getName());
    public MancalaGame(){
       // one = new Player();
       // two = new Player();
    //    setPlayers(one, two);
        curr = one;
        gameBoard = new MancalaDataStructure(4);
       
    }
    public void setPlayerTurn(final int player){
        if(player==1){
        //    System.out.println("in player=1 ");
            setCurrentPlayer(one);
        }
        if(player==2){
         //   System.out.println("in player=2 ");
            setCurrentPlayer(two);
        }
    }
    public MancalaDataStructure getGame(){
      //  System.out.println("pit num plus stone 1 "+gameBoard.getNumStones(1));
        return gameBoard;
    }
    public void setRules(final int rules){
        rule = rules;
        if(rules==1){
            game = new KalahRules(this);
        //    System.out.println("here 1");
            gameBoard = game.getDataStructure();
        }
        else{
            game = new AyoRules(this);
        }
        //System.out.println("here 3");
        gameBoard = game.getDataStructure();
        //setPlayers(one, two);
    }
    // public MancalaGame(String name1, String name2)
    // private Board gameBoard = new Board();

    public void setPlayers(final Player onePlayer, final Player twoPlayer){
        one = onePlayer;
        two = twoPlayer;
        gamePlayers.add(one);
        //game.setPlayer(1);
     //   gamePlayers.get(0).setName(name1);
        gamePlayers.add(two);
        curr = gamePlayers.get(0);

    //    two = gamePlayers.get(1);
       // setBoard(gameBoard);
    }
     
    public ArrayList<Player> getPlayers(){
     //   return gamePlayers;
        ArrayList<Player> playersArrayList = new ArrayList<>(gamePlayers);
        return playersArrayList;//convertListToArrayList(gamePlayers);

    }
    public Player getCurrentPlayer(){
       // if(b.getP1Turn()){
       //     return one;
       // }

        return curr;
    }
    // public Player getPlayerInt(int player){
    // }
    public void registerPlayers(final Player one, final Player two){
        game.registerPlayers(one, two);
    }
    private int getIntPlayer(final Player player){
        if(player==one){
            return 1;
        }
        return 2;
    }
    // public void currentPlayer(int player){
    // }
    public void setCurrentPlayer(final Player player){
        curr = player;
     //   System.out.println("what is current "+curr);
    }
    public void setBoard(final GameRules theBoard){
        game = theBoard;
       // gameBoard.initializeBoard();
    }
    public GameRules getBoard(){
       // gameBoard.printBoard();
        return game;
    }
    public int getNumStones(final int pitNum)throws PitNotFoundException{
      //  System.out.println("pit "+pitNum+ gameBoard.getNumStones(pitNum));
        if(pitNum < 1 || pitNum > 12){
            throw new PitNotFoundException(pitNum+" is not valid pit");
        }
             //   System.out.println("456this "+ gameBoard.getNumStones(pitNum));
                return gameBoard.getNumStones(pitNum);
        // throw new PitNotFoundException("cannot find "+pitNum);
    }
    public int move(final int startPit)throws InvalidMoveException{
        total = 0;
        if (curr == one && (startPit < 1 || startPit > 6)) {
            throw new InvalidMoveException("Invalid move for Player 1.");
        }else if (curr == two && (startPit < 7 || startPit > 12)) {
            throw new InvalidMoveException("Invalid move for Player 2.");
        }
        try {
            final int numStones = getNumStones(startPit);
            if (numStones == 0) {
                throw new InvalidMoveException("Selected pit is empty. Invalid move.");
            }
            
            final int num = game.moveStones(startPit, getIntPlayer(curr));
        //    System.out.println("is this zero?? "+gameBoard.getStoreCount(1));

            if(game.isSideEmpty(1) || game.isSideEmpty(7)){
                try{
                    final Player winner = getWinner();
                    if(winner == null){
                        System.out.println("Game over. It's a tie!");
                    //    log.fine("Game over. It's a tie!");
                    }else{
                        System.out.println("Game over. " + winner.getName() + " is the winner!");
                       //log.fine("Game over. " + getPlayerName(winner) + " is the winner!");
                       // System.out.println("Game over. " + getPlayerName(winner) + " is the winner!");
                    }
                }catch(GameNotOverException err){
                    System.out.println("game not over");
                    //log.fine("game not over");
                }
            }
        }catch (PitNotFoundException err) {
            err.getMessage();
        }
    return total;
    }
    public String getPlayerName(final Player player1){
        return player1.getName();
    }
    //     return stores.getStoneCount();
    // }
    public int getStoreCount(final Player player)throws NoSuchPlayerException{
        int num;
        if (player.equals(one)) {
      //  if (player == one){
            //num = stones(gameBoard);
            num = gameBoard.getStoreCount(1);
            //num = gameBoard.getStores().get(0).getTotalStones();
            return num;
    //    }else if(player == two){
        }else if (player.equals(two)) {
            //num = gameBoard.getStores().get(1).getTotalStones();
            //num = stones(gameBoard);
            num = gameBoard.getStoreCount(2);
            return num;
        }else{
            throw new NoSuchPlayerException("player does not exist");
        }
        //return player.getStoreCount();
    }
    private void emptyPits(){
        int stoneNum = 0;
        int loopCounter = 0;
        for(loopCounter=1; loopCounter<7; loopCounter++){
            stoneNum = gameBoard.removeStones(loopCounter);
            gameBoard.addToStore(1, stoneNum);
        }
        for(loopCounter=7; loopCounter<13; loopCounter++){
            stoneNum = gameBoard.removeStones(loopCounter);
            gameBoard.addToStore(2, stoneNum);
        }
    }
    public Player getWinner()throws GameNotOverException{ //isgameover
        if (!isGameOver()){
            throw new GameNotOverException("Game is not over");
        }
        try {
            emptyPits();
            if(getStoreCount(one)>getStoreCount(two)){
                return one;
            }else if(getStoreCount(one)<getStoreCount(two)){
                return two;
            }
        }catch (NoSuchPlayerException err){
           // System.out.println(err.getMessage());
         //   log.fine(err.getMessage());
            err.getMessage();
        }
        return null;
    }
    public boolean isGameOver(){
       // try{
        return game.isSideEmpty(1) || game.isSideEmpty(7);
            // if(gameBoard.isSideEmpty(1) || gameBoard.isSideEmpty(7)){
      //  }
      //  return false;
    }
    // public void saveGame(String filepath){
    //     saves.saveObject(getBoard(), filepath);
    // }
    public void startNewGame(){
        game.resetBoard();
        // if(rule==1){
      //  gameBoard = new MancalaDataStructure();//game.getDataStructure();
    }
   // @Override
    // @Override
    // public Serializable loadObject(final String filename){
    // }
    @Override 
    public String toString() {
       // return getCurrentPlayer().getName()+" is current player";
        return getPlayerName(getCurrentPlayer())+ " is current player";
    }
}