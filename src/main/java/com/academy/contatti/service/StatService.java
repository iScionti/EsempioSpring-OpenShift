package com.academy.contatti.service;

import java.util.List;


import com.academy.contatti.model.Contatto;


public interface StatService {
	public List<Contatto> findByUsername(String username);
	Long conteggioContatti();
}
