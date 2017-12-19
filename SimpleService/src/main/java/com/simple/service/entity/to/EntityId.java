package com.simple.service.entity.to;

import com.simple.service.entity.SimpleEntity;

public class EntityId {

	private Long id;

	public EntityId(SimpleEntity simple) {
		this.id = simple.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
