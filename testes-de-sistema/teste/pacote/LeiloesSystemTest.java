package pacote;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeiloesSystemTest {
	private WebDriver driver;
	private LeiloesPage leiloes;
	
	@Before
	public void inicia(){
		//this.driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\UserForceOne\\Documents\\testes-de-sistema\\chromedriver.exe");
		this.driver = new ChromeDriver();
		leiloes = new LeiloesPage(driver);
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Jhon Costa", "jhon@costa.com");
	}
	@After
	public void encerra(){
		this.driver.close();
	}
	
	@Test
	public void deveCadastraLeilao(){
		leiloes.visita();
		leiloes.novo().preenche("Bicicleta", 300.0, "Dioni", true);
		
		assertTrue(leiloes.existe("Bicicleta", 300.0, "Dioni", true));
	}
	
	@Test
	public void naoDeveCadastrarLeilaoSemNome(){
		leiloes.visita();
		NovoLeilaoPage novo = leiloes.novo();//necessario criar para quando validar 
		                                      //no asssert nao cria um novo objeto
		novo.preenche("", 250.0, "Jhon Costa", false);
		
		assertTrue(novo.validaNomeObrigatorio());
	}
	@Test
	public void naoDeveCadastrarLeilaoSemValorInical(){
		leiloes.visita();
		NovoLeilaoPage novo = leiloes.novo();//necessario criar para quando validar 
        									//no asssert nao cria um novo objeto
		novo.preenche("Moto", 0.0, "Jhon Costa", false);
		
		assertTrue(novo.validaValorInicialObrigatorio());
	}
	
	
	

}
