package com.comercial.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Bilhete;

@Repository
public interface BilheteRepository extends JpaRepository<Bilhete, Long>{

}
