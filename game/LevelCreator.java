import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.awt.Color;
/* 
 * A class creates maze by using Reader class Object and initializes buttons.
 * @author Abddullah Emir Öztürk
 * @version 24.07.2018
 * 
 */
public class LevelCreator extends JPanel
{
       //Variables
   protected ArrayList<Button> buttons;
   private Reader reader;
   private int length;
   private int levelNumber;
   private String levelCode;
   private int finishIndex;
   private int dotNumber;
   private int minimumFinish;//comes from last two char of levelCode. This was implemented by ourselves.
   private int startIndex;
   //constructor
   public LevelCreator(int levelNumber) throws IOException
   {
      
      reader = new Reader(levelNumber);
      buttons = new ArrayList<Button>(); 
      levelCode = reader.getLevelCode();
      length = (int) Math.sqrt(levelCode.length());
      minimumFinish = Integer.parseInt(levelCode.substring(levelCode.length()-2,levelCode.length()));
      setLayout(new GridLayout(length,length));
      createButtons();
      labCreator();
      setBackground( new Color(224, 255, 255) );
      addComponent();
   }
     /**
   * creates length*length buttons and adds them into arraylist.
   * @param
   * @return
   */
   public void createButtons()
   {
      for( int i = 0; i < length*length; i++ )
      {
         Button button;
         button = new Button();
         button.setBorderPainted(false);
         buttons.add(button);
         if(i==0)
         {
            buttons.get(0).setMoveable(true);
         }
      }
   }
   
   public int getFinishIndex()
   {
      return finishIndex;
      
   }
   public int getStartIndex()
   {
       return startIndex;
   }
   public int getLength()
   {
      return length;
   }
           /**
   * this method uses levelCode variable which was initialized by Reader object and by looking specific chars, it creates a maze. ‘a’ char repressents ways that can be clicked. ‘b’ chars represents walls. ‘c’ char represents finish button. ‘d’ char represents start button. 
   * @param
   * @return
   */
   public void labCreator() throws IOException
   {
      
      for(int i = 0; i < levelCode.length(); i++ )
      {
         if(levelCode.charAt(i) == 'a')
         {
            buttons.get(i).setEnabled(true);
            buttons.get(i).setColor(Color.CYAN);
         }
         if(levelCode.charAt(i) == 'b')
         {
            buttons.get(i).setEnabled(false);
            buttons.get(i).setClickable(false);
            buttons.get(i).setColor(Color.BLACK);
         }
         if(levelCode.charAt(i) == 'c')
         {
            finishIndex = i;
            buttons.get(i).setEnabled(true);
            buttons.get(i).setColor(Color.YELLOW);
         }
          if(levelCode.charAt(i) == 'd')
         {
             startIndex = i;
             buttons.get(i).setEnabled(true);
            buttons.get(i).setColor(Color.ORANGE);
         }
      }
   }
   public void addComponent()
   {
      for(int i = 0; i<buttons.size(); i++)
      {
         add(buttons.get(i));
      }
   }
   public int getMinimumFinish()
   {
     return minimumFinish; 
   }
}