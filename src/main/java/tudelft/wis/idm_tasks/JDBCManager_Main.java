package tudelft.wis.idm_tasks;

import tudelft.wis.idm_tasks.basicJDBC.interfaces.JDBCManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCManager_Main implements JDBCManager {
    static Connection connection;

    @Override
    public Connection getConnection() throws SQLException {
        if (connection == null) {
            String url = "jdbc:postgresql://localhost:5432/imdb";
            String user = "postgres";
            String password = "12345rita";
            Connection conn = DriverManager.getConnection(url, user, password);
            //Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/IMBD");
            /// jdbc:duckdb:./DB/bggt.duckdb
            // jdbc:postgresql://host:port/database
            // postgresql://postgres:12345rita@localhost:5432/IMDB
            //return conn ;
        };
        return connection;
    }
}
