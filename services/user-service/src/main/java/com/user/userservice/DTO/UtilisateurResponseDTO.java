package com.user.userservice.DTO;


import com.user.userservice.model.Role;
import lombok.*;

@Getter@Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class UtilisateurResponseDTO {

    private Long id;
    private String reference;
    private String nom;
    private String prenom;
    private String email;
    private Role role;
    //protected String motDePasse;

}
