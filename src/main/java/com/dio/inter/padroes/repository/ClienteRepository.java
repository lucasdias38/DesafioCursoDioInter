package com.dio.inter.padroes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dio.inter.padroes.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
