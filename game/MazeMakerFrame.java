import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

/* 
 * This creator tool opens a new JFrame on a game frame by clicking a button, and the user can create their level on the buttons panel.
 * @author Ege Kemahlýoðlu
 * @version 24.07.2018
 * 
 */
public class MazeMakerFrame extends JFrame {
   
   //variables
   private static int row ;
   private static int coloum ;
   private static int NUMBER_OF_BUTTONS;
   static Button[] butsArray;
   private JButton closeBut ,saveBut;
   private JLabel upperLabel;   
   private JPanel butsArrayPanel, topPanel, topPanelIn , topPanelIn2 ;
   private int saveCount;
   private int firstClick;
   private JLabel ghostLabel1 , ghostLabel2;
   private String sideLength;
   private int edgeLength;
   private int level = 0;
   private boolean levelsExistAlready = false;
   private ArrayList<String> levelList = new ArrayList<String>();
   private boolean created;
   //constructor
   public MazeMakerFrame()  throws IOException {
      getLevelList();
      getLevelChoice();
      
       if(level != -1  ){
          System.out.println("girdi");
          createComponent();
       }
       else{
         // levellara basýnca gelen yerin constructoru object oluþturmak için
         System.out.println("Tam Adý");
          //createComponent();
       }
       
   }
   
   
   public void createComponent() {
 
      optionPane();
      row = edgeLength;
      coloum = row;
      NUMBER_OF_BUTTONS = (row*coloum);
      saveCount = 0;  
      saveBut = new JButton("Save");
      closeBut = new JButton("Quit");
      butsArray = new Button[NUMBER_OF_BUTTONS];   
      upperLabel = new JLabel("Please select a start Dot");
      upperLabel.setFont(new Font("Arial", Font.ITALIC,16));
      butsArrayPanel = new JPanel();
      topPanel = new JPanel();
      topPanelIn = new JPanel();
      topPanelIn2 = new JPanel();
      
      ghostLabel1 = new JLabel();
      ghostLabel2 = new JLabel();
      
      butsArrayPanel.setLayout(new GridLayout(row, coloum));
      topPanel.setLayout(new BorderLayout());
      
      
      for (int i = 0; i < NUMBER_OF_BUTTONS; i++) {
         
         butsArray[i] = new Button();
         butsArrayPanel.add(butsArray[i]);
         butsArray[i].addMouseListener( new MazeMakerListener() );
         butsArray[i].setBorderPainted(false);
      }
      
      closeBut.addActionListener(new MyCloseListener());
      saveBut.addActionListener(new MyCloseListener());
      
      
      closeBut.setPreferredSize(new Dimension (80,50));
      saveBut.setPreferredSize(new Dimension (80,50));
      
      
      saveBut.setBackground(new Color(127,255,212));
      closeBut.setBackground(new Color(127,255,212));
      saveBut.setFont(new Font ("Arial" , Font.PLAIN, 24));
      closeBut.setFont(new Font ("Arial" , Font.PLAIN, 24));
      
      
      upperLabel.setAlignmentX(CENTER_ALIGNMENT);
      upperLabel.setFont(new Font ("Arial" , Font.PLAIN, 22));
      topPanelIn.setLayout(new GridLayout(1,3));
      topPanelIn.add(closeBut);
      topPanelIn.add(ghostLabel1);
      topPanelIn.add(saveBut);   
      topPanelIn2.add(upperLabel);
      topPanelIn.setBackground(new Color(224,255,255));
      topPanelIn2.setBackground(new Color(224,255,255));
      topPanel.setBackground(new Color(224,255,255));
      butsArrayPanel.setBackground(new Color(224,255,255));
      topPanel.add(topPanelIn,BorderLayout.NORTH);
      topPanel.add(topPanelIn2,BorderLayout.CENTER);
      add(butsArrayPanel, BorderLayout.CENTER);
      add(topPanel, BorderLayout.NORTH);
      setBounds(100,0,535,600); 
   }
   public void levelCreator()throws IOException
   {
      for(int i = 1; i < levelList.size()-1 ; i++)
      {
         LevelCreator sampleLevel = new LevelCreator(i);
         System.out.println("Selam EGE");
         //levels.add(sampleLevel);
      }
      
   }
   public boolean getCreated()
   {
      return created;
   }
   public void getLevelList() {
       
       for(int i = 0; i < 99; i++){
           File level = new File("CreatedLevel" + i + ".txt");
           if(level.exists()){
            
              levelList.add("CreatedLevel "+i+".txt");
              levelsExistAlready = true;
           }
      }
   }
   public void getLevelChoice()throws IOException{
      if(levelsExistAlready){
        
         String levels[] = new String[99];
         levelList.toArray(levels);
         levels[levelList.size()] = "New level";
         String choice = (String)JOptionPane.showInputDialog(null, "Which level would you like to play?", "Maze Level Selector", JOptionPane.QUESTION_MESSAGE, null, levels, levels[0]);
        
       if(choice != null && !choice.equals("New level")){
          
          
          //evel = Integer.parseInt(choice) ;
          //level = Integer.parseInt((choice.replace("CreatedLevel", "").replace(".txt", "")));
          System.out.println(choice);
          level = -1;
          
          JFrame frame = new JFrame();
          int x = Integer.parseInt(choice.substring(choice.length()-5, choice.length()-4));
          Levels_2ForMaker sampleLevel = new Levels_2ForMaker(x);
          frame.add(sampleLevel);
          frame.setSize(800,600);
          frame.setVisible(true);
          
          
       }
       else if(choice == null){
          
          level = -1;
       }
       else{
          created = true;
          level = levelList.size();
       }
     }
    }
   public static int getRow() {
      return row;
   }
   
   public static void setRow(int row) {
      MazeMakerFrame.row = row;
   }
   
   public static int getColoum() {
      return coloum;
   }
   
   public static void setColoum(int coloum) {
      MazeMakerFrame.coloum = coloum;
   }
   
   public void optionPane(){
      sideLength = JOptionPane.showInputDialog( "Enter side length" );
      edgeLength = Integer.parseInt( sideLength );
      JOptionPane.showMessageDialog(null, " PLEASE READ IT ! \n The creator begin with start dot  == Orange Dot\n"
         + "When you click left button you create a route == White Dot \n"
         + "All dots created as a wall by default and you can change the other route by clicking right button == Black Dot \n"
         + "To create a finish point you should press a dot  and released it on another point == Yellow Dot", "This is the introduction pop-up", TEXT_CURSOR);
   }
           /**
   * When user click “Save” button it scan all button in order, to get their color, so it creates a new level txt file in the folder
   * @param
   * @return
   */
   public void saveLevel() {
      try {
         saveCount++;
         int whiteButtonNumber = 0;
         PrintWriter writer = new PrintWriter("CreatedLevel" + (levelList.size()+1) +".txt", "UTF-8");
         for(int i = 0; i < NUMBER_OF_BUTTONS; i++){
            if(butsArray[i].getColor() == Color.BLACK) {
               writer.print('b');
            }
            else if(butsArray[i].getColor() == Color.WHITE) {
               writer.print('a');
               whiteButtonNumber++;
            }
            else if(butsArray[i].getColor() == Color.ORANGE) {
               writer.print('d');
               whiteButtonNumber++;
            }
            //for finish point 
            else {
               writer.print('c');
            }                 
         }
         writer.print(String.valueOf(whiteButtonNumber));
         writer.close();
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
   
   public class MazeMakerListener implements MouseListener {      
      
      @Override
      public void mouseClicked(MouseEvent e) {
         
         
         
         if(e.getButton() == MouseEvent.BUTTON1){
            Button coloredBut = (Button) e.getSource();
            if(firstClick == 0) {
               firstClick++; 
               coloredBut.setColor(Color.ORANGE); 
            }
            else {
               coloredBut.setColor(Color.WHITE); 
               upperLabel.setText("Save before quit");
            }
            
         }
         if(e.getButton() == MouseEvent.BUTTON3){
            
            Button coloredBut = (Button) e.getSource();
            coloredBut.setColor(Color.BLACK); 
            
         }
      }
      
      @Override
      public void mousePressed(MouseEvent e) {
         
         Button coloredBut = (Button) e.getSource();
         coloredBut.setColor(Color.YELLOW); 
      }
      
      @Override
      public void mouseReleased(MouseEvent e) {
      }
      
      @Override
      public void mouseEntered(MouseEvent e) {
      }
      
      @Override
      public void mouseExited(MouseEvent e) {    
      }
   }
   
   public class MyCloseListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         if(e.getSource() == closeBut) {
            if(saveCount == 0) {
               int reply = JOptionPane.showConfirmDialog(null, "You forget to save your level \n Do you want to quit?", "Exit", JOptionPane.YES_NO_OPTION);
               
               if(reply == JOptionPane.YES_OPTION)
               {
                  JOptionPane.showMessageDialog(null, "You can check your level from panel");
                  dispose();
               }
               else if (reply == JOptionPane.NO_OPTION)
               {
                  JOptionPane.showMessageDialog(null, "You can click save button to keep your map");
                  
               }     
               saveCount++; 
               
 
            }
            else if(saveCount >= 0) {
               dispose();
               ( (Component) e.getSource()).getParent().setVisible(false);
            }
            
         }
         else if(e.getSource() == saveBut) {
            saveLevel();
            upperLabel.setText("Save process is completed");
         }
         
      }
   }
   /*
    *  //Levellar? gosteren panele ekle
    public void getLevelList(){
    for(int i = levels.size() ; i < 11 ; i++){
    
    File level = new File("./Level " + i + ".txt");
    if(map.exists()){
    
    System.out.println("Level " + i + " exists");
    }
    }
    }
    */
}