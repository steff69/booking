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
import tn.esprit.mustfa.Models.Chambre;
import tn.esprit.mustfa.utils.DataSource;
public class ServiceChambre {
    private Connection cnx;

    public ServiceChambre() {
        cnx = DataSource.getInstance().getCnx();
    }

    public void ajouterChambre(Chambre c) throws SQLException {

        String req = "INSERT INTO chambre (chambre_id,nom_chambre,description,hotel_id,type_chambre,vue,etage,prix,fk_chambre_hotel) " +
                "VALUES "
                + "('"+c.getChambre_id()+"', '"+c.getNom_chambre()+"', '"+c.getDescription()+"', '"+c.getHotel_id()
                +"', '"+c.getType_chambre()+"', '"+c.getVue()+"', '"+c.getEtage()+"', '"+c.getPrix()+"', '"+c.getFk_chambre_hotel()+"');";

        Statement ste = cnx.createStatement();

        ste.executeUpdate(req);
        System.out.println("INSERTION OK!!");
    }



    public boolean supprimerPersonne(int id) throws SQLException{

        String sql = "DELETE FROM personne WHERE id = " +id;

        Statement ste = cnx.createStatement();

        if (ste.executeUpdate(sql) == 1) {
            return true;
        }

        return false ;
    }

    public List<Chambre> afficherChambres(){
        
        List<Chambre> chambres = new ArrayList<>();
        
         try {

        String sql = "SELECT * FROM chambre";

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            Chambre c = new Chambre();
            c.setChambre_id(rs.getInt("chambre_id"));
            c.setNom_chambre(rs.getString("nom_chambre"));
            c.setDescription(rs.getString("description"));
            c.setHotel_id(rs.getInt("hotel_id"));
            c.setType_chambre(rs.getString("type_chambre"));
            c.setVue(rs.getString("vue"));
            c.setEtage(rs.getInt("etage"));
            c.setPrix(rs.getInt("prix"));
            c.setFk_chambre_hotel(rs.getInt("fk_chambre_hotel"));
        chambres.add(c);

            
        }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
return chambres;
        
        
        
    }
    public Chambre afficherChambreById(int id) throws SQLException{
        Chambre chambre= null;

        String sql = "SELECT * FROM chambre WHERE id = "+id;

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        while (rs.next()) {

            Chambre c = new Chambre();
            c.setChambre_id(rs.getInt("chambre_id"));
            c.setNom_chambre(rs.getString("nom_chambre"));
            c.setDescription(rs.getString("description"));
            c.setHotel_id(rs.getInt("hotel_id"));
            c.setType_chambre(rs.getString("type_chambre"));
            c.setVue(rs.getString("vue"));
            c.setEtage(rs.getInt("etage"));
            c.setPrix(rs.getInt("prix"));
            c.setFk_chambre_hotel(rs.getInt("fk_chambre_hotel"));
        }
        return chambre;
    }


    public void deleteChambre(int id) throws SQLException{

        String sql = "delete  FROM chambre WHERE id = "+id;

        Statement ste = cnx.createStatement();

        ResultSet rs = ste.executeQuery(sql);

        System.out.println("chmabre DELETED!");
    }
    
       
 public void supprimerChambre(Chambre chambre) {
        try {
            String requete = "DELETE FROM Chambre WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, chambre.getChambre_id());
            pst.executeUpdate();
            System.out.println("chambre supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}