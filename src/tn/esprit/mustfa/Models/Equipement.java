/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.mustfa.Models;



public class Equipement {
int equipemenst_id;
String equipements_cuisine;
String television;
String options_restauration;
String piscine;
String parking;
int hotel_id; 

    public Equipement() {
    }

    public Equipement(int equipemenst_id, String equipements_cuisine, String television, String options_restauration, String piscine, String parking, int hotel_id) {
        this.equipemenst_id = equipemenst_id;
        this.equipements_cuisine = equipements_cuisine;
        this.television = television;
        this.options_restauration = options_restauration;
        this.piscine = piscine;
        this.parking = parking;
        this.hotel_id = hotel_id;
    }


    public Equipement( String equipements_cuisine, String television, String options_restauration, String piscine, String parking, int hotel_id) {
        this.equipements_cuisine = equipements_cuisine;
        this.television = television;
        this.options_restauration = options_restauration;
        this.piscine = piscine;
        this.parking = parking;
        this.hotel_id = hotel_id;
    }

    public int getEquipemenst_id() {
        return equipemenst_id;
    }

    public void setEquipemenst_id(int equipemenst_id) {
        this.equipemenst_id = equipemenst_id;
    }

    public String getEquipements_cuisine() {
        return equipements_cuisine;
    }

    public void setEquipements_cuisine(String equipements_cuisine) {
        this.equipements_cuisine = equipements_cuisine;
    }

    public String getTelevision() {
        return television;
    }

    public void setTelevision(String television) {
        this.television = television;
    }

    public String getOptions_restauration() {
        return options_restauration;
    }

    public void setOptions_restauration(String options_restauration) {
        this.options_restauration = options_restauration;
    }

    public String getPiscine() {
        return piscine;
    }

    public void setPiscine(String piscine) {
        this.piscine = piscine;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        return "Equipement{" + "equipemenst_id=" + equipemenst_id + ", equipements_cuisine=" + equipements_cuisine + ", television=" + television + ", options_restauration=" + options_restauration + ", piscine=" + piscine + ", parking=" + parking + ", hotel_id=" + hotel_id + '}';
    }



}
