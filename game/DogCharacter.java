import javax.swing.ImageIcon;
/* 
 * A class for dog characters.
 * @author Ege Kemahl�o�lu
 * @version 24.07.2018
 * 
 */
public class DogCharacter extends Characters {
      //Constructer takes name and trick and sets them
   public DogCharacter(String name, String trick) {
      super(name, trick);
      image = new ImageIcon(getClass().getResource("dog.png"));
   }
}
