package com.adrar.cdah2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "maison_edition")
public class MaisonEdition {
    /*---------------------------------------
                  Attributs
    ---------------------------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "libele", nullable = false, length = 50, unique = true)
    @NotBlank(message = "Le libele de la maison d'édition ne doit pas être vide")
    @Size(min = 3, max = 50, message = "Le libele de la maison d'édition doit contenir entre 3 et 50 caractères")
    private String libele;

    @Column(name = "description", length = 255)
    @NotNull(message = "La description de la maison d'édition ne doit pas être null")
    @Size(min = 5, max = 255, message = "La description de la maison d'édition doit contenir entre 5 et 255 caractères")
    private String description;

    /*---------------------------------------
                  constructeurs
    ---------------------------------------*/
    public MaisonEdition() {}

    public MaisonEdition(String libele, String description) {
        this.libele = libele;
        this.description = description;
    }

    /*---------------------------------------
                  Attributs
    ---------------------------------------*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
