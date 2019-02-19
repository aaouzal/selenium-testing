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
    @Order(1)
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
                        if(!element2.getText().isEmpty()) {
                            System.out.println(element2.getText());
                            assertTrue(element2.getText().contains("Moto"));
                            assertTrue(element2.getAttribute("class").matches(".*3DFQ.*"));
                            assertTrue(element2.getAttribute("itemtype").matches("^http://schema.*"));
                            assertTrue(element2.getAttribute("data-qa-id").matches(".*aditem_container.*"));
                            this.mouseover(element2);
                        }
                    }
                    element.click();
                }
            }
        }

        assertTrue(this.webdriver.getTitle().matches(".*leboncoin.*"));
    }
    @Test
    @Order(2)
    void test_with_location() {
        assertTrue(webdriver.getTitle().matches(".*leboncoin.*"));
        //fill search criteria
        webdriver.findElement(By.cssSelector("div.bVqYZ > input")).sendKeys("studio");
        webdriver.findElement(By.cssSelector("div.bVqYZ > input")).submit();
        new Select(webdriver.findElement(By.cssSelector("div._2gTTZ > select"))).selectByValue("10");
        new Select(webdriver.findElement(By.id("searcharea"))).selectByValue("6");
        new Select(webdriver.findElement(By.cssSelector("section > div:nth-child(1) > div > div > div:nth-child(2) > select"))).selectByValue("500");
        new Select(webdriver.findElement(By.cssSelector("section > div:nth-child(1) > div > div > div:nth-child(4) > select"))).selectByValue("750");
        new Select(webdriver.findElement(By.cssSelector("section > div:nth-child(2) > div > div > div:nth-child(2) > select"))).selectByValue("40");
        new Select(webdriver.findElement(By.cssSelector("section > div:nth-child(3) > div > div > div:nth-child(4) > select"))).selectByValue("7");
        //submit criteria
        webdriver.findElement(By.cssSelector("div._2bh4L.trackable > button")).click();
        //sorting results
        assertTrue(webdriver.findElement(By.cssSelector("div.l17WS.bgMain > div > div._36eyL")).getText().matches(".*Locations.*"));
        new Select(webdriver.findElement(By.cssSelector("div._1uEY7 > div.selectWrapper > select"))).selectByValue("price-asc");
        //scan results
        List<WebElement> allPages = webdriver.findElements(By.cssSelector("nav > div > ul > li"));
        assertTrue(allPages.isEmpty());
        for (WebElement element: allPages) {
            if (!element.equals(allPages.get(allPages.size()-1))) {
                if ((element.getText()).isEmpty()) {
                } else {
                    System.out.println(element.getText());
                    //assertFalse(element.getText().contains("oto"));

                    List<WebElement> allElements = webdriver.findElements(By.xpath("//*[@id=\"container\"]/main/div/div/div[3]/div/div[6]/div[1]/div/div[1]/div[2]/ul/li"));

                    for (WebElement element2: allElements) {
                        if(!element2.getText().isEmpty()) {
                            assertTrue(element2.getText().matches(".*studio.*"));
                            assertTrue(element2.getAttribute("class").matches("_3DFQ-"));
                            assertTrue(element2.getAttribute("itemtype").matches("http://schema.*"));
                            assertTrue(element2.getAttribute("data-qa-id").matches("aditem_container"));
                            this.mouseover(element2);
                        }
                    }
                    element.click();
                }
            }
        }

        assertTrue(this.webdriver.getTitle().matches(".*leboncoin.*"));
    }
    @Test
    @Order(3)
    void test_with_evenements() {
        assertTrue(webdriver.getTitle().matches(".*leboncoin.*"));
        //fill search criteria
        webdriver.findElement(By.cssSelector("div.bVqYZ > input")).sendKeys("mariage");
        webdriver.findElement(By.cssSelector("div.bVqYZ > input")).submit();
        new Select(webdriver.findElement(By.cssSelector("div._2gTTZ > select"))).selectByValue("49");
        new Select(webdriver.findElement(By.id("searcharea"))).selectByValue("6");
        //submit criteria
        webdriver.findElement(By.cssSelector("div._2bh4L.trackable > button")).click();
        //sorting results
        assertTrue(webdriver.findElement(By.cssSelector("div.l17WS.bgMain > div > div._36eyL")).getText().matches(".*mariage.*"));
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
                        if(!element2.getText().isEmpty()) {
                            //assertTrue(element2.getText().matches(".*nements.*"));
                            assertTrue(element2.getAttribute("class").matches("_3DFQ-"));
                            assertTrue(element2.getAttribute("itemtype").matches("http://schema.*"));
                            assertTrue(element2.getAttribute("data-qa-id").matches("aditem_container"));
                            this.mouseover(element2);
                        }
                    }
                    element.click();
                }
            }
        }

        assertTrue(this.webdriver.getTitle().matches(".*leboncoin.*"));
    }

    @Test
    @Order(4)
    void test_with_telephone() {
        assertTrue(webdriver.getTitle().matches(".*leboncoin.*"));
        //fill search criteria
        webdriver.findElement(By.cssSelector("div.bVqYZ > input")).sendKeys("samsung");
        webdriver.findElement(By.cssSelector("div.bVqYZ > input")).submit();
        new Select(webdriver.findElement(By.cssSelector("div._2gTTZ > select"))).selectByValue("17");
        new Select(webdriver.findElement(By.id("searcharea"))).selectByValue("6");
        new Select(webdriver.findElement(By.cssSelector("section > div > div > div > div:nth-child(2) > select"))).selectByValue("50");
        new Select(webdriver.findElement(By.cssSelector("section > div > div > div > div:nth-child(4) > select"))).selectByValue("300");
        //submit criteria
        webdriver.findElement(By.cssSelector("div._2bh4L.trackable > button")).click();
        //sorting results
        assertTrue(webdriver.findElement(By.cssSelector("div.l17WS.bgMain > div > div._36eyL")).getText().matches(".*samsung.*"));
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
                        if(!element2.getText().isEmpty()) {
                            assertTrue(element2.getAttribute("class").matches("_3DFQ-"));
                            assertTrue(element2.getAttribute("itemtype").matches("http://schema.*"));
                            assertTrue(element2.getAttribute("data-qa-id").matches("aditem_container"));
                            this.mouseover(element2);
                        }
                    }
                    element.click();
                }
            }
        }

        assertTrue(this.webdriver.getTitle().matches(".*leboncoin.*"));
    }
    @Test
    @Order(5)
    void test_with_campings() {
        assertTrue(webdriver.getTitle().matches(".*leboncoin.*"));
        //fill search criteria
        webdriver.findElement(By.cssSelector("div.bVqYZ > input")).sendKeys("mobil home");
        webdriver.findElement(By.cssSelector("div.bVqYZ > input")).submit();
        new Select(webdriver.findElement(By.cssSelector("div._2gTTZ > select"))).selectByValue("68");
        new Select(webdriver.findElement(By.id("searcharea"))).selectByValue("6");
        //new Select(webdriver.findElement(By.cssSelector("section > div:nth-child(1) > div > div > div:nth-child(2) > select"))).selectByValue("50");
        new Select(webdriver.findElement(By.cssSelector("section > div:nth-child(1) > div > div > div:nth-child(4) > select"))).selectByValue("150");
        new Select(webdriver.findElement(By.cssSelector("section > div:nth-child(3) > div > div > div:nth-child(2) > select"))).selectByValue("1");
        new Select(webdriver.findElement(By.cssSelector("section > div:nth-child(4) > div > div > div > select"))).selectByValue("1");
        //submit criteria
        webdriver.findElement(By.cssSelector("div._2bh4L.trackable > button")).click();
        //sorting results
        assertTrue(webdriver.findElement(By.cssSelector("div.l17WS.bgMain > div > div._36eyL")).getText().matches(".*Camping.*"));
        new Select(webdriver.findElement(By.cssSelector("div._1uEY7 > div.selectWrapper > select"))).selectByValue("price-asc");
        //scan results
        List<WebElement> allPages = webdriver.findElements(By.cssSelector("nav > div > ul > li"));
        assertTrue(allPages.isEmpty());
        for (WebElement element: allPages) {
            if (!element.equals(allPages.get(allPages.size()-1))) {
                if ((element.getText()).isEmpty()) {
                } else {
                    System.out.println(element.getText());
                    //assertFalse(element.getText().contains("oto"));

                    List<WebElement> allElements = webdriver.findElements(By.xpath("//*[@id=\"container\"]/main/div/div/div[3]/div/div[6]/div[1]/div/div[1]/div[2]/ul/li"));

                    for (WebElement element2: allElements) {
                        if(!element2.getText().isEmpty()) {
                            assertTrue(element2.getText().matches(".*campings.*"));
                            assertTrue(element2.getAttribute("class").matches("_3DFQ-"));
                            assertTrue(element2.getAttribute("itemtype").matches("http://schema.*"));
                            assertTrue(element2.getAttribute("data-qa-id").matches("aditem_container"));
                            this.mouseover(element2);
                        }
                    }
                    element.click();
                }
            }
        }

        assertTrue(this.webdriver.getTitle().matches(".*leboncoin.*"));
    }


    @AfterEach
    void close() {
        this.webdriver.close();
    }
}
