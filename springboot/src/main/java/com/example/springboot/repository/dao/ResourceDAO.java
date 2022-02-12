package com.example.springboot.repository.dao;


import com.example.springboot.component.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceDAO extends JpaRepository<ResourceEntity, Long> {
}
