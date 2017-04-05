/**
 * Created by hradev01 on 05-Apr-17.
 */

import java.sql.Connection;
import java.util.Scanner;

public class Launcher {

  public static void main(String[] args) {
    Connection conn = DBConnector.connect();
    DBCreator creator = new DBCreator(conn);
    Launcher launcher = new Launcher();

    String data = null;
    try {
      creator.createTable();
      data = launcher.menu(creator);
      creator.selectRows();
      exportHTML.writeData(data);
      exportHTML.openHTML();
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String menu(DBCreator creator) throws Exception {

    String data = null;
    Scanner sc = new Scanner(System.in);

    System.out.println(" ________________________________________________________________");
    System.out.println("| To load the CSV file into database choose option:              |");
    System.out.println("| 1. Load it row by row with commiting separate INSERT statements|");
    System.out.println("| 2. Load it row by row but commit as a unit                     |");
    System.out.println("| 3. Load it in a single batch unit                              |");
    System.out.println("| 4. Load it in multiple batches of 1000 size                    |");
    System.out.println("|________________________________________________________________|");
    System.out.print("Enter choice: ");
    int choice = sc.nextInt();

    switch(choice) {
      case 1: data = creator.loadCSV(true, false, false, true);
              break;
      case 2: data = creator.loadCSV(true, false, false, false);
              break;
      case 3: data = creator.loadCSV(false, true, false, false);
              break;
      case 4: data = creator.loadCSV(false, false, true, false);
              break;
      default: System.out.println("Invalid input!");
               data = menu(creator);
               break;
    }

    return data;
  }
}
