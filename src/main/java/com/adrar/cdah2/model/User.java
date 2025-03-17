package com.adrar.cdah2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="firstname", nullable = false)
    @NotBlank(message = "le prénom doit être renseigné")
    @Size(min = 2, message = "Le prenom doit posséder au moins 2 caractères")
    private String firstname;

    @Column(name="lastname", nullable = false)
    @NotBlank(message = "le nom doit être renseigné")
    @Size(min = 2, message = "Le Nom doit posséder au moins 2 caractères")
    private  String lastname;

    @Column(name= "email", nullable = false, unique = true)
    @NotBlank(message = "le mail doit être renseigné")
    @Email(message = "le nom doit être un email valide")
    private String email;

    @Column(name="password", nullable = false)
    @NotBlank(message = "le mot de passe doit être renseigné")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@!])(?=\\S+$).{8,20}$",
            message = "le mot de passe doit contenir au moins un chiffre, " +
                    "une lettre, un caractère spécial pas d'espace et minimum 8 caractères")
    private String password;

    public User() {}

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
