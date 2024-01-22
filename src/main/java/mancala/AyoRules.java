package mancala;

public class AyoRules extends GameRules{


    // public int numStones(int startPit, int playerNum){
    //     return 0;
    // }
   // GameRules rules = new GameRules();
    //MancalaDataStructure data = new MancalaDataStructure(4);
    private static final long serialVersionUID = 1L;
    private int curr;
//    private int numStones;
 //   private Countable next;
 //   private MancalaGame game;
    private int playerSet = 0;
    private MancalaGame player=new MancalaGame();
    private MancalaDataStructure getDataStructure;
   // rules.setPlayer(curr);
    //rules.setPlayer(curr);
    public AyoRules(){
        super();
        this.curr = 1;
    //    this.numStones = 1;
       // this.resetBoard();
    }
    public AyoRules(final MancalaGame mancalaGame){
        super();
        this.player = mancalaGame;
    }
    // private void setOpp(int playerNum){
    //     // if(playerNum ==1){
    //     //     setPlayer(2);
    //     //     curr = 2;
    //     // }
    //     // if(playerNum ==2){
    //     //     setPlayer(1);
    //     //     curr = 1;
    //     // }
    //     // //playerSet=1;
    //     // player.currentPlayer(curr);
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
    private boolean isValid(final int startPit, final int playerNum){
        if(playerNum == 1 && (startPit > 6 || startPit < 0)){
            return false;
            //throw new InvalidMoveException();
        }
        if(playerNum == 2 && (startPit < 7 || startPit > 12)){
            return false;
           // throw new InvalidMoveException();
        }
        // if(getNumStones(startPit) == 0){
            
        //     throw new InvalidMoveException("Pit has 0 stones. ");
        // }
        // if(playerSet==0){
        //     setOpp(playerNum);
        // }
        return true;
    }
    @Override
    public int moveStones(final int startPit, final int playerNum)throws InvalidMoveException{
        playerSet=0;
      //  int total = 0;
       // System.out.println("u eiw dsauisy "+ getDataStructure().getNumStones(startPit));
        if(!(isValid(startPit, playerNum))){
            throw new InvalidMoveException();
        }
        if(getDataStructure().getNumStones(startPit) == 0){
            throw new InvalidMoveException("Pit has 0 stones. ");
        }
        curr = playerNum;
       // getDataStructure().setIterator(startPit, playerNum, true);
        int starting = getDataStructure().getStoreCount(playerNum);
        setIterator(startPit, playerNum, true);
        //numStones = 
        distributeStones(startPit);
     //   System.out.println(starting+ " bruhhsshhshs");
        starting = getDataStructure().getStoreCount(playerNum) - starting;
     //   System.out.println(starting+ " njnjashsshhshs");
        if(playerSet == 0){
            setCurr(0);
           // setOpp(playerNum);
        }

        return starting;
    }
    private int helperDistribute(final int playerNum, final int pitNum){
        if(pitNum == 7 && playerNum == 1){//} &&  valid!=0){
            getDataStructure().addToStore(playerNum,1);

         //   System.out.println("goesghgh here "+getDataStructure().getStoreCount(1));
        //    System.out.println(" here "+getStoreCount(1));
            return 1;
        }
        if(pitNum == 1 && playerNum == 2){//} && valid!=0) {
            getDataStructure().addToStore(playerNum,1);
        //    System.out.println("goes here2");
            return 1;
        }
        return 0;
    }
    private int getStoppingPoint(final int stoppingPoint){
        int newPoint = stoppingPoint-1;
        if (newPoint == 0){
            newPoint = 12;
        }
        return newPoint;
    }
    // private void checkValid(final int stoppingPoint){
    // //    System.out.println("jjjsjsj "+stoppingPoint);
    //     if(getDataStructure().getNumStones(stoppingPoint) == 1){
    //         if(stoppingPoint < 7 && curr==1){
    //       //  System.out.println("Goes here uisadusahjdfyuiwqjdsuy");
    //             int numStone = captureStones(stoppingPoint);
    //         }
    //         if(stoppingPoint > 6 && curr==2){
    //             int numStone = captureStones(stoppingPoint);
    //         }
    //     }
    // }
    private void checkValid(final int stoppingPoint){
      //  System.out.println("jjjsjsj "+stoppingPoint);
        if(getDataStructure().getNumStones(stoppingPoint) == 1){
            if(stoppingPoint < 7 && curr == 1){
            //    System.out.println("Goes here uisadusahjdfyuiwqjdsuy");
                //int numStone = 
                captureStones(stoppingPoint);
            }
            if(stoppingPoint > 6 && curr == 2){
            //    System.out.println("Goes here uisadusahjdfyuiwqjdsuy");
                //int numStone = 
                captureStones(stoppingPoint);
            }
        }
    }
    private int checkTurn(final int startPit){
        int newStones=0;
        if(getDataStructure().getNumStones(startPit) > 1){
         //   System.out.println("jsjjsjsmjikolpookl");
            newStones = getDataStructure().removeStones(startPit);
        //    total += newStones;
        }
        return newStones;
    }
    @Override
    public int distributeStones(int startPit){
        playerSet=0;
        int stones = getDataStructure().removeStones(startPit);
        final int total = stones;
        final int skipPit = startPit;
        startPit++;
        startPit = startPit%13;
            if(startPit == 0){
                startPit = 1;
            }
     //   int position = 0;
        while(stones > 0){
        //    next = getDataStructure().next();
         //   System.out.println("dbruhe "+startPit+stones);
            stones = stones-helperDistribute(curr, startPit);
           // position=1;
           // stones--;
         //   System.out.println("startpit is "+startPit+stones);
            if(stones != 0 && startPit != skipPit){
        //        System.out.println("rburhe here sor piit");
                getDataStructure().addStones(startPit, 1);
            //    position = 1;
                stones--;
            }
          //  position = 1;
          //  stones--;
            if(stones == 0){
             //   System.out.println("now here cux wy not " +startPit);
                stones = checkTurn(startPit);
            }
            startPit = (startPit+1)%13;
            if(startPit == 0){
                startPit = 1;
            }
            // if(stones == 0){
            //     checkTurn(startPit);
            // }
        }
        startPit = getStoppingPoint(startPit);
        checkValid(startPit);
        if(playerSet == 0){
        //    System.out.println("def in here");
            setCurr(0);
           // setOpp(0);
        }
        return total;
    //     int stones=0;;// = getDataStructure().removeStones(startPit);
    //     int skipPit = startPit;
    //    // System.out.println("stones are liek ins usuch "+stones);
    //     int total = stones;
    // //    startPit++;
    //     int position = 0;
    //     while (getDataStructure().getNumStones(startPit) > 1){
    //         System.out.println("bruhe startpit is "+startPit);
    //         System.out.println("hdjshjdsh "+startPit+getDataStructure().getNumStones(startPit));
    //         stones = getDataStructure().removeStones(startPit);
    //         total += stones;
    //         while(stones > 0){
    //             next = getDataStructure().next();
    //             stones = stones-helperDistribute(curr, startPit, position);
    //             if(startPit != skipPit){
    //                 getDataStructure().addStones(startPit, 1);
    //                 position = 1;
    //                 stones--;
    //             }
    //             startPit = (startPit+1)%13;
    //             if(startPit == 0){
    //                 startPit = 1;
    //             }
    //         }
    //         // total += stones;
    //     //    System.out.println("startpit is now "+startPit);
    //         startPit--;
    //         System.out.println("startpit is noe "+startPit);
    //     }
    //       //  position = getDataStructure().next();
    //     //data.removeStones(startPit);
    //     return total;
    }
    @Override
    public int captureStones(final int stoppingPoint){
      //  System.out.println("here too i guess?");
        final int opponent = 13 - stoppingPoint;
        int stones = getDataStructure().getNumStones(opponent);
        //data.getNumStones(opponent);
        if(stones != 0){
            stones = getDataStructure().removeStones(opponent);
            getDataStructure().addToStore(curr, stones);
           // data.addToStore(curr, data.removeStones(opponent));
            //return stones;
        }
        // playerSet = 1;
        // setPlayer(curr);
        // player.currentPlayer(curr);
        return stones;
    }
}