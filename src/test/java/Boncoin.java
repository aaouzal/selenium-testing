import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class Boncoin extends TestCase {

    @BeforeEach
    void open() {
        try {
            this.webdriver.get(Config.getInstance().get("boncoin_url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test_with_moto() {
        assertTrue(webdriver.getTitle().matches(".*leboncoin.*"));
        //fill search criteria
        webdriver.findElement(By.cssSelector("div.bVqYZ > input")).sendKeys("Moto");
        webdriver.findElement(By.cssSelector("div.bVqYZ > input")).submit();
        new Select(webdriver.findElement(By.cssSelector("div._2gTTZ > select"))).selectByValue("3");
        new Select(webdriver.findElement(By.id("searcharea"))).selectByValue("6");
        new Select(webdriver.findElement(By.cssSelector("section > div:nth-child(1) > div > div > div:nth-child(2) > select"))).selectByValue("500");
        new Select(webdriver.findElement(By.cssSelector("section > div:nth-child(2) > div > div > div:nth-child(2) > select"))).selectByValue("2013");
        new Select(webdriver.findElement(By.cssSelector("section > div:nth-child(3) > div > div > div:nth-child(4) > select"))).selectByValue("30000");
        new Select(webdriver.findElement(By.cssSelector("section > div:nth-child(4) > div > div > div:nth-child(4) > select"))).selectByValue("125");
        //submit criteria
        webdriver.findElement(By.cssSelector("div._2bh4L.trackable > button")).click();
        //sorting results
        assertTrue(webdriver.findElement(By.cssSelector("div.l17WS.bgMain > div > div._36eyL")).getText().matches(".*Moto.*"));
        new Select(webdriver.findElement(By.cssSelector("div._1uEY7 > div.selectWrapper > select"))).selectByValue("price-asc");
        //scan results
        List<WebElement> allPages = webdriver.findElements(By.cssSelector("nav > div > ul > li"));
        assertFalse(allPages.isEmpty());
        for (WebElement element: allPages) {
            if (!element.equals(allPages.get(allPages.size()-1))) {
                if ((element.getText()).isEmpty()) {
                } else {
                    System.out.println(element.getText());
                    //assertFalse(element.getText().contains("oto"));

                    List<WebElement> allElements = webdriver.findElements(By.xpath("//*[@id=\"container\"]/main/div/div/div[3]/div/div[6]/div[1]/div/div[1]/div[2]/ul/li"));

                    for (WebElement element2: allElements) {
                        System.out.println(element2.getText());
                        assertFalse(element2.getText().matches(".*Motos.*"));
                        //assertFalse(element2.getAttribute("class").matches("[a-zA-Z_0-9]*"));
                        //assertTrue(element2.getAttribute("itemtype").matches("http.*"));
                        //assertFalse(element2.getAttribute("data-qa-id").matches("[a-z]*"));
                        //assertFalse(element2.getCssValue("/div/a").matches(".*"));
                        this.mouseover(element2);
                    }
                    element.click();
                }
            }
        }

        assertTrue(this.webdriver.getTitle().contains("leboncoin"));
    }


    @AfterEach
    void close() {
        this.webdriver.close();
    }
}
