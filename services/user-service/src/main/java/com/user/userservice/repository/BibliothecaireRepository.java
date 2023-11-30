package com.user.userservice.repository;

import com.user.userservice.model.Bibliothecaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BibliothecaireRepository extends JpaRepository<Bibliothecaire,Long> {

}
