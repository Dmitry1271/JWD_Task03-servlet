package by.tc.webproject.dao.connect;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by cplus on 11.11.2017.
 */
public final class ConnectorDB {
    private static final InputStream DB_PROPERTIES_FILE = ConnectorDB.class.getResourceAsStream("database.properties");
    private static Connection connection;

    private ConnectorDB() {
    }

    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        if (connection == null) {
            Properties properties = new Properties();
            InputStreamReader in = new InputStreamReader(DB_PROPERTIES_FILE);
            properties.load(in);

            String driver = properties.getProperty("db.driver");
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        }

        return connection;
    }
}


