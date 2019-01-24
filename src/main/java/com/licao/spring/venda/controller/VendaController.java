package com.licao.spring.venda.controller;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.licao.spring.Entidades.models.Item;
import com.licao.spring.Entidades.models.Produto;
import com.licao.spring.Entidades.models.Venda;
import com.licao.spring.venda.service.VendaService;

@Controller
@RequestMapping(path = "/venda")
public class VendaController {

	@Autowired
	private VendaService vendaService;
	
	private final String VENDA_PATH = "/venda/";
	
	@PostMapping
	public ResponseEntity<Venda> cadastrar(@RequestBody Venda venda){
		
		try {
			Venda vendaCadastrada = vendaService.persistir(venda);
			URI uri = URI.create(VENDA_PATH + vendaCadastrada.getId());
			
			return ResponseEntity.created(uri).body(vendaCadastrada);			
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Venda>> listar(){
		
		Iterable<Venda> vendas = vendaService.listar();
		
		return ResponseEntity.status(HttpStatus.OK).body(vendas);
		
	}
	
	
}
