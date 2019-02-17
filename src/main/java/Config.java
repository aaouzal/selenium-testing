import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Config instance;
    private Properties props;

    public static Config getInstance() throws IOException {
        if (Config.instance == null) {
            Config.instance = new Config("src/main/resources/selenium.config");
        }
        return Config.instance;
    }

    private Config(String path) throws IOException {
        this.props = new Properties();
        this.props.load(new FileInputStream(path));
    }

    public String get(String propertyName) {
        return this.props.getProperty(propertyName);
    }
}
