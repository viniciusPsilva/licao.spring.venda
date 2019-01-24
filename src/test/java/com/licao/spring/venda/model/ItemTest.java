package com.licao.spring.venda.model;

import java.math.BigDecimal;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.licao.spring.Entidades.models.Item;
import com.licao.spring.Entidades.models.Produto;

public class ItemTest {

	@Test
	public void calcularValorTotal() {
		//cenario 
		Produto produto1 = new Produto();
		produto1.setId(1);
		produto1.setName("Produto 1");
		produto1.setValor(new BigDecimal("200"));
		produto1.setDisponivel(true);
		produto1.setDescricao("Descricao produto 1");
		
		Item item1 = new Item();
		item1.setId(1);
		item1.setProduto(produto1);
		item1.setQuantidade(3);
		
		//Ação
		BigDecimal total = item1.calcularvalorTotal();
		
		//Asserção
		Assert.assertThat(total, CoreMatchers.is(new BigDecimal("600")));
	}
	
}
