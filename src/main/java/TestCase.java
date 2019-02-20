import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;



public class TestCase {
    protected WebDriver webdriver;
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
        this.webdriver = new ChromeDriver();
        this.webdriver.manage().window().maximize();
    }

    public boolean fillElement (String type,String by, String path,String Value){
        if(type.matches("Select")){
            if(by.matches("id")) {
                new Select(webdriver.findElement(By.id(path))).selectByValue(Value);
            }else if (by.matches("cssSelector")) {
                new Select(webdriver.findElement(By.cssSelector(path))).selectByValue(Value);
            }else if (by.matches("xpath")) {
                new Select(webdriver.findElement(By.xpath(path))).selectByValue(Value);
            }else if (by.matches("partialLinkText")) {
                new Select(webdriver.findElement(By.partialLinkText(path))).selectByValue(Value);
            }else if (by.matches("className")) {
                new Select(webdriver.findElement(By.className(path))).selectByValue(Value);
            }else if (by.matches("name")) {
                new Select(webdriver.findElement(By.name(path))).selectByValue(Value);
            }else if (by.matches("tagName")) {
                new Select(webdriver.findElement(By.tagName(path))).selectByValue(Value);
            }else{return false;}
                return true;
        }
        else  if(type.matches("Input")){
                if(by.matches("id")) {
                    webdriver.findElement(By.id(path)).sendKeys(Value);
                }else if (by.matches("cssSelector")) {
                    webdriver.findElement(By.cssSelector(path)).sendKeys(Value);
                }else if (by.matches("xpath")) {
                    webdriver.findElement(By.xpath(path)).sendKeys(Value);
                }else if (by.matches("partialLinkText")) {
                    webdriver.findElement(By.partialLinkText(path)).sendKeys(Value);
                }else if (by.matches("className")) {
                    webdriver.findElement(By.className(path)).sendKeys(Value);
                }else if (by.matches("name")) {
                    webdriver.findElement(By.name(path)).sendKeys(Value);
                }else if (by.matches("tagName")) {
                    webdriver.findElement(By.tagName(path)).sendKeys(Value);
                }else{return false;}
                return true;
            }
        else  if(type.matches("submit")){
            if(by.matches("id")) {
                webdriver.findElement(By.id(path)).submit();
            }else if (by.matches("cssSelector")) {
                webdriver.findElement(By.cssSelector(path)).submit();
            }else if (by.matches("xpath")) {
                webdriver.findElement(By.xpath(path)).submit();
            }else if (by.matches("partialLinkText")) {
                webdriver.findElement(By.partialLinkText(path)).submit();
            }else if (by.matches("className")) {
                webdriver.findElement(By.className(path)).submit();
            }else if (by.matches("name")) {
                webdriver.findElement(By.name(path)).submit();
            }else if (by.matches("tagName")) {
                webdriver.findElement(By.tagName(path)).submit();
            }else{return false;}
            return true;
        }
        else  if(type.matches("click")){
            if(by.matches("id")) {
                webdriver.findElement(By.id(path)).click();
            }else if (by.matches("cssSelector")) {
                webdriver.findElement(By.cssSelector(path)).click();
            }else if (by.matches("xpath")) {
                webdriver.findElement(By.xpath(path)).click();
            }else if (by.matches("partialLinkText")) {
                webdriver.findElement(By.partialLinkText(path)).click();
            }else if (by.matches("className")) {
                webdriver.findElement(By.className(path)).click();
            }else if (by.matches("name")) {
                webdriver.findElement(By.name(path)).click();
            }else if (by.matches("tagName")) {
                webdriver.findElement(By.tagName(path)).click();
            }else{return false;}
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
       // builder.contextClick(element);
       // builder.contextClick(element).sendKeys("t").perform();
    }
}
