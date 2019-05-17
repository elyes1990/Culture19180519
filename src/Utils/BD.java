/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author heni
 */
public class BD {
    private String url="jdbc:mysql://localhost/cityculture";
    private String login="root";
    private String mdp="";
    private Connection cnx;
    static BD instance;
    private BD(){
        try {
            cnx=DriverManager.getConnection(url,login,mdp);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getCOnnection(){
        return cnx;
    }
    public static BD getInstance(){
        if(instance==null){
            instance=new BD();
        }
        return instance;
    }
           
    
}

