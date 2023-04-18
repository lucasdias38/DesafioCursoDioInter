package com.dio.inter.padroes.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Endereco {

	@Id
	private String cep;
	private String logradouro;
	private String complemteno;
	private String bairro;
	private String localidade;
	private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;
	
}
