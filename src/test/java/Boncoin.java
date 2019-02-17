import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.IOException;

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
    void title() {
        assertTrue(this.webdriver.getTitle().contains("leboncoin"));
    }

    @Test
    void search() {
        assertFalse(this.webdriver.getTitle().contains("Facebook"));
    }

    @AfterEach
    void close() {
        this.webdriver.close();
    }
}
