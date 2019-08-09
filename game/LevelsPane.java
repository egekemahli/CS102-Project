import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.IOException;
import java.io.*;



/**
 * levels screen (panel)
 * @author Berkay Erkan
 * @version 17 July 2018
 */ 
public class LevelsPane extends JPanel
{
   //properties
   private JButton[] levels;
   private JLabel levelsLabel;
   private JButton back, createLevel;
   private JPanel centerPanel, botPanel, veryBotPanel, veryBotPanel2;
   private ImageIcon image; // lock image to be put onto the buttons of locked levels
   private int selectedLevel;
   private Game game;
   private JPanel gamePanel;
   private MazeMakerFrame makerFrame;
   private GameFrame gameFrame;
   private ArrayList<String> trueFalse;
   //constructor
   public LevelsPane( GameFrame gameFrame ) throws IOException
   {    
      trueFalse = new ArrayList<String>();
      this.gameFrame = gameFrame;
      setLayout( new BorderLayout() );    
      
      createComponents();
      addComponents();
      
      //set background of the subpanels with a same color combination
      setBackground( new Color( 224, 255, 255 ) );
      veryBotPanel2.setBackground( new Color( 224, 255, 255 ) );
      centerPanel.setBackground( new Color( 224, 255, 255 ) );
      veryBotPanel.setBackground( new Color( 224, 255, 255 ) );
   }
   
   /**
    * This method creates the components and initalizes the instance variables
    */ 
   public void createComponents() throws IOException
   {
      levelOpener();
      gamePanel = new JPanel();
      gamePanel.setLayout(new BorderLayout());
      gamePanel.setVisible(false);
      game = new Game(3,1,gameFrame);
      selectedLevel = 0;
      levelsLabel = new JLabel( "Levels" );
      levelsLabel.setFont( new Font("Arial", Font.PLAIN, 64) );
      levelsLabel.setPreferredSize( new Dimension( 225, 90 ) );
      levelsLabel.setHorizontalAlignment( JLabel.CENTER );
      
      createLevel = new JButton( "Create Your Own Maze" );
      createLevel.setSize( new Dimension( 110, 600 / 13 ) );
      createLevel.setBackground( new Color( 124, 252, 0 ) );
      createLevel.setFont( new Font( "Arial", Font.PLAIN, 26 ) );
      
      image = new ImageIcon( getClass().getResource( "Lock.png" ) );
      
      
      centerPanel = new JPanel( new GridLayout( 2, 5 ) );
      levels = new JButton[10];
     
      for ( int i = 0; i < 10; i++ )
      {
      
          
             if( trueFalse.get(i).equals("true") )
             {
                levels[i] = new JButton(String.valueOf(i+1));
                levels[i].setFont( new Font("Arial", Font.PLAIN, 28 ) );
             }
             else 
             {
                levels[i] = new JButton( null, image );
                levels[i].setFont( new Font("Arial", Font.PLAIN, 28 ) );
                levels[i].setEnabled(false);
             }
          
         levels[i].setBackground( new Color( 160, 160, 160 ) );
         centerPanel.add( levels[i] ); 
         levels[i].addComponentListener( new LevelsButtonListener() );
         levels[i].addActionListener( new CreateActionListener() );
      }
      
      
      botPanel = new JPanel( new BorderLayout() );
      
      veryBotPanel = new JPanel( new GridLayout( 3, 3 ) );
      
      veryBotPanel2 = new JPanel( new GridLayout( 1, 6 ) );
      
      back = new JButton( "Back" );
      back.setFont( new Font( "Arial", Font.PLAIN, 20 ) );
      back.setBackground( new Color(127, 255, 212) );
      back.addActionListener( new HerActionListener() );
   }
   
   /**
    * This method adds components to the created components to be used in the constructor
    */ 
   public void addComponents()
   {
      levelsLabel.addComponentListener( new LabelListener() );
      gamePanel.add(game, BorderLayout.CENTER);
      gamePanel.setSize(800,600);
      add(gamePanel,BorderLayout.CENTER);
      
      add( botPanel, BorderLayout.SOUTH );    
      
      createLevel.addComponentListener( new CreateButtonListener() );
      createLevel.addActionListener( new CreateActionListener() );
      
      add( centerPanel, BorderLayout.CENTER );
      
      //Fill some space in the panels with empty components in order to adjust the positioning of other components
      for ( int i = 0; i < 4; i++ )
      {
         veryBotPanel.add( new JLabel() );
      }
      
      veryBotPanel.add( createLevel );
      
      for ( int i = 0; i < 4; i++ )
      {
         veryBotPanel.add( new JLabel() );
      }
      
      add( levelsLabel, BorderLayout.NORTH );
      
      veryBotPanel2.add( back );
      
      for ( int c = 0; c < 5; c++ )
      {
         veryBotPanel2.add( new JLabel() );
      }
      
      botPanel.add( veryBotPanel, BorderLayout.CENTER );
      botPanel.add( veryBotPanel2, BorderLayout.SOUTH );
      botPanel.addComponentListener( new BotPanelListener() );
   }
   
   public JButton getBack()
   {
      return back;
   }
   //When clicked create your own level, an option pane pops up
   private class CreateActionListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e )
      {
         if ( e.getSource() == createLevel )
         {
            try {
               makerFrame = new MazeMakerFrame();
            } catch (IOException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            if(makerFrame.getCreated())
            {
               makerFrame.setVisible(true);
            }
            else
            {
               makerFrame.setVisible(false);
            }
         }
         
         if( e.getSource() == levels[0] )
         {
            selectedLevel = 1;
            game.getLevel(selectedLevel);
            gamePanel.setVisible(true);
            centerPanel.setVisible(false);
            botPanel.setVisible(false);
            veryBotPanel.setVisible(false); 
            veryBotPanel2.setVisible(false);
            repaint();
         }
         if( e.getSource() == levels[1] )
         {
            selectedLevel = 2;
            game.getLevel(selectedLevel);
            gamePanel.setVisible(true);
            centerPanel.setVisible(false);
            botPanel.setVisible(false);
            veryBotPanel.setVisible(false); 
            veryBotPanel2.setVisible(false);
            repaint();
         } 
         if( e.getSource() == levels[2] )
         {
            selectedLevel = 3;
            game.getLevel(selectedLevel);
            gamePanel.setVisible(true);
            centerPanel.setVisible(false);
            botPanel.setVisible(false);
            veryBotPanel.setVisible(false); 
            veryBotPanel2.setVisible(false);
            repaint();
         } 
         if( e.getSource() == levels[3] )
         {
            selectedLevel = 4;
            game.getLevel(selectedLevel);
            gamePanel.setVisible(true);
            centerPanel.setVisible(false);
            botPanel.setVisible(false);
            veryBotPanel.setVisible(false); 
            veryBotPanel2.setVisible(false);
            repaint();
         } 
         if( e.getSource() == levels[4] )
         {
            selectedLevel = 5;
            game.getLevel(selectedLevel);
            gamePanel.setVisible(true);
            centerPanel.setVisible(false);
            botPanel.setVisible(false);
            veryBotPanel.setVisible(false); 
            veryBotPanel2.setVisible(false);
            repaint();
         } 
         if( e.getSource() == levels[5] )
         {
            selectedLevel = 6;
            game.getLevel(selectedLevel);
            gamePanel.setVisible(true);
            centerPanel.setVisible(false);
            botPanel.setVisible(false);
            veryBotPanel.setVisible(false); 
            veryBotPanel2.setVisible(false);
            repaint();
         } 
      }
   }
   
   //purpose of this inner class is to increase the font of create your own level button
   private class CreateButtonListener implements ComponentListener
   {
      public void componentResized(ComponentEvent e)
      {
         createLevel.setPreferredSize( new Dimension( getWidth() / 7, getHeight() / 15 ) );
         createLevel.setFont( new Font("Arial", Font.PLAIN, ( getWidth() + getHeight() ) / 80 ) );
      }
      
      public void componentHidden(ComponentEvent e){}
      public void componentMoved(ComponentEvent e){}
      public void componentShown(ComponentEvent e){}  
   }
   
   //Resize the text font of buttons proportional to the frame size
   private class LevelsButtonListener implements ComponentListener
   {
      public void componentResized(ComponentEvent e)
      {
         for ( int i = 0; i < levels.length; i++ )
         {
            levels[i].setFont( new Font("Arial", Font.PLAIN, ( getWidth() + getHeight() ) / 60 ) );
         }
      }
      
      public void componentHidden(ComponentEvent e){}
      public void componentMoved(ComponentEvent e){}
      public void componentShown(ComponentEvent e){}  
   }
   
   //purpose of this inner class is to resize the levels label 
   private class LabelListener implements ComponentListener
   {
      public void componentResized(ComponentEvent e)
      {
         levelsLabel.setPreferredSize( new Dimension( getWidth(), getHeight() / 3 ) );
         levelsLabel.setFont( new Font("Arial", Font.PLAIN, ( getWidth() + getHeight() ) / 22 ) );
      }
      
      public void componentHidden(ComponentEvent e){}
      public void componentMoved(ComponentEvent e){}
      public void componentShown(ComponentEvent e){}
   }
   
   //purpose of this inner class is to adjust the size of bot panel while resizing the frame
   private class BotPanelListener implements ComponentListener
   {
      public void componentResized(ComponentEvent e)
      {
         botPanel.setPreferredSize( new Dimension( getWidth(), getHeight() / 3 ) );
      }
      
      public void componentHidden(ComponentEvent e){}
      public void componentMoved(ComponentEvent e){}
      public void componentShown(ComponentEvent e){}
   }
   
   public class HerActionListener implements ActionListener
   {
      public void actionPerformed( ActionEvent e)
      {
         gameFrame.remove( gameFrame.levelsPane );
         gameFrame.add( gameFrame.characterSelect );
         gameFrame.revalidate();
         gameFrame.repaint();
      }
   }
   
   @Override
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      g.drawRect( getWidth() * 3 / 10, getHeight() / 10, getWidth() * 3 / 8, getHeight() * 3 / 20 );
   }
   
   public void levelOpener() throws IOException
   {
      BufferedReader br = new BufferedReader(new FileReader("pass.txt"));  
      String st;
      while ((st = br.readLine()) != null)
      {
            trueFalse.add(st);
            System.out.println(st);
      }
      br.close();
   }
 
   
}