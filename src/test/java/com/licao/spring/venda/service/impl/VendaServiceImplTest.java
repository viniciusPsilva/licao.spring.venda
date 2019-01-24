package com.licao.spring.venda.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.licao.spring.Entidades.models.Item;
import com.licao.spring.Entidades.models.Produto;
import com.licao.spring.Entidades.models.Venda;

public class VendaServiceImplTest {

	@Test
	public void calcularValorTotal() {
		//cenario de teste
		Produto produto1 = new Produto();
		produto1.setId(1);
		produto1.setName("Produto 1");
		produto1.setValor(new BigDecimal("200"));
		produto1.setDisponivel(true);
		produto1.setDescricao("Descricao produto 1");
		
		Produto produto2 = new Produto();
		produto2.setId(2);
		produto2.setName("Produto 2");
		produto2.setValor(new BigDecimal("200"));
		produto2.setDisponivel(true);
		produto2.setDescricao("Descricao produto 2");
		
		Item item1 = new Item();
		item1.setId(1);
		item1.setProduto(produto1);
		item1.setQuantidade(2);
		
		Item item2 = new Item();
		item2.setId(2);
		item2.setProduto(produto2);
		item2.setQuantidade(2);
		
		
		List<Item> itens = new ArrayList<Item>();
		itens.add(item1);
		itens.add(item2);
		
		
		Venda venda = new Venda();
		venda.setId(1);
		venda.setItens(itens);
		
		//Ação 
		venda.calcularValorTotal();
		
		//Asserção 
		Assert.assertThat(venda.getValor(), CoreMatchers.is(new BigDecimal("800")));
			
	}
	
}
