package pl.coderslab.oppdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/%s?useSSL=false&characterEncoding=utf8";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "coderslab";

    public static Connection getConnection(String database) throws SQLException {
        return DriverManager.getConnection(String.format(DB_URL, database), DB_USER, DB_PASS);
    }
}
