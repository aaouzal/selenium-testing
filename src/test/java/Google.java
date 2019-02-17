import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Google extends TestCase {

    @BeforeEach
    void open() {
        this.webdriver.get("http://google.com");
    }

    @Test
    void title() {
        assertTrue(this.webdriver.getTitle().contains("Google"));
    }

    @Test
    void search() {
        assertTrue(this.webdriver.getTitle().contains("Facebook"));
    }

    @AfterEach
    void close() {
        this.webdriver.close();
    }
}
