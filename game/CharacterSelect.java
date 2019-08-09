import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/* 
 * A class returns the selected character into the game and show the characters tricks into panel.
 * @author Ege Kemahlýoðlu
 * @version 24.07.2018
 * 
 */
public class CharacterSelect extends JPanel {
   //Variables
   private final int WIDTH = 800, HEIGHT = 600; 
   private JLabel saying ;
   private JLabel botGhostLabel, characterIntro;
   private JRadioButton catb , dogb, dinob;
   private ArrayList<Characters> characters;
   private JButton nextBut , backBut ;
   private JPanel bigTopPanel, radioPanel;
   private JButton[] jbuttonArray;
   private CharacterListener alistener;
   private JRadioButton[] jrbuttonArray;
   private Characters selectedCharacter;
   private GameFrame gameFrame;
   JPanel topPanel, botPanel;
   
   public CharacterSelect( GameFrame gameFrame ) {
      this.gameFrame = gameFrame;
      setPreferredSize(new Dimension (WIDTH, HEIGHT));
      setLayout(new BorderLayout());
      createCharacters();
      setBackground(Color.WHITE);
      
      createBotPanel();
      bigTopPanel.setBackground(new Color(224,255,255));
      radioPanel.setBackground(new Color(224,255,255));
      topPanel.setBackground(new Color(224,255,255));
      botPanel.setBackground(new Color(224,255,255));
      
   }
     /**
   *  This method generates the characters list and assign a JButton and JRadioButton for each character and call their features (ex. Tricks, image) , then add actionlistener to the buttons. 
   * @param 
   * @return 
   */
   public void createCharacters() {
      bigTopPanel = new JPanel();
      bigTopPanel.setLayout(new GridLayout(3,1));
      
      topPanel = new JPanel();
      
      characters = new ArrayList<Characters>();
      Characters dog = new DogCharacter("dog","Woof Woof! Select me I'm very friendly ");
      Characters cat = new CatCharacter("cat","Miyav, Miyav! Where is the rat! ");
      Characters dino = new DinoCharacter("dino","Take me! I'm hungry , Let's go find a meal! ");
      characters.add(dog);
      characters.add(cat);
      characters.add(dino);
      alistener = new CharacterListener();
      jbuttonArray = new JButton[characters.size()]; 
      jrbuttonArray = new JRadioButton [characters.size()];
      
      
      for(int i = 0 ; i < characters.size() ; i++) {
         
         jbuttonArray[i] = new JButton(null,characters.get(i).getCharacterImage());
         jbuttonArray[i].addActionListener(alistener);
         topPanel.add(jbuttonArray[i]);
         jrbuttonArray [i] = new JRadioButton (characters.get(i).getName()); 
         jrbuttonArray [i].addActionListener(alistener);
         jrbuttonArray [i].setBackground(new Color(224,255,255));
      }
      
      //at the start we should select a selected character
      jrbuttonArray[0].setSelected(true); 
      saying = new JLabel (characters.get(0).getTrick());
      saying.setFont(new Font ("Arial" , Font.PLAIN, 30));
      topPanel.add(saying);
      dogb = jrbuttonArray [0];
      catb = jrbuttonArray [1];
      dinob = jrbuttonArray [2];
      dogb.setFont(new Font ("Arial" , Font.PLAIN, 24));
      catb.setFont(new Font ("Arial" , Font.PLAIN, 24));
      dinob.setFont(new Font ("Arial" , Font.PLAIN, 24));
      
      radioPanel = new JPanel();
      radioPanel.add(dogb);
      radioPanel.add(catb);
      radioPanel.add(dinob);
      characterIntro =new JLabel();
      characterIntro.setText("Pick your character!");
      characterIntro.setFont(new Font ("Arial" , Font.PLAIN, 40));
      characterIntro.setHorizontalAlignment(JLabel.CENTER);
      
      bigTopPanel.add(characterIntro);
      bigTopPanel.add(topPanel);
      bigTopPanel.add(radioPanel);
      add(bigTopPanel,BorderLayout.CENTER);
      
   }
           /**
   * This method creates 2 JButton to provide passing into panels, it  also adjust their size, coordinates, color, font and add the listeners.
   * @param 
   * @return 
   */
   public void createBotPanel() {
      
      botPanel = new JPanel();
      botPanel.setLayout(new GridLayout(1,3));
      nextBut = new JButton("Next");
      nextBut.addActionListener( new HisActionListener() );
      backBut = new JButton("Back"); 
      backBut.addActionListener( new HisActionListener() );
      botGhostLabel = new JLabel();
      nextBut.setBackground(new Color(127,255,212));
      backBut.setBackground(new Color(127,255,212));
      nextBut.setPreferredSize(new Dimension(80,50) );
      backBut.setPreferredSize(new Dimension(80,50) );
      botPanel.add(backBut);
      botPanel.add(botGhostLabel);
      botPanel.add(nextBut);
      
      add(botPanel,BorderLayout.SOUTH);
   }
   public JButton getNextBut() {
      return nextBut;
   }
   
   public void setNextBut(JButton nextBut) {
      this.nextBut = nextBut;
   }
   
   public JButton getBackBut() {
      return backBut;
   }
   
   public void setBackBut(JButton backBut) {
      this.backBut = backBut;
   }
   
   private class CharacterListener implements ActionListener {  
      /*
       * Set the character of the game depending on which button is selected.
       */
      @Override
      public void actionPerformed(ActionEvent e) {
         
         Object source  = e.getSource();
         //characters ve button arrayi sýrasý 1-dog 2-cat 3-dino
         
         if(source == jbuttonArray[0] ){
            dogb.setSelected(true);
            catb.setSelected(false);
            dinob.setSelected(false);
            saying.setText(characters.get(0).getTrick());
            selectedCharacter = characters.get(0);
            
         }
         else if( source == jbuttonArray[1] ){
            
            catb.setSelected(true);
            dogb.setSelected(false);
            dinob.setSelected(false);
            saying.setText(characters.get(1).getTrick());
            selectedCharacter = characters.get(1);
            
         }
         else if(source == jbuttonArray[2]) {
            dinob.setSelected(true);
            catb.setSelected(false);
            dogb.setSelected(false);
            saying.setText(characters.get(2).getTrick());
            selectedCharacter = characters.get(2);
         }
         else if (source == dogb) {
            
            dogb.setSelected(true);
            catb.setSelected(false);
            dinob.setSelected(false);
            saying.setText(characters.get(0).getTrick());
            selectedCharacter = characters.get(0);
         }
         else if (source == catb) {
            catb.setSelected(true);
            dogb.setSelected(false);
            dinob.setSelected(false);
            saying.setText(characters.get(1).getTrick());
            selectedCharacter = characters.get(1);
         }
         else if (source == dinob) {
            
            dinob.setSelected(true);
            catb.setSelected(false);
            dogb.setSelected(false);
            saying.setText(characters.get(2).getTrick());
            selectedCharacter = characters.get(2);
         }
      }
   }
      //This is a inner class for take characters.
   public class HisActionListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
         if ( e.getSource() == nextBut )
         {
            gameFrame.remove( gameFrame.characterSelect );
            gameFrame.add( gameFrame.levelsPane );
            gameFrame.revalidate();
            gameFrame.repaint();
         }
         else if ( e.getSource() == backBut )
         {
            gameFrame.remove( gameFrame.characterSelect );
            gameFrame.add( gameFrame.playGamePanel );
            gameFrame.revalidate();
            gameFrame.repaint();
         }
      }
   }
   
   
}