package com.adrar.cdah2.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "livre_genre",
            joinColumns = @JoinColumn(name = "livre_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @Column(name = "auteur", nullable = true, length = 50)
    private String auteur;

    @ManyToOne
    @JoinColumn(name= "maison_edition_id")
    private MaisonEdition maisonEdition;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    @Valid
    private User user;


    /*---------------------------------------
                  Constructeurs
    ---------------------------------------*/
    public Livre() {
        this.genres = new ArrayList<>();
    }

    public Livre(String titre, String description, Date datePublication) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.genres = new ArrayList<>();
    }

    public Livre(String titre, String description,
                 Date datePublication,
                 String auteur, MaisonEdition maisonEdition) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void addGenre(Genre genre){
        this.genres.add(genre);
    }

    public void removeGenre(Genre genre){
        this.genres.remove(genre);
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
