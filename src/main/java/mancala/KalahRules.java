package mancala;

public class KalahRules extends GameRules{
//    int random= 0;
    private static final long serialVersionUID = 1L;
    //private Countable next;
    private int playerSet = 0;
    private int curr;
   // private int numStones;
    private MancalaGame player = new MancalaGame();
    private MancalaDataStructure getDataStructure;
    //getDataStructure = 
    //private MancalaDataStructure data;
    //private GameRules game = new GameRules();
    public KalahRules(){
        super();
        this.curr = 1;
     //   this.numStones = 1;
       // this.resetBoard();
       // super();
    }
    public KalahRules(final MancalaGame mancalaGame) {
        super();

        this.player = mancalaGame;
        // ...
    }
    // private void getDataStructure(){
    //     GameRules game;
    //     game.GameRules();
    // }
    private void setCurr(final int play){
     //   random++;
        if(play==0){
            if(curr == 1){
            //    System.out.println("goes here setting to 2 "+random);
                player.setPlayerTurn(2);
            }else{
            //    System.out.println("goes here setting to 1");
                player.setPlayerTurn(1);
            }
        }
        else{
            player.setPlayerTurn(curr);
        }
        playerSet=1;
    }
    // private void setOpp(int playerNum){
    //     if(playerNum ==1){
    //         System.out.println("int his 1");
    //         setPlayer(2);
    //         curr = 2;
    //     }
    //     if(playerNum ==2){
    //         System.out.println("int his 2");
    //         setPlayer(1);
    //         curr = 1;
    //     }
    //     playerSet=1;
    //     //player.currentPlayer(curr);
    // }
    private boolean isValid(final int startPit, final int playerNum){
        if(playerNum == 1 && (startPit > 6 || startPit < 0)){
            return false;
            //throw new InvalidMoveException();
        }
        if(playerNum == 2 && (startPit < 7 || startPit > 12)){
            return false;
           // throw new InvalidMoveException();
        }
        return true;
    }
    @Override
    public int moveStones(final int startPit, final int playerNum)throws InvalidMoveException{
        playerSet=0;
        
        // if(startPit > 12 || startPit < 1){
        //     throw new InvalidMoveException();
        // }
        // if((playerNum==1 && startPit > 6) || (playerNum==2 && startPit < 7)){
        //     throw new InvalidMoveException();
        // }
        // playerSet=0;
      //  int total = 0;
       // System.out.println("u eiw dsauisy "+ getDataStructure().getNumStones(startPit));
        if(!(isValid(startPit, playerNum))){
            throw new InvalidMoveException();
        }
        if(getDataStructure().getNumStones(startPit) == 0){
            throw new InvalidMoveException("Pit has 0 stones. ");
        }
        curr = playerNum;
        int starting = getDataStructure().getStoreCount(playerNum);
     //   System.out.println(starting+ " bruhhsshhshs");
        setIterator(startPit, playerNum, false);
       // curr = playerNum;
        //numStones = 
        distributeStones(startPit);
        starting = getDataStructure().getStoreCount(playerNum) - starting;
     //   System.out.println("now in after-distribute");
        if(playerSet == 0){
            setCurr(0);
        }
        return starting;
    }
    private int helperDistribute(final int playerNum, final int pitNum){
        if(pitNum == 7 && playerNum == 1){//} &&  valid!=0){
            getDataStructure().addToStore(playerNum,1);

         //   System.out.println("goes here 1 ");
            setCurr(playerNum);
          //  System.out.println(" here "+.getStoreCount(1));
            return 1;
        }
        if(pitNum == 1 && playerNum == 2){//} && valid!=0) {
            getDataStructure().addToStore(playerNum,1);
        //    System.out.println("goes here2");
            setCurr(playerNum);
            return 1;
        }
        return 0;
    }
    @Override
    public int distributeStones(int startPit){
     //   System.out.println("now in distribute");
        playerSet=0;
        int stones = getDataStructure().removeStones(startPit);
        final int total = stones;
        startPit++;
        startPit = startPit%13;
            if(startPit == 0){
                startPit = 1;
            }
    //    int position = 0;
        while(stones > 0){
            playerSet = 0;
       //     System.out.println("startpit "+startPit+" and stones "+stones);
         //   next = getDataStructure().next();
            stones = stones-helperDistribute(curr, startPit);
            if(stones !=0){
                getDataStructure().addStones(startPit, 1);
            }
        //    position = 1;
            stones--;
            startPit = (startPit+1)%13;
            if(startPit == 0){
                startPit = 1;
            }
        }
        //numStones = boardData.removeStones(startPit);
      //  int total = numStones;
        // board.setIterator(startPit,currentPlayer,false); // k a l a h d o e s n ’ t s k i p t h e s t a r t p i t
        // Countable currentSpot;
        // // w i l l i t e r a t e t h r o u g h t h e d a t a s t r u c t u r e , s k i p p i n g t h e o p p o s i t e p l a y e r s s t o r e .
        // for (int i=0; i<numStones; i++){
        //     currentSpot = boardData.next();
        //     currentSpot.addStone();
        // }
        startPit = getStoppingPoint(startPit);
        //checkValid(startPit);
    //    startPit = getDataStructure.getIterator();

        checkValid(startPit);
        if(playerSet == 0){
        //    System.out.println("def in here");
            setCurr(0);
           // setOpp(0);
        }

       // stones = captureStones(startPit);
        return total;
    }
    private void checkValid(final int stoppingPoint){
    //    System.out.println("jjjsjsj "+stoppingPoint);
        if(getDataStructure().getNumStones(stoppingPoint) == 1){
    //        System.out.println("Goes here uisadusahjdfyuiwqjdsuy");
            //final int numStone = 
            captureStones(stoppingPoint);
        }
        if(stoppingPoint == 6 || stoppingPoint == 13){
            playerSet = 1;
        }
       // if(getDataStructure().)
    }
    private int getStoppingPoint(int stoppingPoint){
        stoppingPoint -= 1;
        if (stoppingPoint == 0){
            stoppingPoint = 12;
        }
        return stoppingPoint;
    }
    @Override
    public int captureStones(final int stoppingPoint){
     //   System.out.println("now in capture");
        //stoppingPoint = getStoppingPoint(stoppingPoint);
        final int opponent = 13 - stoppingPoint;
        int stones; //= getDataStructure().getNumStones(opponent);
        //data.getNumStones(opponent);
    //    if(stones != 0){
        //    System.out.println("goes liek here yoand stoppingPoint is "+stoppingPoint);
            stones = getDataStructure().removeStones(opponent);
            stones += getDataStructure().removeStones(stoppingPoint);
            getDataStructure().addToStore(curr, stones);
        //    System.out.println("stones is  "+stones);
           // data.addToStore(curr, data.removeStones(opponent));
            //return stones;
    //   }
        playerSet = 1;
      //  setPlayer(curr);
        // player.currentPlayer(curr);
        return stones;
    }
}