package com.licao.spring.venda.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.licao.spring.Entidades.models.Venda;
import com.licao.spring.venda.repository.VendaRepository;
import com.licao.spring.venda.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Override
	public Iterable<Venda> listar() {
		return vendaRepository.findAll();
	}

	@Override
	public Optional<Venda> buscar(Integer id) {
		return vendaRepository.findById(id);
	}

	@Override
	public Venda persistir(Venda venda) {
		venda.calcularValorTotal();
		return vendaRepository.save(venda);
	}

	@Override
	public void deletar(Integer id) {
		vendaRepository.deleteById(id);
	}

	@Override
	public boolean existe(Integer id) {
		return vendaRepository.existsById(id);
	}
}
