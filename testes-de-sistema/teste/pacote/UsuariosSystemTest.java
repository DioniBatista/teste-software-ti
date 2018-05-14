package pacote;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import junit.framework.AssertionFailedError;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {
	
	private WebDriver driver;
	private UsuariosPage usuarios;
	
	@Before
	public void iniciaDriver(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\UserForceOne\\Documents\\testes-de-sistema\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.usuarios = new UsuariosPage(driver);
		usuarios.visita();
	}
	@After
	public void encerraDriver(){
		this.driver.close();
	}

   @Test
	public void deveAdicionarUmUsuario() {		
		
	   usuarios.novo().cadastra("DIogo2", "firmino@gol.com.br");
	   assertTrue(usuarios.existeNaLista("DIogo2", "firmino@gol.com.br"));
	}
	
	@Test
	public void naoDeveAdicionarUsuarioSemNome(){
		NovoUsuarioPage form = usuarios.novo();
		form.cadastra("", "semnome@dominio.com.br");	
		assertTrue(form.validaNomeObrigatorio());
	}	
	
	@Test
	public void naoDeveAdicionarUsuarioSemNomeEEmail(){
		NovoUsuarioPage form = usuarios.novo();
		form.cadastra("","");
		assertTrue(form.validaNomeEEmailObrigatorio());		
	}
	/*@Test
	public void deveExcluir(){
		usuarios.novo().cadastra("Dioni","dioni.bs@email.com");
		assertTrue(usuarios.existeNaLista("Dioni", "dioni.bs@email.com"));
		usuarios.excluirUsuario();
		assertFalse(usuarios.existeNaLista("Dioni", "dioni.bs@email.com"));
	}*/
}
