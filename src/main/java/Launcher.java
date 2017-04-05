/**
 * Created by hradev01 on 05-Apr-17.
 */

import java.sql.Connection;

public class Launcher {

  public static void main(String[] args) {
    Connection conn = DBConnector.connect();
    DBCreator creator = new DBCreator(conn);

    Object[][] data = null;
    try {
      creator.createTable();
      data  = creator.loadCSV(false, false, true, false);
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
