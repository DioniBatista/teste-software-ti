package pacote;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsuariosPage {
	private WebDriver driver;
	
	public UsuariosPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void visita(){
		driver.get("http://localhost:8080/usuarios");
	}
	public NovoUsuarioPage novo(){
		driver.findElement(By.linkText("Novo Usuário")).click();
		return new NovoUsuarioPage(driver);
	}
	public boolean existeNaLista(String nome, String email){
		return driver.getPageSource().contains(nome) && driver.getPageSource().contains(email);
	}
	public void excluirUsuario(){
		int posicao =1;
		driver.findElements(By.tagName("button")).get(posicao -1).click();
		Alert alerta = driver.switchTo().alert();
		alerta.accept();
	}

}
