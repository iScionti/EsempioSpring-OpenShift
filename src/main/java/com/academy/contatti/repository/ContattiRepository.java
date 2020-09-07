package com.academy.contatti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academy.contatti.model.Contatto;

public interface ContattiRepository extends JpaRepository<Contatto, Integer> {

}
