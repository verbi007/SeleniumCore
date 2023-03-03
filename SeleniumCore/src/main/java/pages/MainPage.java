package pages;

import coreUI.BaseSeleniumPage;
import dataProvider.ConfigProvider;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {

    public MainPage() {
        driver.navigate().to(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }
}
