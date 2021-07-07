/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.mustfa.Services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.mustfa.Models.Equipement;
import tn.esprit.mustfa.utils.DataSource;

public class ServiceEquipements {
    
        private Connection cnx;

    public ServiceEquipements() {
        cnx = DataSource.getInstance().getCnx();
    }

    
    
    
    public void ajouterEquipement(Equipement e) throws SQLException {

        String req = "INSERT INTO equipement (equipemenst_id,equipements_cuisine,television,options_restauration,piscine,parking,hotel_id) " +
                "VALUES "
                + "('"+e.getEquipemenst_id()+"', '"+e.getEquipements_cuisine()+"', '"+e.getTelevision()+"', '"+e.getOptions_restauration()
                +"','"+e.getPiscine()
                +"','"+e.getParking()
                +"','"+e.getHotel_id()
                +"');" ;
 Statement ste = cnx.createStatement();

        ste.executeUpdate(req);
        System.out.println("INSERTION OK!!");
    }

    
    
    public void modifier(Equipement e) {
        try {
            String requete = "UPDATE equipement SET equipemenst_id=?,equipements_cuisine=?,television=?,options_restauration=?,piscine=?,parking=?,hotel_id=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, e.getEquipemenst_id());
            pst.setString(2, e.getEquipements_cuisine());
            pst.setString(3, e.getTelevision());
            pst.setString(4, e.getOptions_restauration());
            pst.setString(5, e.getPiscine());
            pst.setString(6, e.getPiscine());
            pst.setInt(7, e.getHotel_id());

            pst.executeUpdate();
            System.out.println("equi modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    
    
    
    public List<Equipement> afficherEquipement() throws SQLException{
        List<Equipement> equipement = new ArrayList<>();

        String sql = "SELECT * FROM equipement";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            Equipement e = new Equipement();
            e.setEquipemenst_id(rs.getInt("Equipement_id_id"));
            e.setEquipements_cuisine(rs.getString("Equipements_cuisine"));
            e.setTelevision(rs.getString("Television"));
            e.setOptions_restauration(rs.getString("Options_restauration"));
            e.setPiscine(rs.getString("Piscine"));
            e.setParking(rs.getString("Parking"));
            e.setHotel_id(rs.getInt("hotel_id"));
          

            equipement.add(e);

        }

        return equipement;
    }

    
    
    
    public void deleteEquipement(int id) throws SQLException{

        String sql = "delete  FROM equipement WHERE id = "+id;

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        System.out.println("equipement DELETED!");
    }
    
    
    
    
    
}
