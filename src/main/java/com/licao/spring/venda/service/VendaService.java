package com.licao.spring.venda.service;

import java.util.Optional;

import com.licao.spring.Entidades.models.Venda;

public interface VendaService {
	
	public Iterable<Venda> listar();
	
	public Optional<Venda> buscar(Integer id);
	
	public Venda persistir(Venda venda);
	
	public void deletar(Integer id);
	
	public boolean existe(Integer id);

}
