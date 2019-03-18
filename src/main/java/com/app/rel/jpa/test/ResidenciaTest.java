package com.app.rel.jpa.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.rel.jpa.domain.Residencia;
import com.app.rel.jpa.domain.Usuario;
import com.app.rel.jpa.domain.Vaga;
import com.app.rel.jpa.repository.ResidenciaRepository;
import com.app.rel.jpa.repository.VagaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ResidenciaTest {
	
	@Autowired
	private ResidenciaRepository residenciaRepository;
	
	@Autowired
	
	@Before
	public void setup() {
		
		Usuario antonio;
		Usuario rafael;
		Usuario joao;
		Usuario maria;
		
		Residencia rep1;
		Residencia rep2;
		
		antonio = new Usuario(1L, "Antonio");
		rafael = new Usuario(2L, "Rafael");
		joao = new Usuario(3L, "João");
		maria = new Usuario(4L, "Maria");
		
		rep1 = new Residencia(1L, "13990000", "SP", "Mogi Mirim", "Caiopo");
		rep2 = new Residencia(2L, "13980000", "SP", "São Paulo", "Julio Prestes");
		
		Vaga vaga1 = new Vaga(1L, new BigDecimal(200), antonio);
		Vaga vaga2 = new Vaga(2L, new BigDecimal(800), rafael);
		Vaga vaga3 = new Vaga(3L, new BigDecimal(1000),rep2, joao);
		Vaga vaga4 = new Vaga(4L, new BigDecimal(50),rep2, maria);
		
		
		
		List<Vaga> listVaga = new ArrayList<>();
		listVaga.add(vaga1);
		listVaga.add(vaga2);
		
		List<Vaga> listVaga2 = new ArrayList<>();
		listVaga2.add(vaga3);
		listVaga2.add(vaga4);
		
		rep1.setVagas(listVaga);
		rep2.setVagas(listVaga2);
		
		residenciaRepository.save(rep1);
		residenciaRepository.save(rep2);
		
//		vaga3.setResidencia(rep2);
//		vaga4.setResidencia(rep2);
//		
//		vagaRepository.save(vaga3);
//		vagaRepository.save(vaga4);
		
		
	}
	
	@Test
	public void testResidencia() {
		
		Residencia residencia = residenciaRepository.findById(2L).get();
		
		assertEquals("13980000", residencia.getCep());
	}
	
	@Test
	public void testVaga() {
		
		Residencia residencia = residenciaRepository.findById(2L).get();
		
		List<Vaga> listVaga = residencia.getVagas();
		
		assertEquals(new BigDecimal(1000), residencia.getVagas().get(0).getValor());
		
	}
}
