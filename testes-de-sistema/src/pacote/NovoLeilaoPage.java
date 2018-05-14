package pacote;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovoLeilaoPage {
	
	private WebDriver driver;
	public NovoLeilaoPage(WebDriver driver){
		this.driver = driver;
	}
	public void preenche(String nome, double valor, String usuario, boolean usado){
		
		WebElement lbNome = driver.findElement(By.name("leilao.nome"));
		WebElement lbValor = driver.findElement(By.name("leilao.valorInicial"));
		
		lbNome.sendKeys(nome); 	
		lbValor.sendKeys(String.valueOf(valor));
		
		WebElement combo = driver.findElement(By.name("leilao.usuario.id"));
		Select cbUsuario = new Select(combo);
		cbUsuario.selectByVisibleText(usuario);
		
		if(usado){
			driver.findElement(By.name("leilao.usado")).click();
		}
		lbNome.submit();
	}
	
	public boolean validaNomeObrigatorio(){
		return driver.getPageSource().contains("Nome obrigatorio"); 
	}
	public boolean validaValorInicialObrigatorio(){
		return driver.getPageSource().contains("Valor inicial deve ser maior que zero");
	}
}
