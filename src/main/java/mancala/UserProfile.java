package mancala;
import java.io.Serializable;

public class UserProfile implements Serializable{
    private static final long serialVersionUID = 1L;

    private String name;
    private int numKalah = 0;
    private int numAyo = 0;
    private int wonKalah = 0;
    private int wonAyo = 0;
    // private List<String>;
    public UserProfile (){
        name = "";
    }
    public void setName(final String pName){
        name = pName;
    }
    public String getName(){
        return name;
    }
    public void setKalah(final int num){
        numKalah = num;
    }
    public void setAyo(final int num){
        numAyo = num;
    }
    public void setKalahWon(final int won){
        wonKalah = won;
    }
    public void setAyoWon(final int won){
        wonAyo = won;
    }
    public int getKalahGame(){
        return numKalah;
    }
    public int getAyoGame(){
        return numAyo;
    }
    public int getWonAyo(){
        return wonAyo;
    }
    public int getWonKalah(){
        return wonKalah;
    }
}