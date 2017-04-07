import org.apache.commons.io.FileUtils;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;


public class ExportHTML {

  /**
   * Get the report taken from the monitored connection and write it in HTML file.
   * @param data the data to be written in the html.
   */
   void writeData(String data) {
    FileWriter fWriter;
    BufferedWriter writer;
    String startTags = "<html lang=\"en\">\n" + "<head>\n" + "<meta charset=\"UTF-8\">\n"
        +   "    <h2 align='center'>Database Monitor Results</h2>\n"
        +  "\t<link rel=\"stylesheet\" href=\"styles.css\">\n"
        + "</head>\n" + "<body>\n" + "\t<div>";
    String endTags = "</div>\n" + "</body>\n" + "</html>";
    String finalHTML = startTags + data + endTags;
    try {
      System.out.println("Writing Report HTML file . . . . ");
      fWriter = new FileWriter("Report.html");
      writer = new BufferedWriter(fWriter);
      writer.write(finalHTML);
      writer.close();
      copyStyle();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Open the written HTML file in the default browser.
   */
  public void openHTML() {

    File htmlFile = new File("Report.html");
    try {
      System.out.println("Opening Report file . . . .");
        Desktop.getDesktop().browse(htmlFile.toURI());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Copies the style.css from inside the jar into current folder for the html to use.
   */
  public void copyStyle() {
    InputStream is = getClass().getResourceAsStream("styles.css");
    File out = new File("styles.css");
    try {
      FileUtils.copyInputStreamToFile(is, out);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
