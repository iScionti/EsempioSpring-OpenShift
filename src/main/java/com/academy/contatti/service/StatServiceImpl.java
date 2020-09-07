package com.academy.contatti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.contatti.model.Contatto;
import com.academy.contatti.repository.StatRepository;

@Service
public class StatServiceImpl implements StatService{
	@Autowired
	StatRepository statRepository;

	@Override
	public List<Contatto> findByUsername(String username) {
		return statRepository.findByUsername(username);
	}

	@Override
	public Long conteggioContatti() {
		return statRepository.conteggioContatti();
	}

}
