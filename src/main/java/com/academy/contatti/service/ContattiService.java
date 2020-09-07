package com.academy.contatti.service;

import java.util.List;
import java.util.Optional;

import com.academy.contatti.model.Contatto;

public interface ContattiService {
	public void saveContatto(Contatto c);
	public List<Contatto> getAll();
	public Optional<Contatto>findById(Integer id);
	public void deleteContatto(Integer id);
}
