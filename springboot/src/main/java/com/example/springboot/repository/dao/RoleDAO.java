package com.example.springboot.repository.dao;

import com.example.springboot.component.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<RoleEntity, Long> {
}
