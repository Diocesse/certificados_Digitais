/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author diocesse
 */
public class ConexaoMysq {
    public Connection createConnection() throws IOException, ClassNotFoundException, SQLException {
 
        Connection connection;
         
        Properties prop = new Properties();
        System.out.println("test");
        prop.load(new FileInputStream(System.getProperty("user.home") + "/mydb.cfg"));
        System.out.println("user.home: "+System.getProperty("user.home"));
        String host = prop.getProperty("host").toString();
        String username = prop.getProperty("username").toString();
        String password = prop.getProperty("password").toString();
        String driver = prop.getProperty("driver").toString();
 
        Class.forName(driver);
      
       
        connection = DriverManager.getConnection(host, username, password);
       
        return connection;
    }
}
