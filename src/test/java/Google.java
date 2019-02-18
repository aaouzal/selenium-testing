import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
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
    void search_key_word() {
        assertTrue(this.webdriver.getTitle().contains("Google"));

        webdriver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys("selenium");
        webdriver.findElement(By.cssSelector("div.a4bIc > input")).submit();
        assertTrue(this.webdriver.getTitle().contains("Google"));
        assertTrue(this.webdriver.findElement(By.cssSelector("#search > div")).getText().contains("selenium"));
        assertTrue(this.webdriver.findElement(By.xpath("//*[@id=\"resultStats\"]")).getText().matches("^Environ.*résultats.*"));



    }

    @AfterEach
    void close() {
        this.webdriver.close();
    }
}
