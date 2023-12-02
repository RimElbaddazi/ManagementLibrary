package com.user.userservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Bibliothecaire")

public class Bibliothecaire extends Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emplacement")
    private String emplacement;

    public Bibliothecaire(Long id, String nom, String prenom, String email, String emplacement) {
        super(id, nom, prenom, email);
        this.emplacement = emplacement;
    }

    public Bibliothecaire(Long id, String nom, String prenom, String email) {
        super(id, nom, prenom, email);

        
    }
}
