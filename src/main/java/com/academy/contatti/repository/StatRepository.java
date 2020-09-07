package com.academy.contatti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.academy.contatti.model.Contatto;

//custom query spring boot
public interface StatRepository extends JpaRepository<Contatto, Integer> {
	@Query(value = "select * from contatto where username like ?1", nativeQuery = true) //?1 posizione della sql placeholder
	List<Contatto> findByUsername(String username); // ricerca per username nella tabella

	@Query(value = "Select count(*) from contatto", nativeQuery = true)
	Long conteggioContatti();

}
