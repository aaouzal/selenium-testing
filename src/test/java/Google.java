import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Google extends TestCase {

    @BeforeEach
    void open() {
        try {
            this.webdriver.get(Config.getInstance().get("google_url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
