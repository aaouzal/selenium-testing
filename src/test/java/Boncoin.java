import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.IOException;

public class Boncoin extends TestCase {
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
