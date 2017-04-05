import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hradev01 on 05-Apr-17.
 */

public class exportHTML {

  public static void writeData(String data) {
    FileWriter fWriter = null;
    BufferedWriter writer = null;
    try {
      System.out.println("Writing Report HTML file . . . . ");
      fWriter = new FileWriter(".\\src\\main\\resources\\Report.html");
      writer = new BufferedWriter(fWriter);
      writer.write(data);
      writer.close();
    } catch (Exception e) {
      //catch any exceptions here
    }
  }

  public static void openHTML() {
    File htmlFile = new File("D:\\Uni 2016\\CSVLoader\\src\\main\\resources\\Report.html");
    try {
      System.out.println("Opening Report file . . . .");
      Desktop.getDesktop().browse(htmlFile.toURI());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
