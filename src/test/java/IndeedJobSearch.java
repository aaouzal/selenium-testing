import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IndeedJobSearch extends TestCase {


    @BeforeEach
    void open() {
        try {
            this.webdriver.get(Config.getInstance().get("indeed_url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void search_key_word() {
    	//System.out.println(webdriver.getTitle());
        assertTrue(this.webdriver.getTitle().contains("Indeed"));

        JavascriptExecutor js = (JavascriptExecutor) webdriver;
		webdriver.findElement(By.id("text-input-what")).sendKeys("Test Manager");
		//Find location field and enter London
		webdriver.findElement(By.id("text-input-where")).clear();
		//webdriver.findElement(By.id("text-input-where")).sendKeys("Sophia Antipolis (06)");
		// find findjobs button and click on it
		webdriver.findElement(By.cssSelector("div.icl-WhatWhere-buttonWrapper > button")).submit();
        //Screenshot
        takeScreenshot(Screenshot);
		// from  job search results page, get page title ad jobs count message
		System.out.println(webdriver.getTitle());
		System.out.println(webdriver.findElement(By.id("searchCount")).getText());
		boolean First=true;
		while(!webdriver.findElements(By.partialLinkText("Suivant")).isEmpty()){
			//affichages des élements en cours
			List<WebElement> allElements = webdriver.findElements(By.xpath("//*[@id=\"resultsCol\"]"));

			for (WebElement element: allElements) {
				System.out.println("########################## DEBUT ##########################");
				System.out.println(element.getText());
				System.out.println(element.getAttribute("class"));
				System.out.println(element.getCssValue("a"));
				//System.out.println((element).findElement(By.cssSelector("> a")).getText());

				mouseover(element);

				System.out.println("########################## FIN ##########################");
			}

			webdriver.findElement(By.partialLinkText("Suivant")).click();
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			//fermeture de la pop up
			if(First) {
				First=false;
				if (webdriver.findElement(By.xpath("//*[@id=\"popover-close-link\"]")) != null) {

					webdriver.findElement(By.xpath("//*[@id=\"popover-close-link\"]")).click();
				}
			}
			}
			// the last page
				List<WebElement> allElements = webdriver.findElements(By.xpath("//*[@id=\"resultsCol\"]"));

				for (WebElement element: allElements) {
					System.out.println("########################## DEBUT ##########################");
					System.out.println(element.getText());
					System.out.println(element.getAttribute("class"));
					System.out.println(element.getCssValue("a"));
					//System.out.println((element).findElement(By.cssSelector("> a")).getText());

					mouseover(element);
				}



    }
    @AfterEach
    void close() {
        this.webdriver.close();
    }
}
