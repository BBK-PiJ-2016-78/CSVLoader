import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportHTML {

  /**
   * Get the report taken from the monitored connection and write it in HTML file.
   * @param data the data to be written in the html.
   */
  public static void writeData(String data) {
    FileWriter fWriter;
    BufferedWriter writer;
    String startTags = "<html lang=\"en\">\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
        +   "    <h2 align='center'>Database Monitor Results</h2>\n"
        +  "\t<link rel=\"stylesheet\" href=\"styles.css\">\n" + "</head>\n" + "<body>\n" + "\t<div>";
    String endTags = "</div>\n" + "</body>\n" + "</html>";
    String finalHTML = startTags + data + endTags;
    try {
      System.out.println("Writing Report HTML file . . . . ");
      fWriter = new FileWriter(".\\src\\main\\resources\\Report.html");
      writer = new BufferedWriter(fWriter);
      writer.write(finalHTML);
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Open the written HTML file in the default browser.
   */
  public static void openHTML() {
    File htmlFile = new File("src\\main\\resources\\Report.html");
    try {
      System.out.println("Opening Report file . . . .");
      Desktop.getDesktop().browse(htmlFile.toURI());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
