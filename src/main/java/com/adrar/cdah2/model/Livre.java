package com.adrar.cdah2.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "livre")
public class Livre {

    /*---------------------------------------
                  Attributs
    ---------------------------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titre", nullable = false, length = 50)
    private String titre;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "date_publication", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datePublication;

    @Column(name = "genres", nullable = true, length = 50)
    private String genres;

    @Column(name = "auteur", nullable = true, length = 50)
    private String auteur;

    @ManyToOne
    @JoinColumn(name= "maison_edition_id")
    private MaisonEdition maisonEdition;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private User user;


    /*---------------------------------------
                  Constructeurs
    ---------------------------------------*/
    public Livre() {
    }

    public Livre(String titre, String description, Date datePublication) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
    }

    public Livre(String titre, String description,
                 Date datePublication, String genres,
                 String auteur, MaisonEdition maisonEdition) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.genres = genres;
        this.auteur = auteur;
        this.maisonEdition = maisonEdition;
    }

    /*---------------------------------------
                 Getters et Setters
    ---------------------------------------*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public MaisonEdition getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(MaisonEdition maisonEdition) {
        this.maisonEdition = maisonEdition;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    /*---------------------------------------
                  Méthodes
    ---------------------------------------*/

    @Override
    public String toString() {
        return "Livre{" +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                '}';
    }
}
