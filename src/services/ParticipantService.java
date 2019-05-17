/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Utils.BD;

import entities.Participant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author revecom
 */
public class ParticipantService {
    
    Connection c = BD.getInstance().getCOnnection();
    
    public ArrayList<Participant> affiche(int id ){
        
        
        ArrayList<Participant>  ListeParticipant= new ArrayList<>();
          try {

            String req = "select * from participant where id_concour ='"+id+"'";  // retourne une liste de poste // tjr la requette select retourne des differentes resultat
            Statement ste = c.createStatement();

            //ste = mycon.prepareStatement(req);
            ResultSet resultat = c.prepareStatement(req).executeQuery(); //ensemble d'objet
            // ResultSet rs=st.executeQuery(req);
            while (resultat.next()) {
                ListeParticipant.add(new Participant(
                        resultat.getInt("id"),
                        resultat.getString("nom_image"),
                        resultat.getString("nom"),
                        resultat.getString("prenom"),
                        resultat.getString("sexe"),  
                        resultat.getString("information"),
                        resultat.getInt("vote")));}
              System.err.println("participantt   "+ListeParticipant);
                   } catch(SQLException ex)
        {
            System.out.println("Failed")  ;  
        }
        

        return ListeParticipant;
    }
    
    public void ajouter(Participant P,int idc){
        try{
            
        
        
        Statement st = c.createStatement();
        int v =0;
        
        String req = "insert into participant (id_concour,nom_image,nom,prenom,sexe,information,vote) values('"+idc+"','"+P.getNom_image()+"','"+P.getNom()+"','"+P.getPrenom()+"','"+P.getSexe()+"','"+P.getInformation()+"','"+v+"') ";
            System.err.println("reeeeqqq    "+req);
        st.executeUpdate(req);
        
        }catch(SQLException e) { System.out.println(" Erreur " + e);}
        
    }
    
           public void afficher(){
        try{
            
        
        
        Statement st = c.createStatement();
        
        String req = "select * from  participant; ";
        
        
        ResultSet rs=st.executeQuery(req);
        while(rs.next())
        {
            System.out.println("id :"+ rs.getInt(1)+ " \n nom_image :"+rs.getString(3)+"\n nom : " + rs.getString(4)+"\n prenom : " + rs.getString(5)+"\n  : " + rs.getString(6)+"\n sexe : " + rs.getString(7)+"\n information : " + rs.getInt(8)+"\n vote : " );
        }
        st.executeUpdate(req);
        
        }catch(SQLException e) { System.out.println(" Erreur " + e);}
        
        
        
    }
           
    
          public boolean supprimerParticipant(int id)  {

      try{
        
       PreparedStatement ps = c.prepareStatement("delete  from participant where id='"+id+"'");
       
       ps.execute();
        System.out.println("Suppression effectuÃ©e avec succÃ¨s");
              return true;  
      }catch(SQLException e) {  System.out.println(" Erreur suppression  " + e);}
      return false;
         }
    public int getVote(int id){
        int v = 0;
          try{
            
        
        
        Statement st = c.createStatement();
        
        String req = "select * from  participant where id ='"+id+"' ";
        
        
        ResultSet rs=st.executeQuery(req);
        while(rs.next())
        {
            
            v=rs.getInt("vote");
            System.err.println("getVoteee   "+v);
        }
        st.executeQuery(req);
        
        }catch(SQLException e) { System.out.println(" Erreur " + e);}
        
        return v;
    }
    public void setVote(int id,int nvvote ) throws SQLException{
        
        
         String req = "UPDATE `participant` SET `vote`='"+nvvote+"' WHERE `id`='"+id+"'";
             Statement st = c.createStatement();
             st.executeUpdate(req);
           
       JOptionPane.showMessageDialog(null,"Vote avec succes");
        
    }
    public Participant getGan(int id){
    Participant p=new Participant();
    
     try{
            
        
        
        Statement st = c.createStatement();
        
        String req = "select * from  participant where vote = (select max(vote) from participant where id_concour='"+id+"')  ";
                   
         System.err.println("nom get "+id);
        
        ResultSet rs=st.executeQuery(req);
       
        
        if(rs.next())
        {
         p.setNom(rs.getString("nom"));
           
          
        }
        st.executeQuery(req);
        
        }catch(SQLException e) { System.out.println(" Erreur " + e);}
    
    return p;
}
}
