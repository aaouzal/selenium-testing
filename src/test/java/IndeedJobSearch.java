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
    void searchJob() {
		JavascriptExecutor js = (JavascriptExecutor) this.webdriver;
		assertTrue(this.webdriver.getTitle().contains("Indeed"));
        assertTrue(fillElement ("Input",By.id("text-input-what"),"Test Manager"));
		//Find location field and enter London
		assertTrue(fillElement ("click",By.id( "text-input-where"),""));
		//assertTrue(fillElement ("Input",By.id( "text-input-where"),"Sophia Antipolis (06)"));
		// find findjobs button and click on it
		assertTrue(fillElement ("submit",By.cssSelector( "div.icl-WhatWhere-buttonWrapper > button"),"Sophia Antipolis (06)"));
        //Screenshot
        takeScreenshot(Screenshot);
		// from  job search results page, get page title ad jobs count message
		//System.out.println(webdriver.getTitle());
		assertTrue(this.webdriver.findElement(By.id("searchCount")).getText().matches ("Page\\W\\d+\\W+de+\\W+\\d+\\W+emplois"));
		boolean First=true;
		while(!this.webdriver.findElements(By.partialLinkText("Suivant")).isEmpty()){
			System.out.println(this.webdriver.findElement(By.id("searchCount")).getText());
			//affichages des élements en cours
			//List<WebElement> allElements = this.webdriver.findElements(By.xpath("//*[@id=\"resultsCol\"]"));
			List<WebElement> allElements = this.webdriver.findElements(By.cssSelector("div[data-ci=\"260064422\"]"));
			System.out.println("la taille de ce bordel est : "+allElements.size());
			for (WebElement element: allElements) {
				System.out.println("elements ni: "+element.getText());
				//System.out.println(this.webdriver.findElement(By.id("searchCount")).getText());
				//assertTrue(this.webdriver.findElement(By.id("searchCount")).getText().matches ("Page\\W\\d+\\W+de+\\W+\\d+\\W+emplois"));
				mouseover(element);
			}

			this.webdriver.findElement(By.partialLinkText("Suivant")).click();
			sleep(ELEMENT_WAIT_TIMEOUT);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			//fermeture de la pop up
			if(First) {
				First=false;
				if (this.webdriver.findElement(By.xpath("//*[@id=\"popover-close-link\"]")) != null) {
					assertTrue(fillElement ("click",By.xpath("//*[@id=\"popover-close-link\"]"),""));
				}
			}
			}
			// the last page
				List<WebElement> allElements = this.webdriver.findElements(By.xpath("//*[@id=\"resultsCol\"]"));
				for (WebElement element: allElements) {
					assertTrue(this.webdriver.findElement(By.id("searchCount")).getText().matches ("Page\\W\\d+\\W+de+\\W+\\d+\\W+emplois"));
					mouseover(element);
				}

    }
    @AfterEach
    void close() {
        this.webdriver.quit();
    }
}
