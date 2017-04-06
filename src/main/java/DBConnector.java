import com.jamonapi.proxy.MonProxyFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnector {
  private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
  private static final String dbName = "FL_INSURANCE";
  private static final String connectionURL = "jdbc:derby:" + dbName + ";create=true";

  /**
   * Creates a connection to the embedded database using the JDBC EmbeddedDriver.
   * @return a Monitored connection using Jamon Monitor, to get statistics log.
   */
  public static Connection connect() {
    Connection conn;
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
