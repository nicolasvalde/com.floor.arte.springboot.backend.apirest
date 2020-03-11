package com.floor.arte.springboot.backend.apirest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "video_uri")
	private String videoUri;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVideoUri() {
		return videoUri;
	}

	public void setVideoUri(String videoUri) {
		this.videoUri = videoUri;
	}

}
