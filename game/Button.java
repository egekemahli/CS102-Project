import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
/* 
 * A class Button sextends JButton. In order to add new features to button, we extended JButton.
 * @author Abdullah Emir Öztürk
 * @version 24.07.2018
 * 
 */
public class Button extends JButton
{
   //Variables
   private boolean moveable;
   private boolean clickable;
   private Color color;
   private boolean iconed;
   private Icon image;
   //Constructer
   public Button()
   {
      moveable = false;
      clickable = true;
      setColor(Color.BLACK);
      setOpaque(true);
      setFocusPainted(false);
      setBorderPainted(false);
      setContentAreaFilled(false);
      iconed = false;
      image = null;
      
   }
   
   public void setMoveable(boolean moveable)
   {
      this.moveable = moveable;
   }
   
   public boolean getMoveable()
   {
      return moveable;
   }
   public void setClickable(boolean clickable)
   {
      this.clickable = clickable;
   }
   
   public boolean getClickable()
   {
      return clickable;
   }
   public void setColor(Color color)
   {
      this.color = color;
      
   }
   public void setIconed(boolean b)
   {
      iconed  = b;
   }
   public void setImage(Icon image){
      this.image = image ;
   }
   public Color getColor() {
      return color;
   }
   /**
   * This method is paint color
   * @param g is a graphics
   * @return 
   */
   public void paintComponent(Graphics g)
   {
      
      if(!iconed)
      {
         super.paintComponent(g);
         g.setColor(color);
         g.fillOval(0, 0, getSize().width-1, getSize().height-1);
      }
      else{
         super.paintComponent(g); 
      }
      repaint();
   }
}