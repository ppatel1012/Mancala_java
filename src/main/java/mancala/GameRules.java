package mancala;
import java.io.Serializable;

/**
 * Abstract class representing the rules of a Mancala game.
 * KalahRules and AyoRules will subclass this class.
 */
public abstract class GameRules implements Serializable{
    private static final long serialVersionUID = 1L;
    private final MancalaDataStructure gameBoard;
    private final MancalaGame game = new MancalaGame();
    private int currentPlayer = 1; // Player number (1 or 2)
    private int count;
    /**
     * Constructor to initialize the game board.
     */
    public GameRules() {
        gameBoard = new MancalaDataStructure();
        resetBoard();
    }

    /**
     * Get the number of stones in a pit.
     *
     * @param pitNum The number of the pit.
     * @return The number of stones in the pit.
     */
    public int getNumStones(final int pitNum) {
        return gameBoard.getNumStones(pitNum);
    }
    public void setIterator(final int startPit, final int playerNum, final boolean skipStartPit) {
        gameBoard.setIterator(startPit, playerNum, skipStartPit);
    }
    /**
     * Get the game data structure.
     *
     * @return The MancalaDataStructure.
     */
    MancalaDataStructure getDataStructure() {
        return gameBoard;
    }

    /**
     * Check if a side (player's pits) is empty.
     *
     * @param pitNum The number of a pit in the side.
     * @return True if the side is empty, false otherwise.
     */
    boolean isSideEmpty(final int pitNum) {
       /*default*/int stones = 0;
        if (pitNum > 0 && pitNum < 7){
            for(count=1; count<7; count++){
                stones += getNumStones(count);
                // if(getNumStones(count) != 0){
                //     return false;
                // }
            }
        }
        else{
            for(count=7; count<13; count++){
                stones += getNumStones(count);
                // if(getNumStones(count) != 0){
                //     return false;
                // }
            }
        }
        return stones == 0;
        // if(stones !=0){
        //     return false;
        // }
        // // This method can be implemented in the abstract class.
        // return true;
    }

    /**
     * Set the current player.
     *
     * @param playerNum The player number (1 or 2).
     */
    public void setPlayer(final int playerNum) {
        currentPlayer = playerNum;
    //    System.out.println("GR so liek what goins on");
     //   game.currentPlayer(currentPlayer);
    }

    /**
     * Perform a move and return the number of stones added to the player's store.
     *
     * @param startPit  The starting pit for the move.
     * @param playerNum The player making the move.
     * @return The number of stones added to the player's store.
     * @throws InvalidMoveException If the move is invalid.
     */
    public abstract int moveStones(int startPit, int playerNum) throws InvalidMoveException;

    /**
     * Distribute stones from a pit and return the number distributed.
     *
     * @param startPit The starting pit for distribution.
     * @return The number of stones distributed.
     */
    abstract int distributeStones(int startPit);

    /**
     * Capture stones from the opponent's pit and return the number captured.
     *
     * @param stoppingPoint The stopping point for capturing stones.
     * @return The number of stones captured.
     */
    abstract int captureStones(int stoppingPoint);

    /**
     * Register two players and set their stores on the board.
     *
     * @param one The first player.
     * @param two The second player.
     */
    public void registerPlayers(final Player one, final Player two) {
        // this method can be implemented in the abstract class.
        // Store stores = new Store();
        // store.setOwner(one);
        // store.getOwner(two);
        final Store store1 = new Store();
        final Store store2 = new Store();
        store1.setOwner(one);
       // store1.setStore(one);
        one.setStore(store1);
        store2.setOwner(two);
        two.setStore(store2);
       // store2.setStore(two);
        gameBoard.setStore(store1, 1);
        gameBoard.setStore(store2, 2);
        /* make a new store in this method, set the owner
         then use the setStore(store,playerNum) method of the data structure*/
    }
    // public void startNewGame(){
    //      //gameBoard.resetBoard();
    //     gameBoard = new MancalaDataStructure();
    // }
    /**
     * Reset the game board by setting up pits and emptying stores.
     */
    public void resetBoard() {
        gameBoard.setUpPits();
        gameBoard.emptyStores();
    }

    @Override
    public String toString() {
        // Implement toString() method logic here.
        return " ";
    }
}
