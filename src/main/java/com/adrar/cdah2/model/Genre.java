package com.adrar.cdah2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name= "name", nullable = false, unique = true, length = 50)
    @NotBlank(message = "Le nom du genre ne doit pas être vide")
    @Size(min = 3, max = 50, message = "Le nom du genre doit contenir entre 3 et 50 caractères")
    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*---------------------------------------
                  Méthodes
    ---------------------------------------*/
    @Override
    public String toString() {
        return "Genre{" +
                ", name='" + name + '\'' +
                '}';
    }
}
