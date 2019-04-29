package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTrainingTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/xpathtrainingcenter.php");

    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        System.out.println("s panom bohom idem od vas");
    }

    @Test
    public void itShouldCheckTextSecond() {
        String message = "second button";
        driver.findElement(By.xpath("//button[contains(text(),'Second button')]")).click();
        String actualMessage = driver.findElement(By.xpath("//span[contains(text(),'You clicked Second button')]")).getText();
        Assert.assertEquals("you clicked " + message, actualMessage);

    }

    @Test
    public void itShouldDisplayEnteredMessage() {

        String message = "vonku prsi";
        driver.findElement(By.cssSelector("input")).sendKeys(message);
        driver.findElement(By.cssSelector("#hitme")).click();
        String actualMessage = driver.findElement(By.xpath("//h2/span")).getText();
        Assert.assertEquals("you entered " + message, actualMessage);
    }
}