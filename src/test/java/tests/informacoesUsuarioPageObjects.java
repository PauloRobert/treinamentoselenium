package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import suporte.web;

public class informacoesUsuarioPageObjects {

	//variavel
	private WebDriver driver;

	@Before
	public void setup(){
		//Recebe a variavel do pacote Web
		driver = web.createChrome();

	}

	@Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario(){

	}

	@After	
	public void tearDown(){

		driver.quit();
	}

}
