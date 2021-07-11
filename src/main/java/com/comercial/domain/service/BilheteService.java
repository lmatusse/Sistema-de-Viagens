package com.comercial.domain.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Bilhete;
import com.comercial.domain.repository.BilheteRepository;

@Service
public class BilheteService {

	@Autowired
	private BilheteRepository bilheteRepository;
	
	@Transactional
	public Bilhete salvar(Bilhete bilhete)
	{
		bilhete.setDataReserva(LocalDate.now());
		return bilheteRepository.save(bilhete);
	}
	
	public Optional<Bilhete> buscar(Long codigo)
	{
		return bilheteRepository.findById(codigo);
	}
	
	public List<Bilhete> listar()
	{
		return bilheteRepository.findAll();
	}
	
	@Transactional
	public void remove(Long codigo)
	{
		bilheteRepository.deleteById(codigo);
	}
}
