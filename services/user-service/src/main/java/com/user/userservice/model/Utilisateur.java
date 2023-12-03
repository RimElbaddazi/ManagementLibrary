package com.user.userservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Inheritance(strategy = InheritanceType.JOINED)

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "nom", nullable = false)
    protected String nom;

    @Column(name = "prenom")
    protected String prenom;

    @Column(name = "email", nullable = false, unique = true)
    protected String email;

    @Column(name = "mot_de_passe")
    protected String motDePasse;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    protected Role role;

    public Utilisateur(Long id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

}
