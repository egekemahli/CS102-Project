
import java.io.IOException;
import javax.swing.*;
/* 
 * Main frame of the game where panels switch from one to another. In order to change the panels when a button is clicked, this class introduces itself to the panels via the constructors of panels. In addition, this class has a main method that creates a new game frame instance in order to run the game.
 * @author Abdullah Emir Öztürk
 * @version 24.07.2018
 * 
 */
public class GameFrame extends JFrame {
       //Variables, each game panels.
   PlayGamePage playGamePanel;
   CharacterSelect characterSelect;
   LevelsPane levelsPane;
   AboutUs aboutUs;
   Levels levels;
   HowToPlay howToPlay;
   
   public GameFrame() throws IOException{
      
      playGamePanel = new PlayGamePage(this);
      characterSelect = new CharacterSelect(this);
      levelsPane = new LevelsPane(this);
      aboutUs = new AboutUs(this);
      levels = new Levels( 2, 2, this);
      howToPlay = new HowToPlay(this);
      add( playGamePanel );
      setSize(800,600);
      setResizable(false);
      setVisible(true);
   }
      //main
   public static void main ( String[] args ) throws java.io.IOException 
   {
      new GameFrame();
   }
}
