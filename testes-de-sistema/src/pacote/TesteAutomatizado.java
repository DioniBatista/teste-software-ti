package pacote;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {

    public static void main(String[] args) {
    	//instala o driver do chrome
    	System.setProperty("webdrive.chrome.driver","workspace/testes-de-sistema/chromedrive");
       
    	// abre firefox
        WebDriver driver = new ChromeDriver();

        // acessa o site do google
        driver.get("http://www.bing.com/");

        // digita no campo com nome "q" do google
        WebElement campoDeTexto = driver.findElement(By.name("q"));
        campoDeTexto.sendKeys("Caelum");

        // submete o form
        campoDeTexto.submit();

    }
}