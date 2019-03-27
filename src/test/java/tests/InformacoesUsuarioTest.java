package tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.easetech.easytest.runner.DataDrivenTestRunner;

import suporte.web;



//usando o easytest
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "dados.csv")



public class InformacoesUsuarioTest {
	
	//Todo mundo pode usar este muted
	private WebDriver driver;
	
	
	//Execute isso antes de tudo
	@Before
	public void setup()
	{
		driver = web.createChrome();
	  	
	  	driver.findElement(By.linkText("Sign in")).click();
	  	
	  	WebElement formularioLogin = driver.findElement(By.id("signinbox"));


		formularioLogin.findElement(By.name("login")).sendKeys("julio0001");		
		formularioLogin.findElement(By.name("password")).sendKeys("123456");
		formularioLogin.findElement(By.linkText("SIGN IN")).click();

	}

	@Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario (@Param(name="tipo")String tipo, @Param (name="contato")String contato, @Param(name="mensagemesperada")String mensagemesperada)	{	

		WebElement me = driver.findElement(By.className("me"));
		String textoNoElementoMe = me.getText();
		System.out.println("O texto que esta no elemento me é " + textoNoElementoMe);
		assertEquals( "Hi, Julio", textoNoElementoMe);
		
		me.click();
		
		driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		driver.findElement(By.xpath("//button[@data-target='addmoredata']")).click();
		
		WebElement popupaddMoreData = driver.findElement(By.id("addmoredata"));
		WebElement campoType = popupaddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText(tipo);
		
		popupaddMoreData.findElement(By.name("contact")).sendKeys(contato);
		popupaddMoreData.findElement(By.linkText("SAVE")).click();
		
		WebElement msgsucesso = driver.findElement(By.id("toast-container"));
		String textoSucesso = msgsucesso.getText();
		System.out.println("\n O texto que esta no elemento é " + textoSucesso);
		assertEquals( mensagemesperada, textoSucesso);

	}
	
	//@Test
	
	public void removerAddData() {

			WebElement me = driver.findElement(By.className("me"));
			me.click();
			
			driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
			
			driver.findElement(By.xpath("//span[text()='+551199996666']/following-sibling::a")).click();
			
			driver.switchTo().alert().accept();
			
			WebElement msgsucesso = driver.findElement(By.id("toast-container"));
			String textoSucesso = msgsucesso.getText();
			System.out.println("\n O texto que esta no elemento é " + textoSucesso);
			assertEquals( "Rest in peace, dear phone!", textoSucesso);
			
			
			WebDriverWait aguardarToastSumir = new WebDriverWait(driver, 10);
			aguardarToastSumir.until(ExpectedConditions.stalenessOf(msgsucesso));
			
			driver.findElement(By.linkText("Logout")).click();
			
			
	}

	//Execute isso após cada teste
	@After
	public void tearDown()
	{
		driver.quit();
	}
}
