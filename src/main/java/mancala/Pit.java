package mancala;
import java.io.Serializable;
// import java.io.ObjectOutputStream;
// import java.io.ObjectInputStream;
// import java.io.IOException;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;

public class Pit implements Serializable, Countable{
    private static final long serialVersionUID = 1L;
    private int pitNum;// = 0;
    //private Saver saves;
 //   final private int stones;//=0;
    private int temp;// = 0;
    public Pit(){
        this.pitNum = 0;
   //     this.stones = 0;
        this.temp = 0;
    }
    @Override
    public int getStoneCount(){
        return pitNum;
    }
    @Override
    public void addStone(){
        pitNum = pitNum+1;
    }
    @Override
    public void addStones(final int amount){
        pitNum = pitNum + amount;
    }
    @Override
    public int removeStones(){
        temp = pitNum;
        pitNum = 0;
        return temp;
    }
   
    @Override
    public String toString(){
        return "Stones are "+getStoneCount();
    }
}