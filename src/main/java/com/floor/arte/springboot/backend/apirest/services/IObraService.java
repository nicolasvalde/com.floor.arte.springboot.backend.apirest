package com.floor.arte.springboot.backend.apirest.services;

import java.util.List;
import java.util.Optional;

import com.floor.arte.springboot.backend.apirest.models.Obra;

public interface IObraService {

	public List<Obra> findAll();
	
	public Optional<Obra> findById(Integer id);
	
	public Obra save(Obra obra);
	
	public Obra update(Obra obra, int id);
	
	public void delete(Integer id);
	
}
