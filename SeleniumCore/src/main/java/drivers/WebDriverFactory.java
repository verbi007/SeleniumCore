package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class WebDriverFactory {
    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    //ChromeDriver
    public static final Supplier<WebDriver> chromeDriverSupplier = () -> {
      WebDriverManager.chromedriver().setup();
      return new ChromeDriver();
    };

    //EdgeDriver
    public static final Supplier<WebDriver> edgeDriverSupplier = () -> {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    };

    static {
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.EDGE, edgeDriverSupplier);
    }

    public static WebDriver getDriver(DriverType driverType) {
        return driverMap.get(driverType).get();
    }
}
