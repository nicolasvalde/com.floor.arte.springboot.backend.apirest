package com.floor.arte.springboot.backend.apirest.service;

import java.util.List;
import java.util.Optional;

import com.floor.arte.springboot.backend.apirest.model.Obra;

public interface IObraService {

	public List<Obra> findAll();
	
	public Optional<Obra> findById(Integer id);
	
	public Obra save(Obra obra);
	
	public Obra update(Obra obra, int id);
	
	public void delete(Integer id);
	
}
