import javax.swing.ImageIcon;
/* 
 * A class for dino characters.
 * @author Ege Kemahlýoðlu
 * @version 24.07.2018
 * 
 */
public class DinoCharacter extends Characters{
   //Constructer takes name and trick and sets them
   public DinoCharacter(String name, String trick) {
      super(name, trick);
      image = new ImageIcon(getClass().getResource("dino.png"));
      
   }
}
