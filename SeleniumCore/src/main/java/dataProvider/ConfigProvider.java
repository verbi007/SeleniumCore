package dataProvider;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.load("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("main.url");
}
