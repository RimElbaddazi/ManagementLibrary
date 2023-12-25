package com.user.userservice.model;


import lombok.*;

import javax.persistence.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Utilisateur")

public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "reference", nullable = false)
    protected String reference;

    @Column(name = "nom", nullable = false)
    protected String nom;

    @Column(name = "prenom", nullable = false)
    protected String prenom;

    @Column(name = "email", nullable = false, unique = true)
    protected String email;

    @Column(name = "mot_de_passe")
    protected String motDePasse;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    protected Role role;

    public Utilisateur(String reference, String nom, String prenom, String email,String motDePasse, Role role) {
        this.reference = reference;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
    }
}
