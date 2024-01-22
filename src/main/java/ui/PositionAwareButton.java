package ui;
//import java.io.IOException;
//import java.awt.Container;  //abstract window toolkit
// import java.awt.BorderLayout;
// import java.awt.GridLayout;
import javax.swing.JButton;
// import javax.swing.BoxLayout;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JLabel;
// import javax.swing.JButton;
// import javax.swing.JScrollPane;
// import javax.swing.JOptionPane;
// import javax.swing.JMenuBar;
// import javax.swing.JMenu;
// import javax.swing.JMenuItem;

/**
 * Represents a GUI button component that knows its position in a grid.
 */
public class PositionAwareButton extends JButton {
    private static final long serialVersionUID = 1L;
    private int xPos;
    private int yPos;

    /**
     * Constructs a new PositionAwareButton.
     */
    public PositionAwareButton() {
        super();
    }

    /**
     * Constructs a new PositionAwareButton with the specified text.
     *
     * @param val The text to display on the button.
     */
    public PositionAwareButton(final String val) {
        super(val);
    }
    // public PositionAwareButton(String windowTitle, int width, int height) {
    //     super();
    //     setTitle(windowTitle);
    //     setSize(width, height);
    // }
    /**
     * Gets the horizontal position (across) of the button in a grid.
     *
     * @return The horizontal position of the button.
     */
    public int getAcross() {
        return xPos;
    }

    /**
     * Gets the vertical position (down) of the button in a grid.
     *
     * @return The vertical position of the button.
     */
    public int getDown() {
        return yPos;
    }

    /**
     * Sets the horizontal position (across) of the button in a grid.
     *
     * @param val The horizontal position to set.
     */
    public void setAcross(final int val) {
        xPos = val;
    }

    /**
     * Sets the vertical position (down) of the button in a grid.
     *
     * @param val The vertical position to set.
     */
    public void setDown(final int val) {
        yPos = val;
    }
    // private JPanel makeButtonGrid ( int tall, int wide){
    //     JPanel panel = new JPanel(); 
    //     JButton buttons = new PositionAwareButton[tall][wide]; // a r r a y o f b u t t o n s
    //     panel.setLayout(new GridLayout(wide,tall));
    //     for (int y=0; y<wide; y++){
    //         for (int x=0; x<tall; x++){
    //     // C r e a t e b u t t o n s and l i n k e a c h b u t t o n b a c k t o a c o o r d i n a t e on t h e g r i d
    //             buttons[y][x] = new PositionAwareButton();
    //             buttons[y][x].setAcross(x+1); // 1 b a s e d a r r a y
    //             buttons[y][x].setDown(y+1);
    //         //   buttons[y][x].addActionListener(e->{someEventHandlerMethodsHere()});
    //             panel.add(buttons[y][x]);
    //         }
    //     }
    //     return panel ;
    // }
}

// private JPanel makeButtonGrid ( i n t t a l l , i n t wide ){
// JPanel panel = new JPanel ( ) ;
// buttons = new PositionAwareButton [ t a l l ] [ wide ] ; / / a r r a y o f b u t t o n s
// panel . setLayout (new GridLayout ( wide , t a l l ) ) ;
// for ( i n t y =0; y<wide ; y++){
// for ( i n t x =0; x<t a l l ; x++){
// / / C r e a t e b u t t o n s and l i n k e a c h b u t t o n b a c k t o a c o o r d i n a t e on t h e g r i d
// buttons [ y ] [ x ] = new PositionAwareButton ( ) ;
// buttons [ y ] [ x ] . setAcross ( x + 1 ) ; / / 1 b a s e d a r r a y
// buttons [ y ] [ x ] . setDown ( y + 1 ) ;
// buttons [ y ] [ x ] . addActionListener ( e−>{
// someEventHandlerMethodsHere ( )
// } ) ;
// panel . add ( buttons [ y ] [ x ] ) ;
// }
// }
// return panel ;
// }