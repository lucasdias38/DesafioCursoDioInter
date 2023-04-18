package com.dio.inter.padroes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.inter.padroes.model.Cliente;
import com.dio.inter.padroes.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<Iterable<Cliente>> buscaTodos(){
		return ResponseEntity.ok(clienteService.byAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscaPorId(@PathVariable Long id){
		return ResponseEntity.ok(clienteService.byId(id));
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
		clienteService.create(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
		clienteService.update(id, cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Cliente> deletar(@PathVariable Long id){
		clienteService.delete(id);
		return ResponseEntity.ok().build();
	}

}
