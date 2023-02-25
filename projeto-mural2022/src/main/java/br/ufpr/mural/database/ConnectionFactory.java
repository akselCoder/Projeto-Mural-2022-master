package br.ufpr.mural.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
    public Connection getConnection() {
        try {
            //MUITO IMPORTANJTE ESSA LINHA ABAIXO!!!!
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
            		"jdbc:mysql://localhost/mural", "root", "root"
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}