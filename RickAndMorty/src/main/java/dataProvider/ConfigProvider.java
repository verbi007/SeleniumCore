package dataProvider;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String BASE_URL = readConfig().getString("url.base_url");
    String CHARACTER = readConfig().getString("url.character");
    String LOCATION = readConfig().getString("url.location");
    String EPISODE = readConfig().getString("url.episode");
}
