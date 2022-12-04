package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class jdbcUtil {

    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser = "sa";
                String dbPass = "123456";
                String dbUrl = "jdbc:sqlserver://localhost:1433;"
                        + "databaseName=DUAN1;encrypt=true;trustServerCertificate=true;";

                conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);

                System.out.println("Ket noi thanh cong!");
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return jdbcUtil.conn;
    }
}
