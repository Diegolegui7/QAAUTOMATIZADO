package Edit.EducacionIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager; // Importar la clase WebDriverManager

import com.github.javafaker.Faker;

public class nacional {

    String url = "https://nacional.uy/es";
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
        WebElement cerrarInicio = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sc-ePDLzJ.ibjpOP div.sc-dPZUQH.kCFNSR.modal-container div.container div.row.justify-content-center div.col-12.col-lg-8 div.sc-iXzfSG.dsUViy button._7g-button.button_button__7IU29.sc-ikkxIA.cnUzlD.sc-eBHhsj.ffMDTG.modal__close-btn:nth-child(1) span:nth-child(1) > i.button__icon.material-icons")));
        cerrarInicio.click();

        WebElement crearCuenta = buscador.findElement(By.cssSelector(".sc-dAbbOL.ftgauK.sc-fUnMCh.fvnFLr"));
        crearCuenta.click();

        WebElement inicio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[contains(text(),'¡Crea una cuenta y Nacionalizate!')]")));
        inicio.click();

        Faker faker = new Faker();
        String nombre = faker.name().firstName();
        String mail = faker.internet().emailAddress();

        WebElement usuarioNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));
        usuarioNombre.sendKeys(nombre);

        WebElement usuarioApellido = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name")));
        usuarioApellido.sendKeys("leguizamon");

        WebElement usuarioMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        usuarioMail.sendKeys(mail);
    }
}



