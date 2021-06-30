package com.comercial.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.CompanhiaAerea;

@Repository
public interface CompanhiaAereaRepository extends JpaRepository<CompanhiaAerea, Long>{

}
