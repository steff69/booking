/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.mustfa.Models;


public class Chambre {
    
     private int chambre_id;
    private String nom_chambre;
    private String description;
    private int hotel_id;
    private String type_chambre;
    private String vue;
    private int etage;
    private int prix;
    private int fk_chambre_hotel;

    public Chambre() {
    }

    public Chambre(int chambre_id, String nom_chambre, String description, int hotel_id, String type_chambre, String vue, int etage, int prix, int fk_chambre_hotel) {
        this.chambre_id = chambre_id;
        this.nom_chambre = nom_chambre;
        this.description = description;
        this.hotel_id = hotel_id;
        this.type_chambre = type_chambre;
        this.vue = vue;
        this.etage = etage;
        this.prix = prix;
        this.fk_chambre_hotel = fk_chambre_hotel;
    }
    

        public Chambre(String nom_chambre, String description, int hotel_id, String type_chambre, String vue, int etage, int prix, int fk_chambre_hotel) {
         this.nom_chambre = nom_chambre;
        this.description = description;
        this.hotel_id = hotel_id;
        this.type_chambre = type_chambre;
        this.vue = vue;
        this.etage = etage;
        this.prix = prix;
        this.fk_chambre_hotel = fk_chambre_hotel;
    }

    public int getChambre_id() {
        return chambre_id;
    }

    public void setChambre_id(int chambre_id) {
        this.chambre_id = chambre_id;
    }

    public String getNom_chambre() {
        return nom_chambre;
    }

    public void setNom_chambre(String nom_chambre) {
        this.nom_chambre = nom_chambre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getType_chambre() {
        return type_chambre;
    }

    public void setType_chambre(String type_chambre) {
        this.type_chambre = type_chambre;
    }

    public String getVue() {
        return vue;
    }

    public void setVue(String vue) {
        this.vue = vue;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getFk_chambre_hotel() {
        return fk_chambre_hotel;
    }

    public void setFk_chambre_hotel(int fk_chambre_hotel) {
        this.fk_chambre_hotel = fk_chambre_hotel;
    }

    @Override
    public String toString() {
        return "Chambre{" + "chambre_id=" + chambre_id + ", nom_chambre=" + nom_chambre + ", description=" + description + ", hotel_id=" + hotel_id + ", type_chambre=" + type_chambre + ", vue=" + vue + ", etage=" + etage + ", prix=" + prix + ", fk_chambre_hotel=" + fk_chambre_hotel + '}';
    }
    


        
        
    
    
}
