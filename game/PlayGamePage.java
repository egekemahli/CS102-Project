import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;



/* 
 * A class PlayGame Panel
 * @author Alperen Balcý
 * @version 17.07.2018
 * 
 */
public class PlayGamePage extends JPanel{
   
   private int WIDTH = 800;
   private int HEIGHT = 600;
   
   private JButton playGame;
   private JButton exit;
   private JButton aboutUs;
   private JButton howToPlay;
   
   private JLabel label;
   private JLabel imageLabel;
   private String pushedButton;
   private ImageIcon image;
   
   private GameFrame gameFrame;
   
   public PlayGamePage( GameFrame gameFrame ) {
      this.gameFrame = gameFrame;
      setLayout(new BorderLayout());
      setBackground(new Color(224,255,255));
      setSize( WIDTH , HEIGHT);
      createComponents();
      pushedButton = null;
   }
   
   private void createComponents() {
      playGame = new JButton("PLAY GAME");
      playGame.setFont(new Font("Arial", Font.PLAIN, 64));
      playGame.addActionListener( new YourActionListener() );
      
      howToPlay = new JButton("HOW TO PLAY MAZEDOT ?");
      howToPlay.setFont(new Font("Arial", Font.PLAIN, 20));
      howToPlay.addActionListener( new YourActionListener() );
      
      exit = new JButton("EXIT");
      exit.setFont(new Font("Arial", Font.CENTER_BASELINE,18));
      exit.addActionListener( new YourActionListener() );
      
      aboutUs = new JButton("ABOUT US");
      aboutUs.setFont(new Font("Arial", Font.CENTER_BASELINE,18));
      aboutUs.addActionListener( new YourActionListener() );
      
      image = new ImageIcon(getClass().getResource("img.jpg"));
      imageLabel = new JLabel(image);
      
      label = new JLabel("WELCOME TO MAZEDOT GAME");
      label.setFont(new Font("Arial", Font.ITALIC,30));
      
      setLayout(null);
      
      exit.setBounds((WIDTH/8)*6, HEIGHT/12,(WIDTH/80)*13,(HEIGHT/12));
      aboutUs.setBounds((WIDTH/80)*6,HEIGHT/12,(WIDTH/80)*13,(HEIGHT/12));
      playGame.setBounds(WIDTH/16,(HEIGHT/12)*7,(WIDTH/80)*68,(HEIGHT/12)*3);
      label.setBounds((WIDTH/80)*17,(HEIGHT/120)*37,(WIDTH/80)*67,(HEIGHT/12)*2);
      howToPlay.setBounds((WIDTH/80)*25,(HEIGHT/120)*55,(WIDTH/80)*30,(HEIGHT/12));
      
      imageLabel.setBounds((WIDTH/80)*25 ,(HEIGHT/12),(WIDTH/80)*30,(HEIGHT/12)*3);
      
      exit.setBackground(new Color(127,255,212));
      aboutUs.setBackground(new Color(127,255,212));
      playGame.setBackground(new Color(124,252,0));
      howToPlay.setBackground(new Color(127,255,212));
      
      add(imageLabel);
      add(exit);
      add(aboutUs);
      add(playGame);
      add(howToPlay);
      add(label, BorderLayout.AFTER_LINE_ENDS);
      
   }
   
   public String getPushedButton() {
      return pushedButton;
   }
   public JButton getPlayGame() {
      return playGame;
   }
   
   public void setPlayGame(JButton playGame) {
      this.playGame = playGame;
   }
   public JButton getExit() {
      return exit;
   }
   
   public void setExit(JButton exit) {
      this.exit = exit;
   }
   
   public JButton getAboutUs() {
      return aboutUs;
   }
   
   public void setAboutUs(JButton aboutUs) {
      this.aboutUs = aboutUs;
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
   
   public class YourActionListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
         if ( e.getSource() == playGame )
         {
            gameFrame.remove( gameFrame.playGamePanel );
            gameFrame.add( gameFrame.characterSelect );
            gameFrame.revalidate();
            gameFrame.repaint();
         }
         else if ( e.getSource() == aboutUs )
         {
            gameFrame.remove( gameFrame.playGamePanel );
            gameFrame.add( gameFrame.aboutUs );
            gameFrame.revalidate();
            gameFrame.repaint();
         }
         else if ( e.getSource() == howToPlay )
         {
            gameFrame.remove( gameFrame.playGamePanel );
            gameFrame.add( gameFrame.howToPlay );
            gameFrame.revalidate();
            gameFrame.repaint();
         }
         else
         {
            gameFrame.setVisible(false);                 
         }
      }
   }
}