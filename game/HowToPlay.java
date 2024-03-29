import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/* 
 * A class HowToPlay Panel
 * @author Alperen Balc�
 * @version 17.07.2018
 * 
 */
public class HowToPlay extends JPanel {//getBack method return true if user click back.
   
   private int WIDTH = 800;
   private int HEIGHT = 600;
   
   private JButton exit;
   private boolean back;
   private GameFrame gameFrame;
   
   JLabel howToPlayLabel;
   
   JTextArea howToPlayTextArea;
   
   ImageIcon howToPlayImage;
   
   public HowToPlay( GameFrame gameFrame ) {
      this.gameFrame = gameFrame;
      setLayout(new BorderLayout());
      setBackground(new Color(224,255,255));
      setSize( WIDTH , HEIGHT);
      createComponents();
   }
   
   public void createComponents() {
      
      back = false;
      
      exit = new JButton("BACK");
      exit.setFont(new Font("Arial", Font.CENTER_BASELINE,18));
      
      howToPlayImage = new ImageIcon(getClass().getResource("howToPlay.png"));
      howToPlayLabel = new JLabel(howToPlayImage);
      
      howToPlayTextArea = new JTextArea("**While the user is playing, the user will see his/her character at the beginning of the maze and this maze consist of black and blue squares. Blue ones are in clickable position, but the black ones are not in clickable position because they represent walls. After the user clicks a blue square, the dog will move to that square, and blue square turns into green, and previous green ones turn into blue again. After dog moves to the next square, dot number will increase simultaneously. When the user finishes the level, the user will be rewarded with stars that represent the success of the user.**", 6, 20);
      howToPlayTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
      howToPlayTextArea.setLineWrap(true);
      howToPlayTextArea.setWrapStyleWord(true);
      howToPlayTextArea.setOpaque(false);
      howToPlayTextArea.setEditable(false);
      
      setLayout(null);
      
      howToPlayLabel.setBounds((WIDTH/80)*25,(HEIGHT/60)*4,(WIDTH/80)*30,(HEIGHT/12)*5);
      howToPlayTextArea.setBounds((WIDTH/80)*10 , (HEIGHT/60)*30 ,(WIDTH/80)*60 , (HEIGHT/3));   
      exit.setBounds((WIDTH/80)*58, HEIGHT/24,(WIDTH/80)*13,(HEIGHT/16));
      
      exit.setBackground(new Color(127,255,212));
      exit.addActionListener( new OurActionListenerr() );
      
      add(howToPlayLabel);
      add(howToPlayTextArea);
      add(exit);
   }
   public int getWidth() {
      return WIDTH;
   }
   public void setWidth(int a) {
      WIDTH = a;
   }
   public int getHeight() {
      return HEIGHT;
   }
   public void setHeigth(int a) {
      HEIGHT = a;
   }
   public boolean getBack() {
      return back;
   }
      //retruns button when it is clicked.
   public JButton getExit() {
      return exit;
   }
   
   public void setExit(JButton exit) {
      this.exit = exit;
   }
        //inner class for listen buuttons
   public class OurActionListenerr implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
         gameFrame.remove( gameFrame.howToPlay );
         gameFrame.add( gameFrame.playGamePanel );
         gameFrame.revalidate();
         gameFrame.repaint();
      }
   }
}