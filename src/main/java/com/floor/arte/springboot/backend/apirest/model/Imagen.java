package com.floor.arte.springboot.backend.apirest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "imagenes")
public class Imagen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "imagen_uri")
	private String imagenUri;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImagenUri() {
		return imagenUri;
	}

	public void setImagenUri(String imagenUri) {
		this.imagenUri = imagenUri;
	}

}
