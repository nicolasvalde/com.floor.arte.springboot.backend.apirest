package com.floor.arte.springboot.backend.apirest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.floor.arte.springboot.backend.apirest.model.Obra;
import com.floor.arte.springboot.backend.apirest.repository.ObraRepository;
import com.floor.arte.springboot.backend.apirest.service.IObraService;

@Service
public class ObraServiceImpl implements IObraService {

	@Autowired
	private ObraRepository obraRepository;

	@Override
	public List<Obra> findAll() {
		// TODO Auto-generated method stub
		return (List<Obra>) obraRepository.findAll();
	}

	@Override
	public Optional<Obra> findById(Integer id) {
		// TODO Auto-generated method stub
		return obraRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		obraRepository.deleteById(id);
	}

	@Override
	public Obra save(Obra obra) {
		// TODO Auto-generated method stub
		
		try {
			obraRepository.save(obra);
		} catch (Exception e) {
			System.out.println("Bad Request");
		}
		
		return obra;
		
//		return obraRepository.save(obra);
	}
	
	@Override
	public Obra update(Obra obra, int id) {
		
		Optional<Obra> obraOptional = obraRepository.findById(id);
		
		Obra obraTemp = new Obra();
		
		try {
			
			obraTemp = obraOptional.get();
			
			obraTemp.setCategoria(obra.getCategoria());
			obraTemp.setDescripcion(obra.getDescripcion());
			obraTemp.setImagenes(obra.getImagenes());
			obraTemp.setPortada(obra.getPortada());
			obraTemp.setPrecio(obra.getPrecio());
			obraTemp.setTitulo(obra.getTitulo());
			obraTemp.setVendido(obra.getVendido());
			obraTemp.setVideos(obra.getVideos());
			
			obraRepository.saveAndFlush(obraTemp);
			obra.setId(obraTemp.getId());			
			
		} catch (Exception e) {
			
			System.out.println("Bad Request");
			obra.setId(0);
			
		}
		
		return obra;
		
	}

}
