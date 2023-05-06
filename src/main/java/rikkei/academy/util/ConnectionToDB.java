package rikkei.academy.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToDB {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static String URL="jdbc:mysql://localhost:3306/demo02";
    private  static  String USER= "root";
    private  static  String PASSWORD= "1993";
    public static Connection getConnection() {
        Connection connection=null;
        try {
            Class.forName(DRIVER);
            connection= DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
