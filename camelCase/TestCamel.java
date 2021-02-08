package camelCase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pilha.PilhaVaziaException;

public class TestCamel {
	private CamelCase camel;
	private List<String> compare ;
	
	@Before
	public void initCamelCase() {
		camel = new CamelCase();
		compare = new ArrayList<String>();
	}
	//nome - “nome” 
	@Test
	public void stillLowerCase() {
		List<String> output = camel.converterCamelCase("nome");
		compare.add("nome");
		assertTrue(output.equals(compare));
	}
	//Nome - “nome” 
	@Test
	public void firstUpperToLowerCase() {
		List<String> output = camel.converterCamelCase("Nome");
		compare.add("nome");
		assertTrue(output.equals(compare));
	}
	//nomeComposto - “nome”, “composto” 
	@Test
	public void compoundName() {
		List<String> output = camel.converterCamelCase("nomeComposto");
		compare.add("nome");
		compare.add("composto");
		assertTrue(output.equals(compare));
	}
	//NomeComposto - “nome”, “composto”
	@Test
	public void firstCompoundName() {
		List<String> output = camel.converterCamelCase("NomeComposto");
		compare.add("nome");
		compare.add("composto");
		assertTrue(output.equals(compare));
	}
	//CPF - “CPF” 
	@Test
	public void allUpperCase() {
		List<String> output = camel.converterCamelCase("CPF");
		compare.add("CPF");
		assertTrue(output.equals(compare));
	}
	//numeroCPF - “numero”, “CPF” 
	@Test
	public void allUpperCompoundLowerCase() {
		List<String> output = camel.converterCamelCase("numeroCPF");
		compare.add("numero");
		compare.add("CPF");
		assertTrue(output.equals(compare));
	}
	//numeroCPFContribuinte - “numero”, “CPF”, “contribuinte” 
	@Test
	public void threeCompound() {
		List<String> output = camel.converterCamelCase("numeroCPFContribuinte");
		compare.add("numero");
		compare.add("CPF");
		compare.add("contribuinte");
		assertTrue(output.equals(compare));
	}
	//recupera10Primeiros - “recupera”, “10”, “primeiros” 
	@Test
	public void threeNumberCompound() {
		List<String> output = camel.converterCamelCase("recupera10Primeiros");
		compare.add("recupera");
		compare.add("10");
		compare.add("primeiros");
		assertTrue(output.equals(compare));
	}
	//10Primeiros - Inválido → não deve começar com números 
	@Test(expected=NumberStartCamelCaseException.class)
	public void StartWithNumber() {
		List<String> output = camel.converterCamelCase("10Primeiros");

	}
	//nome#Composto - Inválido → caracteres especiais não são permitidos, somente letras e números
	@Test(expected=SpecialCharacterCamelCaseException.class)
	public void SpecialCharacter() {
		List<String> output = camel.converterCamelCase("nome#Composto");

	}

}
