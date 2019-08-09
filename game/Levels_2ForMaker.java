import javax.swing.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/* 
 * This class is a continuation of the levels class. GUI implementation of the levels panel where the game is played is mainly managed here.
 * @author Abddullah Emir Öztürk
 * @version 24.07.2018
 * 
 */
public class Levels_2ForMaker extends LevelsForMaker
{
   //Attributes
   private int levelNumber;   
   private final int WIDTH = 800;
   private final int HEIGHT = 600; 
   private JButton restart;
   private JLabel dotNumber;
   private int numberOfLevels;
   private JLabel level;
   private int clicked;
   private GameFrame gameFrame;
   private ImageIcon victim;
   private int selectedLevel;
   
   public Levels_2ForMaker(int selectedLevel ) throws IOException
   {
      super(selectedLevel);
      this.selectedLevel = selectedLevel-1;
      levelNumber = 0;
      clicked = 0;
      createComponent();
   }
   

   private void createComponent() throws IOException
   {
      
      victim = new ImageIcon(getClass().getResource("kemik.jpg"));
      MouseListener listener = new MouseListenerr();
      level = new JLabel("LEVEL "+String.valueOf(selectedLevel+1));
      restart = new JButton("RESTART");
      dotNumber = new JLabel("DOT NUMBERS");
      restart.addMouseListener(listener);
      restart.setForeground( Color.RED );
      restart.setFont( new Font( "Arial", Font.PLAIN, 16 ) );
      restart.setBackground( new Color ( 127, 255, 212 ) ) ;
      
      setLayout(null);
      level.setBounds(250,5,200,40);
      level.setFont( new Font( "Arial", Font.BOLD, 28 ) );
      level.setForeground( Color.RED );
      restart.setBounds(625,475,125,40);
      dotNumber.setBounds(637,255,125,40);
      dotNumber.setForeground( Color.RED );
      dotNumber.setFont( new Font( "Arial", Font.BOLD, 14 ) );
      
      add(restart);
      add(dotNumber);
      add(level);
      
   }
   
       //MouseListenerr: Invokes the restart method when the restart button is clicked.
   private class MouseListenerr implements MouseListener 
   {
      
      public void mouseClicked( MouseEvent e){
         if(((JButton) e.getSource()).getText().equals("RESTART"))
         {
            restart();
         }
        
      }
      public void mouseEntered(MouseEvent arg0){
         
      }
      public void mouseExited(MouseEvent arg0){
         
      }
      public void mousePressed(MouseEvent arg0){
         
      }
      public void mouseReleased(MouseEvent arg0){
         
      }
   }
   
   
   public void paintComponent( Graphics g )
   {
      super.paintComponent(g);
      g.drawRect( 630, 252, 120, 50 );
      g.drawRect( 630, 302, 120, 40 );
      g.setColor( new Color( 167, 248, 124 )); //green(brighter)
      g.fillRect( 232, 5, 150, 43);
      g.setColor( Color.YELLOW );
      g.fillRect( 631, 253, 119, 49 );
      g.fillRect( 631, 303, 119, 39 );
   }  
   
   public void setClicked(int x)
   {
      clicked = x;
   }
   public int getClicked(){
      return clicked;
   }
   

}