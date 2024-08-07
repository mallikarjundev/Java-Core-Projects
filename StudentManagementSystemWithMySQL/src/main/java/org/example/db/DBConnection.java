package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;

    public static Connection createConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user ="root";
            String pass="arjunoggu";
            String url="jdbc:mysql://localhost:3306/student";
            con= DriverManager.getConnection(url,user,pass);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
