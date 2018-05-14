package pacote;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovoUsuarioPage {
	
	private WebDriver driver;
	
	public NovoUsuarioPage (WebDriver driver){
		this.driver = driver;
	}
	
	public void cadastra(String nome, String email){
		WebElement lb_nome =  driver.findElement(By.name("usuario.nome"));
		WebElement lb_email = driver.findElement(By.name("usuario.email"));
		
		lb_nome.sendKeys(nome);
		lb_email.sendKeys(email);
		lb_nome.submit();		
	}
	public boolean validaNomeObrigatorio(){
		return driver.getPageSource().contains("Nome obrigatorio");
	}
	public boolean validaNomeEEmailObrigatorio(){
		return driver.getPageSource().contains("Nome obrigatorio") && 
				driver.getPageSource().contains("E-mail obrigatorio");
	}

}
