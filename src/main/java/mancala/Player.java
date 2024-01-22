package mancala;
import java.util.logging.Logger;
//import java.util.List;
import java.io.Serializable;
//import java.io.ObjectOutputStream;
//import java.io.ObjectInputStream;
//import java.io.IOException;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;

public class Player implements Serializable{
    private static final long serialVersionUID = 1L;
    private String players;
    private Store stores;// = new Store();
    private UserProfile user;
   // private Saver saves;
    Logger log = Logger.getLogger(Player.class.getName());
    public Player(){
        this.stores = new Store();
    }
    public Player(final String name){
        this.players = name;
    }
    public UserProfile getUser(){
        return user;
    }
    public String getName(){
        //return players;
        if(user==null){
    //    System.out.println("lets ee what is "+players);
            return players;
        }
        return user.getName();
    }
    public Store getStore(){
        return stores;
    }
    public int getStoreCount(){
        //return stores.getTotalStones();
        return stores.getStoneCount();
      //  return getDataStructure().getStoreCount();
       // return getIntPlayer().getStoneCount();
    }
    public void setName(final String name){
        System.out.println("the name is "+name);
        user = new UserProfile();
        user.setName(name);
        players = user.getName();
       // players = name;
    }
    public void setStore(final Store store){
        stores = store;
    }
   
    // @Override
    // public String toString(){
    //     return getName()+":"+getStoreCount();
    // }
}