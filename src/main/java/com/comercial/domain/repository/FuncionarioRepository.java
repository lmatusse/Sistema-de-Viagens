package com.comercial.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercial.domain.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>
{

}
