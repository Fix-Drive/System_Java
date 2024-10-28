package fixdrive.system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {

    private static ConnectionDb instance;

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "rm558830";
    private static final String PASSWORD = "070306";
    private Connection connection;

    public static ConnectionDb getInstance(){
        if (instance == null){
            synchronized (ConnectionDb.class){
                if (instance == null){
                    instance = new ConnectionDb();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if(connection.isClosed() || connection == null){
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        }
        return connection;
    }
}
