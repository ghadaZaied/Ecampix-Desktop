/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzaghariani.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MSI
 */
public class DbConnect {
    public final String url  ="jdbc:mysql://localhost:3306/ecampix";
    public final String user ="root";
    public final String pwd = "";
    private Connection cnx;
    public static DbConnect ct;
    
    private DbConnect() {
        try {
            cnx=DriverManager.getConnection(url, user, pwd);
            System.out.println("Connected to Ecampix Database .");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static DbConnect getInstance(){
        if(ct==null)
        ct=new DbConnect();
        return ct;
    }
    
    public Connection getCnx() {
        return cnx;
    }    
}
