package com.floor.arte.springboot.backend.apirest.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.floor.arte.springboot.backend.apirest.models.Obra;

public interface ObraRepository extends JpaRepository<Obra, Integer> {

}
