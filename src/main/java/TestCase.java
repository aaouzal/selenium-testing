import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;



public class TestCase {
    static protected WebDriver webdriver;
    protected int ELEMENT_WAIT_TIMEOUT;
    protected int PAGE_WAIT_TIMEOUT;
    protected String Screenshot;
    public TestCase() {
            try {
                System.setProperty("webdriver.chrome.driver", Config.getInstance().get("chrome.driver"));
                ELEMENT_WAIT_TIMEOUT = Integer.parseInt(Config.getInstance().get("ELEMENT_WAIT_TIMEOUT"));
                PAGE_WAIT_TIMEOUT = Integer.parseInt(Config.getInstance().get("PAGE_WAIT_TIMEOUT"));
                Screenshot=Config.getInstance().get("Screenshot");
            } catch (IOException e) {
                e.printStackTrace();
            }
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions chrome_options = new ChromeOptions();
            chrome_options.addArguments("--disable-geolocation");
            chrome_options.addArguments("--incognito");
            chrome_options.addArguments("--disable-extensions");
            capabilities.setBrowserName("chrome");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chrome_options);
            this.webdriver = new ChromeDriver();
            this.webdriver.manage().window().maximize();

    }

        public boolean fillElement (String type, By by,String value) {
            if(type.contentEquals("Select")){
                new Select(this.webdriver.findElement(by)).selectByValue(value);
                return true;
            }
            if(type.contentEquals("Input")){
                this.webdriver.findElement(by).sendKeys(value);
                return true;
            }
            if(type.contentEquals("submit")){
                this.webdriver.findElement(by).submit();
                return true;
            }
            if(type.contentEquals("click")){
                this.webdriver.findElement(by).click();
                return true;
            }
            return false;
        }

    public static void sleep(final long millis) throws IllegalArgumentException {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException e) {
        }
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
    public void takeScreenshot(String path) {
        sleep(1500);
        final File scrFile = ((TakesScreenshot) this.webdriver).getScreenshotAs(OutputType.FILE);
        try {
            path=path+ RandomStringUtils.random(7, true, false)+".png";
            FileUtils.copyFile(scrFile, new File(path));
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void mouseover(WebElement element) {
        final Actions builder = new Actions(this.webdriver);
        final Action mouseover = builder.moveToElement(element).build();
        mouseover.perform();
        //builder.contextClick(element).sendKeys("t").perform();
    }
}
