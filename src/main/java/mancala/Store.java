package mancala;
import java.util.logging.Logger;
import java.io.Serializable;
//import java.io.ObjectOutputStream;
//import java.io.ObjectInputStream;
//import java.io.IOException;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.util.Objects;

public class Store implements Serializable, Countable{

    private static final long serialVersionUID = 1L;
    private int storeNum;// = 0;
    private int temp;// = 0;
    private Player players;
    //private Saver saves;
    Logger log = Logger.getLogger(Store.class.getName());
    public Store(){
        this.storeNum = 0;
        this.temp = 0;
    }
    // private int storeNum;// = 0;
    // private int temp;// = 0;
    // private Player players;
    // public void addStones(int numToAdd){
    //     storeNum = numToAdd;
    // }
    @Override
    public int getStoneCount(){
        return storeNum;
    }
    @Override
    public void addStone(){
        storeNum+=1;
    }
    @Override
    public int removeStones(){
        temp = storeNum;
        storeNum = 0;
        return temp;
    }
    public void setOwner(final Player player){
        players = player;
        
    }
    
    public Player getOwner(){
        return players;
    }
    @Override
    public void addStones(final int amount){
        storeNum+=amount;
       // stones + 

    }
    // public int getTotalStones(){
    //    // System.out.println("the total store has "+storeNum);
    //     return storeNum;
    // }
    // public int emptyStore(){
    //     temp = storeNum;
    //     storeNum = 0;
    //     return temp;
    // }
    // @Override
    // public void saveObject(final Serializable toSave, final String filename){
    //     final Logger log = Logger.getLogger(Store.class.getName());
    //     final String filepath = "./assets";
    //     try{
    //         final ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filepath));
    //         objectOut.close();
    //         //ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filepath));
    //     }catch(IOException err){
    //         if(log.isLoggable(java.util.logging.Level.WARNING)){
    //             log.warning("File name invalid "+err.getMessage());
    //         }
    //         //err.getMessage();
    //     }
    //     // objectOut.close();
    // }
    // @Override
    // public Serializable loadObject(final String filename){
    //     Serializable loadedObject = null;
    //     final String filepath = "./assets";
    //     try{
    //         final ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filepath));
    //         loadedObject = (Serializable) objectIn.readObject();
    //         objectIn.close();
    //     }catch(IOException err){
    //         //err.getMessage();
    //         if(log.isLoggable(java.util.logging.Level.WARNING)){
    //             log.warning("File name invalid "+err.getMessage());
    //         }
    //     }catch(ClassNotFoundException err){
    //         //err.getMessage();
    //         if(log.isLoggable(java.util.logging.Level.WARNING)){
    //             log.warning("File name invalid "+err.getMessage());
    //         }
    //     }
    //     // objectIn.close();
    //     return loadedObject;
    // }
    @Override
    public String toString(){
        return getOwner()+": "+getStoneCount();
    }
}