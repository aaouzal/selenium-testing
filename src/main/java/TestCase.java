import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;


public class TestCase {
    protected WebDriver webdriver;
    protected int ELEMENT_WAIT_TIMEOUT;
    protected int PAGE_WAIT_TIMEOUT;

    public TestCase() {
        try {
            System.setProperty("webdriver.chrome.driver", Config.getInstance().get("chrome.driver"));
            ELEMENT_WAIT_TIMEOUT = Integer.parseInt(Config.getInstance().get("ELEMENT_WAIT_TIMEOUT"));
            PAGE_WAIT_TIMEOUT = Integer.parseInt(Config.getInstance().get("PAGE_WAIT_TIMEOUT"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.webdriver = new ChromeDriver();
    }
    public boolean isAlertPresent() {
        try {
            final Alert alert = this.webdriver.switchTo().alert();
            alert.getText();
        } catch (final NoAlertPresentException nape) {
            return false;
        }
        return true;
    }
    public void dismissAlert() {
        final Alert alert = this.webdriver.switchTo().alert();
        alert.dismiss();
    }
    public String getAlertText() {
        final Alert alert = this.webdriver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {
        final Alert alert = this.webdriver.switchTo().alert();
        alert.accept();
    }
    public void takeScreenshot(final String path) {
        final File scrFile = ((TakesScreenshot) this.webdriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected void mouseover(final By by) {
        final WebElement element = this.webdriver.findElement(by);
        final Actions builder = new Actions(this.webdriver);
        final Action mouseover = builder.moveToElement(element).build();
        mouseover.perform();
    }
}
