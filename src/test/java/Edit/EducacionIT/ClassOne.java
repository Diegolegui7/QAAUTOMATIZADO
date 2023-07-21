package Edit.EducacionIT;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager; // Importar la clase WebDriverManager

public class ClassOne {

    String url = "http://www.automationpractice.pl/index.php";
    WebDriver buscador;
    WebDriverWait wait;

    @BeforeSuite
    public void abrirNavegador() {
        // Configurar el controlador de Chrome con WebDriverManager
        WebDriverManager.chromedriver().setup();

        buscador = new ChromeDriver();
        buscador.get(url);
        buscador.manage().deleteAllCookies();
        wait = new WebDriverWait(buscador, 15); // Espera de 15 segundos
    }

    @Test
    public void buscarProducto() {
        WebElement Txt = buscador.findElement(By.className("login"));
        Txt.click();

        WebElement txtEmail = buscador.findElement(By.name("email_create"));
        txtEmail.sendKeys("diegonahuelll@hotmail.com");

        WebElement btnCreate = buscador.findElement(By.xpath("//button[@id='SubmitCreate']"));
        btnCreate.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));

        WebElement radTitle = buscador.findElement(By.id("id_gender1"));
        radTitle.click();

        WebElement txtFirstName = buscador.findElement(By.cssSelector("#customer_firstname"));
        txtFirstName.sendKeys("Camilo");

        WebElement txtLastName = buscador.findElement(By.name("customer_lastname"));
        txtLastName.sendKeys("Hernandez");

        WebElement txtPassword = buscador.findElement(By.cssSelector("#passwd"));
        txtPassword.sendKeys("1q2w3e4r5t");

        Select selDays = new Select(buscador.findElement(By.cssSelector("#days")));
        selDays.selectByVisibleText("18  ");

        Select selMonths = new Select(buscador.findElement(By.id("months")));
        selMonths.selectByValue("6");

        Select selYears = new Select(buscador.findElement(By.name("years")));
        selYears.selectByIndex(30);

        WebElement chkNews = buscador.findElement(By.xpath("//input[@id='newsletter']"));
        chkNews.click();

        // Cerrar el navegador después de terminar las pruebas
        buscador.quit();
    }
}
