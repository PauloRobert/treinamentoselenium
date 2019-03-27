package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	private WebDriver driver;
	
	//construtor recebendo a instância do navegador WebDriver
	public loginPage(WebDriver driver){
		this.driver = driver;
		
	}

	//Criando o método de testes
	//O método de retorno precisa retornar qual a p´roxima pagina após esta ação
	public LoginFormPage clickSignIn(){
		
	  	driver.findElement(By.linkText("Sign in")).click();
	  	return new LoginFormPage(driver);
	}
}
