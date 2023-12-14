package com.example.gestionchambre.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Chambre {
    @Id
    @GeneratedValue
    private int idChambre;
    private int numeroChambre;
    private String  Description;
    private int  nbrLits;


    public Chambre() {
    }

    public int getIdChambre() {
        return idChambre;
    }

    public int getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getNbrLits() {
        return nbrLits;
    }

    public void setNbrLits(int nbrLits) {
        this.nbrLits = nbrLits;
    }

    public Chambre(int numeroChambre, String description, int nbrLits) {
        this.numeroChambre = numeroChambre;
        Description = description;
        this.nbrLits = nbrLits;
    }
}
