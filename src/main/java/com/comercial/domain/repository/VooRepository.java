package com.comercial.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Voo;

@Repository
public interface VooRepository extends JpaRepository<Voo, Long>{

}
