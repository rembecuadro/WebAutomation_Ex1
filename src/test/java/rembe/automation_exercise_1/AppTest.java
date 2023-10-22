package rembe.automation_exercise_1;

import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest {

    WebDriver driver = null;

    @Test
    public void testWiki() {
        //        String driverPath = "D:\\Cursos\\Globant\\Quality Control + Automation\\04. Test Automation Frameworks\\00. Web Automation\\Automation_Exercise_1\\drivers\\chromedriver";
        //        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new EdgeDriver();

        // Inicio de navegación en la pagina a automatizar
        driver.navigate().to("https://www.wikipedia.org");

        // Se requiere encontrar el cajetín de busqueda, para escribir el texto solicitado
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        driver.manage().window().maximize(); // Para que la pagina quede en tamaño completo
        // Se envia el texto de lapalabra a buscar, en este ejemplo usamos Microsoft, pero puede ser cualquier texto
        searchInput.sendKeys("Selenium");

        // Se requiere encontrar el botón para iniciar la busqueda
        WebElement searchBtn = driver.findElement(By.cssSelector("button"));
        searchBtn.click();
        // Para encontrar el titulo de la página
        String pageTitle = driver.getTitle();
        // Se verifica el titulo con un assert. (Se debe testear el softAssert aunque ese es de TestNG)
        Assert.assertEquals("Your web page title matches", "Selenium - Wikipedia, la enciclopedia libre", pageTitle);
        
        List<WebElement> hyperlinks = driver.findElements(By.cssSelector("a"));
        System.out.println(hyperlinks.size());
        for (WebElement hyperlink : hyperlinks) {
            String links = hyperlink.getText();
            if (!links.isBlank()) {
                System.out.println("Link= "+links);
            }
        }    

        driver.close();
    }
}
