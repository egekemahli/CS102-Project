import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.*;
/* 
 * The game will be played under the control of this class. Because it holds created level objects.
 * @author Abddullah Emir Öztürk
 * @version 24.07.2018
 * 
 */
public class Levels extends JPanel
{
   //attributes
   public ArrayList<LevelCreator> levels;
   private ImageIcon hunter;
   private ImageIcon victim;
   private ActionListener listener;
   private int numberOfLevels;
   private int selectedLevel;
   private int count;
   private int indexOfButton;
   private JLabel number;
   private boolean finished;
   private GameFrame gameFrame;
   private JButton exit;
   private int minimumFinish;
   
   public Levels(int numberOfLevels,int selectedLevel, GameFrame gameFrame) throws IOException
   {
      victim = new ImageIcon(getClass().getResource("berkay2.jpg"));
      this.gameFrame = gameFrame;
      minimumFinish  = 0;
      count = 0;
      indexOfButton = 0;
      setSize(800,600);
      number = new JLabel("0");
      int random = (int)(Math.random()*3);
      if(random == 0){
         hunter = new ImageIcon(getClass().getResource("cat1.png")); 
         System.out.println("2");
      }
      if(random == 1){
         hunter = new ImageIcon(getClass().getResource("dino1.png"));
         System.out.println("3");
      }
      if(random == 2){
         hunter = new ImageIcon(getClass().getResource("dog1.png"));
         System.out.println("1");
      }
      
      exit = new JButton("MAIN MENU");
      this.selectedLevel = (selectedLevel-1);
      this.numberOfLevels = numberOfLevels;
      levels = new ArrayList<LevelCreator>();
      listener = new ClickListener();
      levelCreator();
      number.setBounds(685,305,125,40);
      number.setFont( new Font( "Arial", Font.PLAIN, 18 ) );
      add(number);
      addListener();
      (levels.get(this.selectedLevel)).setSize(450,450);
      add(levels.get(this.selectedLevel));
      (levels.get(this.selectedLevel)).setBounds(80,50,450,450);
      minimumFinish = (levels.get(this.selectedLevel)).getMinimumFinish();
      
      finished = false;
      
      setBackground( new Color(224, 255, 255) );
   }
   
   /**
   * This method creates an instance of levelCreator class object and adds them to the levels ArrayList. 
   * @param
   * @return
   */
   public void levelCreator()throws IOException
   {
      for(int i = 1; i <= numberOfLevels; i++)
      {
         LevelCreator sampleLevel = new LevelCreator(i);
         levels.add(sampleLevel);
      }
      
   }
   
   public int getCount()
   {
      return count;
   }
   
   public void addListener()
   {
      for(int i = 0; i<(levels.get(selectedLevel)).buttons.size(); i++)
      {
         (levels.get(selectedLevel)).buttons.get(i).addActionListener(listener);
      }
      (levels.get(selectedLevel)).buttons.get(levels.get(selectedLevel).getStartIndex()).doClick();
   
   }
   
   public JPanel getPanel()
   {
      return this;
      
   }
   public void restart()
   {
      for( int j = 1; j<levels.get(selectedLevel).buttons.size(); j++)
      {
         levels.get(selectedLevel).buttons.get(j).setMoveable(false);
      }
      for(int j = 0; j<levels.get(selectedLevel).buttons.size(); j++)
      {
         levels.get(selectedLevel).buttons.get(j).setEnabled(true);
         levels.get(selectedLevel).buttons.get(j).setIconed(false);
         levels.get(selectedLevel).buttons.get(j).setIcon(null);
      }
      levels.get(selectedLevel).buttons.get(levels.get(selectedLevel).getFinishIndex()).setColor(Color.YELLOW);
      levels.get(selectedLevel).buttons.get(levels.get(selectedLevel).getStartIndex()).setColor(Color.ORANGE);
      levels.get(selectedLevel).buttons.get(levels.get(selectedLevel).getStartIndex()).setMoveable(true);
      count = 0;
      levels.get(selectedLevel).buttons.get(0).doClick();
      levels.get(selectedLevel).buttons.get(levels.get(selectedLevel).getFinishIndex()).setIconed(true);
      levels.get(selectedLevel).buttons.get(levels.get(selectedLevel).getFinishIndex()).setIcon(victim);
      
   }
   public JButton getExit()
   {
      return exit;
   }
      /**
   * According to the algorithms of this method, the user can see the movable buttons every time after a click. If the clicked button is the last button of the maze, the finished variable will be set as true. In addition, this method restricts the user to click the buttons that are not next to the current position of the character.
   * @param
   * @return
   */
   public void move(int i)
   {
      if(i != levels.get(selectedLevel).getStartIndex())
      {
         count++;
      }
      number.setText(String.valueOf(getCount()));
      if(i == levels.get(selectedLevel).getFinishIndex())
      {
         finished= true;
         
         for( int j = 0; j<levels.get(selectedLevel).buttons.size(); j++)
         {
            
            if(j != levels.get(selectedLevel).getFinishIndex())
            {
               
               levels.get(selectedLevel).buttons.get(j).setEnabled(false);
               
            }
         }
         
         
      }
      repaint();
      for( int j = 1; j<levels.get(selectedLevel).buttons.size(); j++)
      {
         levels.get(selectedLevel).buttons.get(j).setMoveable(false);
      }
     
      //for corners
      if(i==0)
      {
         levels.get(selectedLevel).buttons.get(i+1).setMoveable(true);
         levels.get(selectedLevel).buttons.get( i + levels.get(selectedLevel).getLength() ).setMoveable(true);
      }
      if(i==levels.get(selectedLevel).getLength()-1)
      {
         levels.get(selectedLevel).buttons.get(i-1).setMoveable(true);
         levels.get(selectedLevel).buttons.get( i + levels.get(selectedLevel).getLength() ).setMoveable(true);
      }
      if(i==( levels.get(selectedLevel).getLength()*levels.get(selectedLevel).getLength())-levels.get(selectedLevel).getLength())
      {
         levels.get(selectedLevel).buttons.get(i+1).setMoveable(true);
         levels.get(selectedLevel).buttons.get( i - levels.get(selectedLevel).getLength() ).setMoveable(true);
      }
      if(i==( levels.get(selectedLevel).getLength()*levels.get(selectedLevel).getLength())-1)
      {
         levels.get(selectedLevel).buttons.get(i-1).setMoveable(true);
         levels.get(selectedLevel).buttons.get( i - levels.get(selectedLevel).getLength() ).setMoveable(true);
      }
      
      //for kenar
      
      if( i>0&& i<(levels.get(selectedLevel).getLength()*levels.get(selectedLevel).getLength())-levels.get(selectedLevel).getLength() && i%levels.get(selectedLevel).getLength()==0)  //left
      {
         levels.get(selectedLevel).buttons.get(i+1).setMoveable(true);
         levels.get(selectedLevel).buttons.get(i+levels.get(selectedLevel).getLength()).setMoveable(true);
         levels.get(selectedLevel).buttons.get(i-levels.get(selectedLevel).getLength()).setMoveable(true);
      }
      
      if( i>levels.get(selectedLevel).getLength()-1&& i<levels.get(selectedLevel).getLength()*levels.get(selectedLevel).getLength()-1 && i%levels.get(selectedLevel).getLength()==levels.get(selectedLevel).getLength()-1)  //right
      {
         levels.get(selectedLevel).buttons.get(i-1).setMoveable(true);
         levels.get(selectedLevel).buttons.get(i+levels.get(selectedLevel).getLength()).setMoveable(true);
         levels.get(selectedLevel).buttons.get(i-levels.get(selectedLevel).getLength()).setMoveable(true);
      }
      
      //top and inside
      if( (i%levels.get(selectedLevel).getLength()) < levels.get(selectedLevel).getLength()-1 && (i%levels.get(selectedLevel).getLength()) > 0 )
      {
         if( i>0 && i<levels.get(selectedLevel).getLength()-1)//top
         {
            levels.get(selectedLevel).buttons.get(i-1).setMoveable(true);
            levels.get(selectedLevel).buttons.get(i+1).setMoveable(true);
            levels.get(selectedLevel).buttons.get(i+levels.get(selectedLevel).getLength()).setMoveable(true);
         }
         
         else if( !(i>(levels.get(selectedLevel).getLength()*levels.get(selectedLevel).getLength())-levels.get(selectedLevel).getLength()) && !(i<levels.get(selectedLevel).getLength()-1))//bottom
         {
            
            levels.get(selectedLevel).buttons.get(i-1).setMoveable(true);
            levels.get(selectedLevel).buttons.get(i+1).setMoveable(true);
            levels.get(selectedLevel).buttons.get(i- levels.get(selectedLevel).getLength()).setMoveable(true);
            levels.get(selectedLevel).buttons.get(i+ levels.get(selectedLevel).getLength()).setMoveable(true);
            
         }
         else 
         {
            levels.get(selectedLevel).buttons.get(i-1).setMoveable(true);
            levels.get(selectedLevel).buttons.get(i+1).setMoveable(true);
            levels.get(selectedLevel).buttons.get(i-levels.get(selectedLevel).getLength()).setMoveable(true);
            
         }
      }
      levels.get(selectedLevel).buttons.get(0).setMoveable(false);
      
      
   }
   public int getIndexOfButton()
   {
      return indexOfButton;
   }
   public boolean getFinished()
   {
      return finished;
   }
   public void setFinished(boolean a)
   {
      finished = a;
   }
   public void setCount(int a)
   {
      count = a;
   }
      //inner class for users act. Moves the character to the clicked location. Sets the color of movable buttons as green. The color of other locations except walls are set as cyan.
   private class ClickListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         
         if(((Button) e.getSource()).getMoveable())
         {
            for(int i = 0; i< levels.get(selectedLevel).buttons.size(); i++)
            {
               if( e.getSource() == levels.get(selectedLevel).buttons.get(i)  )
               {
                  indexOfButton= i;
                  move(i);
                  if(i !=levels.get(selectedLevel).getStartIndex())
                  {
                     ( (Button) e.getSource()).setColor(Color.RED);
                  }
                  ( (Button) e.getSource()).setIconed(true);
                  
                  levels.get(selectedLevel).buttons.get(i).setIcon(hunter);
                  for(int j = 0; j<levels.get(selectedLevel).buttons.size(); j++)
                  {
                     if(j !=  indexOfButton)
                     {
                        levels.get(selectedLevel).buttons.get(j).setIconed(false);
                        levels.get(selectedLevel).buttons.get(j).setIcon(null);
                     }
                     
                        levels.get(selectedLevel).buttons.get(levels.get(selectedLevel).getFinishIndex()).setIconed(true);
                        levels.get(selectedLevel).buttons.get(levels.get(selectedLevel).getFinishIndex()).setIcon(victim);
                        
                    
                     
                  }
                  if(( (Button) e.getSource()).getText().equals("FINISH"))
                  {
                     finished = true;
                  }
               }
            }
            
            for(int j = 0; j< levels.get(selectedLevel).buttons.size(); j++)
            {
               if(levels.get(selectedLevel).buttons.get(j).getMoveable()&& levels.get(selectedLevel).buttons.get(j).getClickable() && j != levels.get(selectedLevel).getFinishIndex())
               {
                  levels.get(selectedLevel).buttons.get(j).setColor(Color.GREEN);
               }
            }
            for(int j = 0; j< levels.get(selectedLevel).buttons.size(); j++)
            {
               if(!levels.get(selectedLevel).buttons.get(j).getMoveable()&& levels.get(selectedLevel).buttons.get(j).getClickable()&& j != indexOfButton && j != levels.get(selectedLevel).getFinishIndex() && j !=levels.get(selectedLevel).getStartIndex() )
               {
                  levels.get(selectedLevel).buttons.get(j).setColor(Color.CYAN);
               }
            }
            
         }
         repaint();
      }  
   }
   public class TheirActionListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
         if ( e.getSource() == exit ){
         int reply = JOptionPane.showConfirmDialog(null, "Do you want to go the main menu?", "Exit", JOptionPane.YES_NO_OPTION);
               
               if(reply == JOptionPane.YES_OPTION)
               {
                   gameFrame.setVisible(false);
                   gameFrame.dispose(); 
                   try{ new GameFrame(); }
                   catch (java.io.IOException b){};
               }
               else if (reply == JOptionPane.NO_OPTION)
               {
                  JOptionPane.showMessageDialog(null, "You can continue");
                  
               }     
         
           
            
            
            
            
            
           
         }
      }
   }
   public int getMinimumFinish(){
      return minimumFinish;
   }
   
}