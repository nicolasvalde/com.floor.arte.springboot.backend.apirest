package com.floor.arte.springboot.backend.apirest.controllers;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.floor.arte.springboot.backend.apirest.exception.StatusException;
import com.floor.arte.springboot.backend.apirest.model.Obra;
import com.floor.arte.springboot.backend.apirest.service.IObraService;

@RestController
@RequestMapping(path = "/arte")
public class ObraController {

	@Autowired
	private IObraService obraService;

	@GetMapping
	public List<Obra> getAll() {

		return ResponseEntity.status(200).body(obraService.findAll()).getBody();

	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Obra>> getById(@PathVariable int id) {

		return ResponseEntity.status(200).body(obraService.findById(id));

	}

	@PostMapping
	public ResponseEntity save(@RequestBody Obra obra) {

//		ModelMapper modelMapper = new ModelMapper();

//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

//		Obra obra = modelMapper.map(request, Obra.class);

//		modelMapper.validate();

		Obra temp = obraService.save(obra);

		try {

			if (temp.getId() != 0) {
				return ResponseEntity.status(201).body(temp);
			} else {
				throw new StatusException("Bad request. Please check the values", 400);
			}

		} catch (StatusException e) {

			return e.getResponseStatus();

		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Obra> update(@RequestBody Obra obra, @PathVariable int id) {

		Obra temp = obraService.update(obra, id);

		try {

			if (temp.getId() != 0) {
				return ResponseEntity.status(201).body(temp);
			} else {
				throw new StatusException("Bad request. Please check the values", 400);
			}

		} catch (StatusException e) {

			return e.getResponseStatus();

		}

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		obraService.delete(id);
	}

}
