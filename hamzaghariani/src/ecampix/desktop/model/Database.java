/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecampix.desktop.model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MSI
 */
public class Database {
    public final String url  ="jdbc:mysql://localhost:3306/ecampix";
    public final String user ="root";
    public final String pwd = "";
    private Connection cnx;
    public static Database ct;    
    
    private Database() {
        try {
            cnx=(Connection) DriverManager.getConnection(url, user, pwd);
            System.out.println("Connected to Ecampix Database .");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static Database getInstance(){
        if(ct==null)
        ct=new Database();
        return ct;
    }
    
    public Connection getCnx() {
        return cnx;
    }     
}
