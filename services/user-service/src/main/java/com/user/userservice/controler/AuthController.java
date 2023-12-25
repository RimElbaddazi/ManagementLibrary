package com.user.userservice.controler;


import com.user.userservice.DTO.UtilisateurRequestDTO;
import com.user.userservice.DTO.UtilisateurResponseDTO;
import com.user.userservice.model.Utilisateur;
import com.user.userservice.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {


    private final UtilisateurRepository utilisateurRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UtilisateurRequestDTO request) {
        Utilisateur user =
                utilisateurRepository.findByEmail(request.getEmail())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found"));
        if (!user.getMotDePasse().equals(request.getMotDePasse())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong Credentials");
        }

        // If password matches, build and return the user response DTO
        UtilisateurResponseDTO response = UtilisateurResponseDTO.builder()
                .email(user.getEmail())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .role(user.getRole())
                .reference(user.getReference())
                .id(user.getId())
                .build();

        return ResponseEntity.ok(response);

    }
}
