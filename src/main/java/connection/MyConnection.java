package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
    private static Connection connection;

    public static Connection getInstance() {
        if (connection == null) {
            connection = getConnection();
        }
        return connection;
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
<<<<<<< HEAD
            String URL = "jdbc:mysql://localhost:3306/CaseStudyModule3_1";
=======
            String URL = "jdbc:mysql://localhost:3306/casestudymodule3_1";
>>>>>>> 960573b143463020cb734918fbea135b6c545946
            String username = "root";
            String password = "123456";
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
