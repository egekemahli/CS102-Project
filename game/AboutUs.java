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
 * A class PlayGame Panel
 * @author Alperen Balcý
 * @version 17.07.2018
 * 
 */
public class AboutUs extends JPanel {//getBack method return true if user click back.
   
   private int WIDTH = 800;
   private int HEIGHT = 600;
   
   private JButton exit;
   private boolean back;
   private GameFrame gameFrame;
   
   private JLabel emirLabel;
   private JLabel alperenLabel;
   private JLabel egeLabel;
   private JLabel berkayLabel;
   private JLabel aboutUs;
   
   private JTextArea em;
   private JTextArea al;
   private JTextArea eg;
   private JTextArea be;
   
   private JTextArea game;
   
   private ImageIcon emir;
   private ImageIcon alperen;
   private ImageIcon ege;
   private ImageIcon berkay;
    //Constructer
   public AboutUs( GameFrame gameFrame ) {
      this.gameFrame = gameFrame;
      setLayout(new BorderLayout());
      setBackground(new Color(224,255,255));
      setSize( WIDTH , HEIGHT);
      createComponents();
   }
    /**
   * This method is create component for create components
   * @param 
   * @return 
   */
   public void createComponents() {
      
      back = false;
      
      exit = new JButton("BACK");
      exit.setFont(new Font("Arial", Font.CENTER_BASELINE,18));
      
      emir = new ImageIcon(getClass().getResource("emir.jpg"));
      emirLabel = new JLabel(emir);
      alperen = new ImageIcon(getClass().getResource("alperen.jpg"));
      alperenLabel = new JLabel(alperen);
      ege = new ImageIcon(getClass().getResource("ege.jpg"));
      egeLabel = new JLabel(ege);
      berkay = new ImageIcon(getClass().getResource("berkay.jpg"));
      berkayLabel = new JLabel(berkay);
      aboutUs = new JLabel("ABOUT US...");
      aboutUs.setFont(new Font("Arial", Font.ITALIC,30));
      
      em = new JTextArea("Abdullah Emir Öztürk (EE) VETERAN", 6, 20);
      em.setFont(new Font("Arial", Font.ITALIC,12));
      em.setLineWrap(true);
      em.setWrapStyleWord(true);
      em.setOpaque(false);
      em.setEditable(false);
      
      al = new JTextArea("Alperen Balci (EE) VETERAN", 6, 20);
      al.setFont(new Font("Arial", Font.ITALIC,12));
      al.setLineWrap(true);
      al.setWrapStyleWord(true);
      al.setOpaque(false);
      al.setEditable(false);
      
      eg = new JTextArea("Ege Kemahl?o?lu  (EE) VETERAN", 6, 20);
      eg.setFont(new Font("Arial", Font.ITALIC,12));
      eg.setLineWrap(true);
      eg.setWrapStyleWord(true);
      eg.setOpaque(false);
      eg.setEditable(false);
      
      be = new JTextArea("Berkay Erkan  (EE) FRESHMAN", 6, 20);
      be.setFont(new Font("Arial", Font.ITALIC,12));
      be.setLineWrap(true);
      be.setWrapStyleWord(true);
      be.setOpaque(false);
      be.setEditable(false);
      
      game = new JTextArea("***This game was made in July 2018 by the students who wrote the above names. Students who have encountered many problems during the construction phase of the game have exceeded all of them and learned a lot.***", 6, 20);
      game.setFont(new Font("Times New Roman", Font.PLAIN, 20));
      game.setLineWrap(true);
      game.setWrapStyleWord(true);
      game.setOpaque(false);
      game.setEditable(false);
      
      setLayout(null);
      
      berkayLabel.setBounds((WIDTH/80)*5,(HEIGHT/60)*15,(WIDTH/80)*15,(HEIGHT/12)*3);
      alperenLabel.setBounds((WIDTH/80)*22,(HEIGHT/60)*15,(WIDTH/80)*15,(HEIGHT/12)*3);
      emirLabel.setBounds((WIDTH/80)*39,(HEIGHT/60)*15,(WIDTH/80)*15,(HEIGHT/12)*3);
      egeLabel.setBounds((WIDTH/80)*56,(HEIGHT/60)*15,(WIDTH/80)*15,(HEIGHT/12)*3);
      
      be.setBounds((WIDTH/80)*5 , (HEIGHT/60)*31 ,(WIDTH/80)*15 , (HEIGHT/6));
      al.setBounds((WIDTH/80)*22 , (HEIGHT/60)*31  ,(WIDTH/80)*15 , (HEIGHT/12));
      em.setBounds((WIDTH/80)*39 ,  (HEIGHT/60)*31  ,(WIDTH/80)*15 , (HEIGHT/12));
      eg.setBounds((WIDTH/80)*56 ,  (HEIGHT/60)*31 ,(WIDTH/80)*15 , (HEIGHT/12));
      
      game.setBounds((WIDTH/80)*6 , (HEIGHT/60)*40 ,(WIDTH/80)*65 , (HEIGHT/6));
      
      exit.setBounds((WIDTH/80)*58, HEIGHT/24,(WIDTH/80)*13,(HEIGHT/16));
      
      aboutUs.setBounds((WIDTH/80)*29 ,(HEIGHT/20),(WIDTH/80)*30,(HEIGHT/12)*3);
      
      exit.setBackground(new Color(127,255,212));
      
      exit.addActionListener( new OurActionListener() );
      
      add(alperenLabel);
      add(berkayLabel);
      add(emirLabel);
      add(egeLabel);
      
      add(al);
      add(be);
      add(em);
      add(eg);
      add(game);
      add(aboutUs);
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
   public JButton getExit() {
      return exit;
   }
   
   public void setExit(JButton exit) {
      this.exit = exit;
   }
       //This is a class inner class for listen the buttons click
   public class OurActionListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
         gameFrame.remove( gameFrame.aboutUs );
         gameFrame.add( gameFrame.playGamePanel );
         gameFrame.revalidate();
         gameFrame.repaint();
      }
   }
}