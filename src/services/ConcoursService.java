/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import Utils.BD;
import entities.Concours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author revecom
 */
public class ConcoursService {
    Connection c = BD.getInstance().getCOnnection();    
    public ArrayList<Concours> affiche() {
        
        
        ArrayList<Concours>  ListeConcours= new ArrayList<>();
          

             try{
    String req = "select * from concours";  // retourne une liste de poste // tjr la requette select retourne des differentes resultat
            Statement ste = c.createStatement();

            //ste = mycon.prepareStatement(req);
            ResultSet resultat = c.prepareStatement(req).executeQuery(); //ensemble d'objet
            // ResultSet rs=st.executeQuery(req);
            while (resultat.next()) {
                ListeConcours.add(new Concours(
                        resultat.getInt("id"),
                        resultat.getString("titre"),
                        resultat.getString("nom_image"),
                        resultat.getString("description"),
                        resultat.getDate("date_debut"),  
                        resultat.getDate("date_fin")));}
                   } catch(SQLException ex)
        {
            System.out.println("Failed")  ;  
        }
        
        
        return ListeConcours;
    }
    
   public void ajouter(Concours C) {
           try { String req= "insert into concours (titre,nom_image,description,date_debut,date_fin) values (?,?,?,?,?)";            
            PreparedStatement ps = BD.getInstance().getCOnnection().prepareStatement(req);
                    ps.setString(1,C.getTitre());
                    ps.setString(2,C.getNom_image());
                   ps.setString(3,C.getDescription());
                    ps.setDate(4, new java.sql.Date(C.getDate_debut().getTime()));
                    ps.setDate(5, new java.sql.Date(C.getDate_fin().getTime()));
                    ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Concours Ajouter avec succes");
            System.out.println("Insertion effectue avec succes");
            } catch(SQLException ex)
        {
            System.out.println("Failed")  ;  
        }
    }   
   
    public void modifier(Concours cc) {
                       
                       
        try {
            String req = "UPDATE concours SET `titre`='"+cc.getTitre()+"',`description`='"+cc.getDescription()+"',`date_debut`='"+cc.getDate_debut()+"',`date_fin`='"+cc.getDate_fin()+"' WHERE `id`='"+cc.getId()+"'";
            Statement st = c.createStatement();
            st.executeUpdate(req);
            
            JOptionPane.showMessageDialog(null, "Concours Modifier avec succes");
            System.out.println("Modification effectuer avec succes");
        } catch(SQLException ex)
        {
            System.out.println("Failed")  ;  
        }
       
   }
    public boolean supprimer(int id) {

        try {

            PreparedStatement ps = c.prepareStatement("delete  from concours where id='" + id + "'");

            ps.execute();
            JOptionPane.showMessageDialog(null, "Concours supprimer avec succes");
            System.out.println("Suppression avec succes");
            return true;
        } catch(SQLException ex)
        {
            System.out.println("Failed")  ;  
        }
        return false;
    
}
    
    
    public List<Concours> findBydescription(String titre) throws SQLException {

       
        String sql = "select * from concours where description like'%"+titre+"%'";
        List<Concours> list = new ArrayList<>();
                        System.out.println("hello ");
                                                System.out.println("titre "+titre);


        try {
           Statement st = c.createStatement();
        ResultSet result = st.executeQuery(sql);
            
            while (result.next()) {
                Concours event = new Concours();
                
            event.setId(result.getInt("id"));   
            event.setTitre(result.getString("titre"));
            event.setDescription(result.getString("description"));
            event.setDate_fin(result.getDate("date_debut"));
            event.setDate_fin(result.getDate("date_fin"));
           
           
                
                
                list.add(event);
            }
        } catch(SQLException ex)
        {
            System.out.println("Failed")  ;  
        }

        return list;
    }
}
