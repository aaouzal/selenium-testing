import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class Boncoin extends TestCase {

    @BeforeEach
    void open() {
        try {
            this.webdriver.get(Config.getInstance().get("boncoin_url"));
            assertTrue(fillElement ("click","cssSelector", "g[data-reactid=\'208\']",""));
            sleep(4000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    void test_with_moto() {
        assertTrue(webdriver.getTitle().matches(".*leboncoin.*"));
        //fill search criteria
        assertTrue(fillElement ("Input","cssSelector", "div.bVqYZ > input","Moto"));
        assertTrue(fillElement ("submit","cssSelector","div.bVqYZ > input",""));
        assertTrue(fillElement ("Select","cssSelector","div._2gTTZ > select","3"));
        assertTrue(fillElement ("Select","id","searcharea","6"));
        assertTrue(fillElement ("Select","cssSelector","section > div:nth-child(1) > div > div > div:nth-child(2) > select","500"));
        assertTrue(fillElement ("Select","cssSelector","section > div:nth-child(2) > div > div > div:nth-child(2) > select","2013"));
        assertTrue(fillElement ("Select","cssSelector","section > div:nth-child(3) > div > div > div:nth-child(4) > select","30000"));
        assertTrue(fillElement ("Select","cssSelector","section > div:nth-child(4) > div > div > div:nth-child(4) > select","125"));
        //submit criteria
        assertTrue(fillElement ("click","cssSelector","div._2bh4L.trackable > button",""));
        //sorting results
        assertTrue(webdriver.findElement(By.cssSelector("div.l17WS.bgMain > div > div._36eyL")).getText().matches(".*Moto.*"));
        assertTrue(fillElement ("Select","cssSelector","div._1uEY7 > div.selectWrapper > select","price-asc"));
        //Screenshot
        takeScreenshot(Screenshot);
        //scan results
        List<WebElement> allPages = webdriver.findElements(By.cssSelector("nav > div > ul > li"));
        assertFalse(allPages.isEmpty());
        for (WebElement element: allPages) {
            if (!element.equals(allPages.get(allPages.size()-1))) {
                if ((element.getText()).isEmpty()) {
                } else {
                    List<WebElement> allElements = webdriver.findElements(By.xpath("//*[@id=\"container\"]/main/div/div/div[3]/div/div[6]/div[1]/div/div[1]/div[2]/ul/li"));
                    for (WebElement element2: allElements) {
                        assertTrue(check_element(element2));
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
        assertTrue(fillElement ("Input","cssSelector", "div.bVqYZ > input","studio"));
        assertTrue(fillElement ("submit","cssSelector","div.bVqYZ > input",""));
        assertTrue(fillElement ("Select","cssSelector","div._2gTTZ > select","10"));
        assertTrue(fillElement ("Select","id","searcharea","6"));
        assertTrue(fillElement ("Select","cssSelector","section > div:nth-child(1) > div > div > div:nth-child(2) > select","500"));
        assertTrue(fillElement ("Select","cssSelector","section > div:nth-child(1) > div > div > div:nth-child(4) > select","750"));
        assertTrue(fillElement ("Select","cssSelector","section > div:nth-child(2) > div > div > div:nth-child(2) > select","40"));
        assertTrue(fillElement ("Select","cssSelector","section > div:nth-child(3) > div > div > div:nth-child(4) > select","7"));
        //submit criteria
        assertTrue(fillElement ("click","cssSelector","div._2bh4L.trackable > button",""));
        //sorting results
        assertTrue(webdriver.findElement(By.cssSelector("div.l17WS.bgMain > div > div._36eyL")).getText().matches(".*Locations.*"));
        assertTrue(fillElement ("Select","cssSelector","div._1uEY7 > div.selectWrapper > select","price-asc"));
        //Screenshot
        takeScreenshot(Screenshot);
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
                        assertTrue(check_element(element2));
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
        assertTrue(fillElement ("Input","cssSelector", "div.bVqYZ > input","mariage"));
        assertTrue(fillElement ("submit","cssSelector","div.bVqYZ > input",""));
        assertTrue(fillElement ("Select","cssSelector","div._2gTTZ > select","49"));
        assertTrue(fillElement ("Select","id","searcharea","6"));

        //submit criteria
        assertTrue(fillElement ("click","cssSelector","div._2bh4L.trackable > button",""));
        //sorting results
        assertTrue(webdriver.findElement(By.cssSelector("div.l17WS.bgMain > div > div._36eyL")).getText().matches(".*mariage.*"));
        assertTrue(fillElement ("Select","cssSelector","div._1uEY7 > div.selectWrapper > select","price-asc"));
        //Screenshot
        takeScreenshot(Screenshot);
        //scan results on the first page
        List<WebElement> allElements = webdriver.findElements(By.xpath("//*[@id=\"container\"]/main/div/div/div[3]/div/div[6]/div[1]/div/div[1]/div[2]/ul/li"));
        assertFalse(allElements.isEmpty());
        for (WebElement element2: allElements) {
            assertTrue(check_element(element2));
        }

        assertTrue(this.webdriver.getTitle().matches(".*leboncoin.*"));
    }

    @Test
    @Order(4)
    void test_with_telephone() {
        assertTrue(webdriver.getTitle().matches(".*leboncoin.*"));
        //fill search criteria
        assertTrue(fillElement ("Input","cssSelector", "div.bVqYZ > input","samsung"));
        assertTrue(fillElement ("submit","cssSelector","div.bVqYZ > input",""));
        assertTrue(fillElement ("Select","cssSelector","div._2gTTZ > select","17"));
        assertTrue(fillElement ("Select","id","searcharea","6"));
        assertTrue(fillElement ("Select","cssSelector","section > div > div > div > div:nth-child(2) > select","50"));
        assertTrue(fillElement ("Select","cssSelector","section > div > div > div > div:nth-child(4) > select","300"));
        //submit criteria
        assertTrue(fillElement ("click","cssSelector","div._2bh4L.trackable > button",""));
        //sorting results
        assertTrue(webdriver.findElement(By.cssSelector("div.l17WS.bgMain > div > div._36eyL")).getText().matches(".*samsung.*"));
        assertTrue(fillElement ("Select","cssSelector","div._1uEY7 > div.selectWrapper > select","price-asc"));
        //Screenshot
        takeScreenshot(Screenshot);
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
                        assertTrue(check_element(element2));
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
        assertTrue(fillElement ("Input","cssSelector", "div.bVqYZ > input","mobil home"));
        assertTrue(fillElement ("submit","cssSelector","div.bVqYZ > input",""));
        assertTrue(fillElement ("Select","cssSelector","div._2gTTZ > select","68"));
        assertTrue(fillElement ("Select","id","searcharea","6"));
        assertTrue(fillElement ("Select","cssSelector","section > div:nth-child(1) > div > div > div:nth-child(4) > select","150"));
        assertTrue(fillElement ("Select","cssSelector","section > div:nth-child(3) > div > div > div:nth-child(2) > select","1"));
        assertTrue(fillElement ("Select","cssSelector","section > div:nth-child(4) > div > div > div > select","1"));
        //submit criteria
        assertTrue(fillElement ("click","cssSelector","div._2bh4L.trackable > button",""));
        //sorting results
        assertTrue(webdriver.findElement(By.cssSelector("div.l17WS.bgMain > div > div._36eyL")).getText().matches(".*Camping.*"));
        assertTrue(fillElement ("Select","cssSelector","div._1uEY7 > div.selectWrapper > select","price-asc"));
        //Screenshot
        takeScreenshot(Screenshot);
        //scan results on the first page
        List<WebElement> allElements = webdriver.findElements(By.xpath("//*[@id=\"container\"]/main/div/div/div[3]/div/div[6]/div[1]/div/div[1]/div[2]/ul/li"));
        assertFalse(allElements.isEmpty());
        for (WebElement element2: allElements) {
            assertTrue(check_element(element2));
        }

        assertTrue(this.webdriver.getTitle().matches(".*leboncoin.*"));
    }


    @AfterEach
    void close() {
        this.webdriver.close();
    }

    boolean check_element( WebElement element){
        if(!element.getText().isEmpty()) {
            assertTrue(element.getAttribute("class").matches(".*3DFQ.*"));
            assertTrue(element.getAttribute("itemtype").matches("^http://schema.*"));
            assertTrue(element.getAttribute("data-qa-id").matches(".*aditem_container.*"));
            this.mouseover(element);
        }
        return true;
    }

}
