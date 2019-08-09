import javax.swing.ImageIcon;
/* 
 * A class contains the characters main features. 
 * @author Ege Kemahlýoðlu
 * @version 24.07.2018
 * 
 */
public abstract class Characters {
   //Variables
   private String name;
   private String trick;
   protected ImageIcon image;
   //Constructer
   public Characters(String name, String trick) {
      
      this.name = name ;
      this.trick = trick;
      image = new ImageIcon();
   }
   
   public String getName() {
      return name;
   }
   public String getTrick() {
      return trick;
   }
   public ImageIcon getCharacterImage() {
      return image;
   }
}