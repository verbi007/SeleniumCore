package coreUI;

import drivers.DriverType;
import drivers.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseSeleniumTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeClass
    public static void setUp() {
        driver = WebDriverFactory.getDriver(DriverType.CHROME);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        BaseSeleniumPage.setDriver(driver, wait);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
