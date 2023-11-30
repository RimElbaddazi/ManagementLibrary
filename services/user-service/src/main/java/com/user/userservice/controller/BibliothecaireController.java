package com.user.userservice.controller;

import com.user.userservice.model.Bibliothecaire;
import com.user.userservice.repository.BibliothecaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BibliothecaireController {

    private  BibliothecaireRepository bibliothecaireRepository;

    @Autowired
    public BibliothecaireController(BibliothecaireRepository bibliothecaireRepository) {
        this.bibliothecaireRepository = bibliothecaireRepository;
    }

    @GetMapping("/users/{id}")
    public Bibliothecaire getBibliothecaire(@PathVariable  Long id ) {
        return bibliothecaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bibliothecaire avec id " + id +" est introuvable"));
    }

    @GetMapping("/users")
    public List<Bibliothecaire> getBibliothecaires() {
        return bibliothecaireRepository.findAll();
    }

}
