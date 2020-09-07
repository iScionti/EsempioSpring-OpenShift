package com.academy.contatti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.contatti.model.Contatto;
import com.academy.contatti.repository.ContattiRepository;

@Service
public class ContattiServiceImpl implements ContattiService{
	@Autowired
	ContattiRepository contattiRepository;
	
	@Override
	public void saveContatto(Contatto c) {
		contattiRepository.save(c);
	}

	@Override
	public List<Contatto> getAll() {
		return contattiRepository.findAll();
	}

	@Override
	public Optional<Contatto> findById(Integer id) {
		return contattiRepository.findById(id);
	}

	@Override
	public void deleteContatto(Integer id) {
		contattiRepository.deleteById(id);
	}
}
