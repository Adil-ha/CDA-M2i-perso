package org.example.book;

public class Editeur {

    private int cpt;
    private int id;

    private String nomEditeur;

    {
        cpt++;
    }

    public Editeur(String nomEditeur) {
        this.id = cpt++;
        this.nomEditeur = nomEditeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEditeur() {
        return nomEditeur;
    }

    public void setNomEditeur(String nomEditeur) {
        this.nomEditeur = nomEditeur;
    }

    @Override
    public String toString() {
        return "Editeur{" +
                "id=" + id +
                ", nomEditeur='" + nomEditeur + '\'' +
                '}';
    }
}
