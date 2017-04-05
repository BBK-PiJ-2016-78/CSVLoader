/**
 * Created by hradev01 on 05-Apr-17.
 */

import com.jamonapi.proxy.MonProxyFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
  private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
  private static String dbName = "FL_INSURANCE";
  private static String connectionURL = "jdbc:derby:" + dbName + ";create=true";

  /**
   * Creates a connection to the embedded database using the JDBC EmbeddedDriver.
   * @return a Monitored connection using Jamon Monitor, to get statistics log.
   */
  public static Connection connect() {
    Connection conn = null;
    Connection monConn = null;
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(connectionURL);
      monConn = MonProxyFactory.monitor(conn);
      System.out.println("Connected to database " + dbName);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    return monConn;
  }
}
