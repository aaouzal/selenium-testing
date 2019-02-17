import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class TestCase {
    protected WebDriver webdriver;

    public TestCase() {
        try {
            System.setProperty("webdriver.chrome.driver", Config.getInstance().get("chrome.driver"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.webdriver = new ChromeDriver();
    }

}
