package config;

import java.sql.*;

public class Conexion {
    
    Connection con;
    
    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_paterson", "root", "");
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public Connection getConnection() {
        return con;
    }


}
