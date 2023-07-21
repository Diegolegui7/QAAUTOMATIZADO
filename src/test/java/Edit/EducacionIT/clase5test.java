package Edit.EducacionIT;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class clase5test {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(description="CP01 - Ir a Contactanos",priority=10)
	public void irAContactanos() throws InterruptedException {
		// Hacer clic en Contact us
		WebElement lnkContact = driver.findElement(By.linkText("Contact us"));
		lnkContact.click();
		
		Thread.sleep(1000);
		
		
		// Completar el formulario de contacto
		Select listSubject = new Select(driver.findElement(By.cssSelector("#id_contact")));
		listSubject.selectByVisibleText("Webmaster");
		
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys("correo01@gmail.com");
		
		WebElement txtOrder = driver.findElement(By.xpath("//input[@id='id_order']"));
		txtOrder.sendKeys("123-ABC");
		
		WebElement filAdjunto = driver.findElement(By.name("fileUpload"));
		filAdjunto.sendKeys("C:\\addIntegerData.txt");
		
		WebElement txtMessage = driver.findElement(By.tagName("textarea"));
		txtMessage.sendKeys("Mensaje de Contacto del Cliente");
		
		// Hacer clic en Send
		WebElement btnSend = driver.findElement(By.xpath("//button[@id='submitMessage']"));
		btnSend.click();
	}
	
	@Test(description="CP02 - Buscar Palabra",priority=1)
	public void buscarPalabra() throws InterruptedException {
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}
	

}
