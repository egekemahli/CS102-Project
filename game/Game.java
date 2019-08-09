import javax.swing.*;
import java.io.IOException;
import java.awt.*;
import java.util.*;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
/* 
 * An additional class that assists the implementation of game. This class initializes objects of levels class and manages the end game process by displaying the stars count and next level button. As an implementation detail, this class sets the visibility of the current level as true and the else as false. After user passes to the next level, the next level becomes visible and the visibility of the previous level becomes false.
 * @author Abdullah Emir Öztürk
 * @version 24.07.2018
 * 
 */
public class Game extends JPanel
{
      //Variables: finishPanel, starPanel, botPanel: required panels to manage the end game process.
   private int numberOfLevels;
   private int selectedLevel;
   private ArrayList<Levels_2> levels;
   private Levels_2 game;
   private JButton nextLevel;
   private ActionListener listener;
   private MouseListener listenerr;
   private JPanel finishPanel;
   private JPanel starPanel, botPanel;
   private JFrame frame;
   private GameFrame gameFrame;
   private JLabel starPanelLabel;
   private final int MINIMUM_COUNT_FOR_STAR = 15;
   private ArrayList<String> trueFalse;
   private File file;
   //const.
   public Game(int numberOfLevels, int selectedLevel, GameFrame gameFrame) throws IOException
   {
      trueFalse = new ArrayList<String>();
      this.gameFrame = gameFrame;
      starPanelLabel = new JLabel();
      starPanelLabel.setFont( new Font( "Arial", Font.PLAIN, 20 ) );
      starPanelLabel.setHorizontalAlignment( JLabel.CENTER );
      frame = new JFrame();
      frame.setLayout( new GridLayout(3,1));
      finishPanel = new JPanel();
      starPanel = new JPanel();
      starPanel.setSize(300,100);
      frame.add(starPanel);
      frame.add( starPanelLabel );
      frame.add(finishPanel);
      frame.setVisible(false);
      botPanel = new JPanel( new GridLayout( 3, 3) );
      frame.setSize(400,400);;
      finishPanel.setBounds(600,600,100,100);
      this.numberOfLevels = numberOfLevels;
      this.selectedLevel = selectedLevel;
      finishPanel.setLayout(new BorderLayout());
      finishPanel.setSize(300,300);
      finishPanel.setVisible(true);
      listener = new ClickListener();
      listenerr = new MouseListenerr();
      addMouseListener(listenerr);
      nextLevel = new JButton("NEXT LEVEL");
      nextLevel.addActionListener(listener);
      nextLevel.setEnabled(false);
      nextLevel.setBackground( new Color( 204, 153, 255 ) );
      botPanel.add( new JLabel() );
      botPanel.add( nextLevel );
      
      
      for ( int a = 0; a < 7; a++ )
      {
         botPanel.add( new JLabel() );
      }
      
      
      finishPanel.add(botPanel, BorderLayout.CENTER);
      levels = new ArrayList<Levels_2>();
      level();
      setLayout(new BorderLayout());
      levelAdder();
      
   }
   /**
   * This method creates levels and adds them to the levels ArrayList.
   * @param
   * @return 
   */
   public void level()  throws IOException
   {
      for(int i = 1; i<=numberOfLevels; i++)
      {
         game = new Levels_2(numberOfLevels, i, gameFrame);
         game.setVisible(false);
         levels.add(game); 
      }  
   }
   
   /**
   * This method adds levels object that comes from levels Arraylist to the game panel
   * @param
   * @return 
   */
   public void levelAdder()
   {
      for(int i = 1; i<=numberOfLevels; i++)
      {
         add(levels.get(i-1),BorderLayout.CENTER);
      }  
   }
   
        /**
   * This method returns the level that is going to be opened.
   * @param a: int for selected level
   * @return Levels_2 object
   */
   public Levels_2 getLevel(int a)
   {
      int x = a-1;
      
      levels.get(x).setVisible(true);
      for(int i  = 0; i<levels.size(); i++)
      {
         if(i != x)
         {
            levels.get(i).setVisible(false);
         }
         
      }
      repaint();
      return levels.get(a-1);
   }
   
   
   public class ClickListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(((JButton)e.getSource()).getText().equals("NEXT LEVEL"))
         {
            if(levels.get(selectedLevel-1).getFinished())
            {
               nextLevel();
            }
            
         }
         repaint();
         
      }
      
   }
   
   private class MouseListenerr implements MouseListener 
   {
      
      public void mouseClicked( MouseEvent e){
         
         PrintWriter writer = null;
         try {
            writer = new PrintWriter(new File ("pass.txt"));
            writer.println( "true" );
            
         } catch (FileNotFoundException e1) {
            
            e1.printStackTrace();
         }
         
         if(levels.get(selectedLevel-1).getFinished())
         {
            
            
            if( levels.get(selectedLevel-1).getMinimumFinish()+MINIMUM_COUNT_FOR_STAR < levels.get(selectedLevel-1).getCount() )
            {
               trueFalse.add("false");
               nextLevel.setEnabled(false);
               frame.setVisible(true);
               starPanelLabel.setText( "NO STARS, TRY AGAIN" );
            }
            else
            {
               trueFalse.add("true");
               if(levels.get(selectedLevel-1).getMinimumFinish()+5 >= levels.get(selectedLevel-1).getCount())
               {
                  starPanel.add(new JLabel(new ImageIcon("star.png")));
                  starPanel.add(new JLabel(new ImageIcon("star.png")));
                  starPanel.add(new JLabel(new ImageIcon("star.png")));
                  starPanelLabel.setText( "GREAT! YOU COMPLETED LEVEL" );
               }
               if(levels.get(selectedLevel-1).getMinimumFinish()+10 >= levels.get(selectedLevel-1).getCount() &&levels.get(selectedLevel-1).getMinimumFinish()+5 < levels.get(selectedLevel-1).getCount() )
               {
                  starPanel.add(new JLabel(new ImageIcon("star.png")));
                  starPanel.add(new JLabel(new ImageIcon("star.png")));    
                  starPanelLabel.setText( "WELL DONE, YOU COMPLETED LEVEL" );
               }
               if(levels.get(selectedLevel-1).getMinimumFinish()+10 < levels.get(selectedLevel-1).getCount() &&levels.get(selectedLevel-1).getMinimumFinish()+15 >= levels.get(selectedLevel-1).getCount() )
               {
                  starPanel.add(new JLabel(new ImageIcon("star.png")));
                  starPanelLabel.setText( "YOU COULD DO BETTER!" );
               }
               nextLevel.setEnabled(true);
               frame.setVisible(true);
            }
            
            
         }
         int d = 0;
         for( int i = 0; i<trueFalse.size(); i++)
         {
            writer.println( trueFalse.get(i));    
            d = i;
         }
         for( int i = d+1; i < 11-d; i++)
         {
            //trueFalse.set(0, "true");
            writer.println( "false" );
         }
         writer.close();
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
    /**
   * By the agency of this method, whenever the next level button is clicked after a level ends, the next level becomes playable.
   * @param
   * @return levels_2 object for nextLevel
   */
   private Levels_2 nextLevel()
   {
      frame.setVisible(false);
      starPanel.removeAll();
      nextLevel.setEnabled(false);
      
      if(levels.get(selectedLevel-1).getFinished())
      {
         selectedLevel++;
         return getLevel(selectedLevel);
         
      }
      return null;
   }
}