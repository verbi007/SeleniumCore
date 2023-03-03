import coreUI.BaseSeleniumTest;
import org.junit.Test;
import pages.MainPage;

public class AppTest extends BaseSeleniumTest {
    @Test
    public void oneTest() {
        new MainPage();
    }
}
