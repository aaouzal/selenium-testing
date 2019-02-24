import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Google extends TestCase {


    @BeforeEach
    void open() {
        try {
            this.webdriver.get(Config.getInstance().get("google_url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void searchKeyword() {
        assertTrue(this.webdriver.getTitle().contains("Google"));

       // webdriver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys("selenium");
        assertTrue(fillElement ("Input",By.cssSelector("div.a4bIc > input"),"selenium"));
        assertTrue(fillElement ("submit",By.cssSelector("div.a4bIc > input"),""));
        this.webdriver.findElement(By.cssSelector("div.a4bIc > input")).submit();
        assertTrue(this.webdriver.getTitle().contains("Google"));
        assertTrue(this.webdriver.findElement(By.cssSelector("#search > div")).getText().contains("selenium"));
        System.out.println(this.webdriver.findElement(By.xpath("//*[@id=\"resultStats\"]")).getText());
        assertTrue(this.webdriver.findElement(By.xpath("//*[@id=\"resultStats\"]")).getText().matches("^Environ(\\W|\\d)*résultats.*"));
        //Screenshot
        takeScreenshot(Screenshot);


    }
    @AfterEach
    void close() {
        this.webdriver.quit();
    }
}
