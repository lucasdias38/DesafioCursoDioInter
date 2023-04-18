package com.dio.inter.padroes.service;

import com.dio.inter.padroes.model.Cliente;

public interface ClienteService {

	Iterable<Cliente> byAll();

	Cliente byId (Long id);
	
	void create (Cliente cliente);
	
	void update (Long id, Cliente cliente);
	
	void delete (Long id);
	
}
