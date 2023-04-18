package com.dio.inter.padroes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.inter.padroes.config.exception.InterException;
import com.dio.inter.padroes.model.Cliente;
import com.dio.inter.padroes.model.Endereco;
import com.dio.inter.padroes.repository.ClienteRepository;
import com.dio.inter.padroes.repository.EnderecoRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired 
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	
	@Override
	public Iterable<Cliente> byAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente byId(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new InterException("Cliente não foi encontrado!")) ;
	}

	@Override
	public void create(Cliente cliente) {
		preencherEntidade(cliente);
	}

	@Override
	public void update(Long id, Cliente cliente) {
		Cliente model = byId(id);
		cliente.setId(model.getId());
		cliente.setEndereco(bySaveEndereco(cliente.getEndereco().getCep()));
		clienteRepository.save(cliente);
	}

	@Override
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}
	
	private void preencherEntidade(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		cliente.setEndereco(bySaveEndereco(cep));
		clienteRepository.save(cliente);
	}
	
	private Endereco bySaveEndereco (String cep) {
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() ->{
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		
		return endereco;
	}
}
