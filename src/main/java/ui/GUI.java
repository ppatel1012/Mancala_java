package ui;
import java.io.Serializable;
import java.io.IOException;
import java.awt.Container;  //abstract window toolkit
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import mancala.MancalaDataStructure;
import mancala.MancalaGame;
import mancala.NoSuchPlayerException;
import mancala.PitNotFoundException;
import mancala.GameNotOverException;
import mancala.Player;
import mancala.InvalidMoveException;
import mancala.Saver;

public class GUI extends JFrame{
    private MancalaDataStructure data;// = new MancalaDataStructure(); //this new
    private MancalaGame board;// = new MancalaGame();
    private Player player1= new Player();
    private Player player2 = new Player();
    private Saver saving = new Saver();
    private int number;
    JPanel mainPanel = new JPanel(new BorderLayout());
    final int ROWS = 1;
    final int COLS = 6;
    JLabel store1;
    JLabel store2;
    JLabel p1Info;
    JLabel p2Info;
    private JLabel currentPlayerLabel;
    String[] options = {"Ayo", "Kalah"};
    String[] choices = {"Yes", "No"};
    
    public GUI(String windowTitle, int width, int height) {
        super();
        board = new MancalaGame();
        data = board.getGame();
        setTitle(windowTitle);
        setSize(width, height);
        int choice = JOptionPane.showOptionDialog(this, "Select a game:","Choose Game",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null,options,options[0]);
        doRules(choice);
        board.setPlayers(player1, player2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(setupMenuBar());
        getLoad();
        setLayout(new BorderLayout());
        rowLayout();
        Color customColor = new Color(241, 167, 191);
        getContentPane().setBackground(customColor);
    }
    private JMenuBar setupMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File Save/Load");
        JMenuItem saveItem = new JMenuItem("Save Game");
        saveItem.addActionListener(event -> saveListOption());
        fileMenu.add(saveItem);
        JMenuItem loadItem = new JMenuItem("Load Game");
        loadItem.addActionListener(event -> loadListOption());
        fileMenu.add(loadItem);
        menuBar.add(fileMenu);
        return menuBar;
    }
    private void saveListOption() {
        String saveFileName = JOptionPane.showInputDialog("Enter file to save the game");
        //board.saveGame(saveFileName);
        saving.saveObject(board, saveFileName);
     //   FileWriter fw = new FileWriter(saveFileName);
    //    fw.write(list);m
    //    for (Item item : list) {
    //        fw.write(item);
    //    }
    //    try {
         //   board.saveGame(saveFileName);
       //     fw.save();
    //    } catch (IOException err) {
       //    JOptionPane.showMessageDialog(this, "incorrexr form "+err.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
       //     System.out.println(err.getMessage());
    //    }
       // System.out.println("Saved to '" + fw.getFilePath() + "'");
      //  JOptionPane.showMessageDialog(this, "SAve to file "+fw.getFilePath(),"File saved", JOptionPane.PLAIN_MESSAGE);
    }
    private void loadListOption() {
        String saveFileName = JOptionPane.showInputDialog("Enter file to load Game");
        Serializable loadedObject = saving.loadObject(saveFileName);
         //getUserLine("Enter file name to load");
      ///  try {
        //    FileReader fr = new FileReader(saveFileName);
         //   String listTitle = fr.readLine();
        //    TodoList newList = new TodoList(listTitle);
        //    int numItems = fr.readInt();
            // for (int i = 0; i < numItems; i++) {
            //     String itemTitle = fr.readLine();
            //     String itemDesc = fr.readLine();
            //     LocalDateTime dueDate = fr.readDateTime();
            //     int priority = fr.readInt();
            //     boolean completed = fr.readBoolean();
            //     newList.addItem(itemTitle, itemDesc, dueDate, priority);
            //     if (completed) {
            //         newList.completeItem(newList.getIndexByTitle(itemTitle));
            //     }
            // }
        //    this.list = newList;
        //    refreshListPanel();
        //    System.out.println("List loaded from file '" + fr.getFilePath() + "'");
        // } catch (FileFormatException err) {
        //     JOptionPane.showMessageDialog(this, "incorrexr form "+err.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
        //    // System.out.println(err.getMessage());
        // } catch (Exception err) {
        //     JOptionPane.showMessageDialog(this, "incorrexr form "+err.getMessage(), "Save Error", JOptionPane.ERROR_MESSAGE);
        //    // System.out.println(err);
        // }
    }
    private void getLoad(){
        int choice = JOptionPane.showOptionDialog(this, "Would u like to load game:","Choose Y/N",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
        null,choices,choices[0]);
        if (choice ==0){
           // String input = JOptionPane.showInputDialog(null, "Enter file name: ");
            loadListOption();
        }
        if(choice == 1){
            String input = JOptionPane.showInputDialog(null, "Enter player 1 name: ");
            player1.setName(input);
            input = JOptionPane.showInputDialog(null, "Enter player 2 name: ");
            player2.setName(input);
        }
    }
    private void setStoreLabel(){
        currentPlayerLabel = new JLabel("Current Player: " + board.getCurrentPlayer().getName(), JLabel.CENTER);
        currentPlayerLabel.setFont(new Font("Comic Sans", Font.BOLD, 16));
        try{
        store1 = new JLabel(player1.getName()+" Store P1: "+ board.getStoreCount(player1)+"   ");
        store1.setFont(new Font("Serif", Font.ITALIC, 16));
            store2 = new JLabel(player2.getName()+" Store P2:   "+ data.getStoreCount(2));
            store2.setFont(new Font("Serif", Font.ITALIC, 16));
        }catch(NoSuchPlayerException err){
            err.getMessage();
        }
        p1Info = new JLabel("P2 info\nNumber ayo played: "+player2.getUser().getAyoGame()+
        " wins:"+player2.getUser().getWonAyo()+
        "\nNumber of kalah played: "+player2.getUser().getKalahGame() +
        " wins:"+player2.getUser().getWonKalah());
        p2Info = new JLabel("P1 info\nNumber ayo played: "+player2.getUser().getAyoGame()+
        " wins:"+player2.getUser().getWonAyo()+
        "\nNumber of kalah played: "+player2.getUser().getKalahGame() +
        " wins:"+player2.getUser().getWonKalah()+ "");
        player2.getUser().setAyoWon(1);
        add(store1, BorderLayout.EAST);
        add(store2, BorderLayout.WEST);
        add(p1Info, BorderLayout.SOUTH);
        add(p2Info, BorderLayout.NORTH);
        mainPanel.add(currentPlayerLabel, BorderLayout.CENTER);
    }
    private void doRules(int choice){
        if(choice==0){
          //  JOptionPane.showMessageDialog(null, "ayp ");
            board.setRules(2);
        }
        if(choice==1){
           // JOptionPane.showMessageDialog(null, "kalah");
            board.setRules(1);
        }
    }
    private void rowLayout(){
        int i;
        Color custom = new Color(237, 187, 203);
        mainPanel.setBackground(custom);
        JPanel panel = new JPanel(new GridLayout(ROWS, COLS));
        try{
            for (i=COLS+COLS; i>COLS; i--) {
                int currentPitNum = i;
                JButton button = new JButton("Pit "+i+": "+ board.getNumStones(i));
                button.addActionListener(event -> handleButtonClick(currentPitNum));
                panel.add(button);
            }
            JPanel row2 = new JPanel(new GridLayout(ROWS, COLS));
            for(i=1; i<=COLS; i++){
                int currentPitNum = i;
                JButton button = new JButton("Pit "+i+": "+ board.getNumStones(i));
                button.addActionListener(event -> handleButtonClick(currentPitNum));
                row2.add(button);
            }
            mainPanel.add(panel, BorderLayout.NORTH);
            mainPanel.add(row2, BorderLayout.SOUTH);
            add(mainPanel, BorderLayout.CENTER);
            setStoreLabel();
            if(board.isGameOver()){
                endGame();
            }
        }catch(PitNotFoundException err){
            err.getMessage();
        }
    }
    private void updateBoard(){
        remove(store1);
        remove(store2);
        remove(p1Info);
        remove(p2Info);
        remove(currentPlayerLabel);
        // if(board.isGameOver()){
        //     endGame();
        // }
        repaint();
        mainPanel.removeAll(); 
        rowLayout();
        mainPanel.repaint();
        mainPanel.revalidate();
        // if(board.isGameOver()){
        //     endGame();
        // }
    }
    private void endGame(){
        // JFrame winnerFrame = new JFrame("Game Over");
        // winnerFrame.setSize(400, 300);
        // winnerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // JPanel winnerPanel = new JPanel();
        // winnerPanel.setBackground(Color.BLACK);
        try{
            JFrame winnerFrame = new JFrame("Game Over");
        winnerFrame.setSize(400, 300);
        winnerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel winnerPanel = new JPanel();
        winnerPanel.setBackground(Color.BLACK);
        JLabel winnerLabel = new JLabel(board.getWinner().getName() + " is the winner!");
        winnerLabel.setForeground(Color.RED);
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        winnerPanel.add(winnerLabel);
        winnerFrame.add(winnerPanel);
        winnerFrame.setVisible(true);
        }catch(GameNotOverException err){
            err.getMessage();
        }
        // winnerLabel.setForeground(Color.WHITE);
        // winnerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        // winnerPanel.add(winnerLabel);
        // winnerFrame.add(winnerPanel);
    }
    private void handleButtonClick(int pitNum) {
        System.out.println("Button clicked: Pit " + pitNum);
        try{
            board.move(pitNum);
            updateBoard();
        }catch(InvalidMoveException err){
            err.getMessage();
        }
      //  System.out.println("Button clicked: Pit " + pitNum);
    }
    private void ayoGame(){
        String title = JOptionPane.showInputDialog("Playing in ayo");
    }
    private void kalahGame(){
        String title = JOptionPane.showInputDialog("Playing in kalah");
    }
    public static void main(String[] args){
        GUI example = new GUI("Mancala Game <3", 900, 500);
        example.setVisible(true);
    }
    private String toPrint(int pitNum){
        return pitNum+"";
    }
}