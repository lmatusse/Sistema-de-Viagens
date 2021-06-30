package com.comercial.domain.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.domain.model.Aeronave;
import com.comercial.domain.repository.AeronavaRepository;

@Service
public class AeronaveService 
{
	@Autowired
	private AeronavaRepository aeronavaRepository;
	
	@Transactional
	public Aeronave salvar(Aeronave aeronave)
	{
		return aeronavaRepository.save(aeronave);
	}
	
	public Optional<Aeronave> buscar(Long codigo)
	{
		return aeronavaRepository.findById(codigo);
	}
	
	public List<Aeronave> listar()
	{
		return aeronavaRepository.findAll();
	}
	
	@Transactional
	public void remover(Long codigo)
	{
		aeronavaRepository.deleteById(codigo);
	}
}
