import javax.swing.ImageIcon;
/* 
 * A class for Cat 
 * @author Ege Kemahlýoðlu
 * @version 24.07.2018
 * 
 */
public class CatCharacter extends Characters{
      //Constructer takes name and trick and sets them
   public CatCharacter(String name, String trick) {
      super(name, trick);
      image = new ImageIcon(getClass().getResource("cat.png"));
      
   } 
}
