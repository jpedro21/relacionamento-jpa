package com.app.rel.jpa.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.rel.jpa.domain.Residencia;
import com.app.rel.jpa.domain.Usuario;
import com.app.rel.jpa.domain.Vaga;
import com.app.rel.jpa.repository.VagaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VagaTest {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	@Before
	public void setup() {
		
		Usuario antonio;
		Usuario rafael;
		Residencia rep1;
		Residencia rep2;
		
		antonio = new Usuario(1L, "Antonio");
		rafael = new Usuario(2L, "Rafael");
		
		rep1 = new Residencia(1L, "13990000", "SP", "Mogi Mirim", "Caiopo");
		rep2 = new Residencia(2L, "13980000", "SP", "São Paulo", "Julio Prestes");

		Vaga vaga1 = new Vaga(1L, new BigDecimal(200), rep1, antonio);
		Vaga vaga2 = new Vaga(2L, new BigDecimal(800), rep2, rafael);
		
		vagaRepository.save(vaga1);
		vagaRepository.save(vaga2);
		
		vagaRepository.findAll().forEach(v -> {
			System.out.println(v);
		});
	}
	
	@Test
	public void testePersistenciaUsuario() {
		
		Vaga vaga = vagaRepository.findById(2L).get();
		
		assertEquals("Rafael", vaga.getUsuario().getNome());
	}
	
	@Test
	public void testePersistenciaResidencia() {
		
		Vaga vaga = vagaRepository.findById(2L).get();
		
		assertEquals("13980000", vaga.getResidencia().getCep());
	}
	
	@Test
	public void testePersistenciaVaga() {
		
		Vaga vaga = vagaRepository.findById(1L).get();
		
		assertEquals(new BigDecimal(200), vaga.getValor());
	}
	
	@Test
	public void alteraUsuarioAtravesVaga() {
		
		Vaga vaga = vagaRepository.findById(1L).get();
		vaga.getUsuario().setNome("João");
		vagaRepository.save(vaga);
		vaga = vagaRepository.findById(1L).get();
		
		assertEquals("João", vaga.getUsuario().getNome());
	}
	
}
