package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GosslingatorPage;

public class TestBase {
    protected WebDriver driver;
    protected final String BASE_URL = "http://localhost/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
