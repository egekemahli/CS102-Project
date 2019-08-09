import java.io.*;
import java.io.IOException;
/* 
 * This class is used to in LevelCreator class in order to scan a level file to create its maze
 * @author Abddullah Emir Öztürk
 * @version 24.07.2018
 * 
 */
public class ReaderForMaker  
{
        //Variables
   private int levelNumber;

   private String levelCode2;
   //Constructer
   public ReaderForMaker(int levelNumber) throws IOException
   {
      this.levelNumber = levelNumber;

      convertInputStreamToString2();
   }
          /**
   * This method includes BufferReader object and it scans txt file. In order to determine name of the txt file, it uses levelNumber. For example if user enters 1, this method finds and scans level1.txt file. Therefore, it determines the maze(levelCode) according to the code that was implemented before in file.
   * @param
   * @return
   */
   
   public void convertInputStreamToString2() throws IOException
   {
      BufferedReader br = new BufferedReader(new FileReader("CreatedLevel"+levelNumber+".txt"));  
      String st;
      while ((st = br.readLine()) != null)
      {
         levelCode2 = st;
      }
      br.close();
   }
   

   public String getLevelCode2()
   {
      return levelCode2;
   }
}