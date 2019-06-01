package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickMeBabyTest extends TestBase {

    @Before
    public void openPage() {
        driver.get("ajtyvit-app.westeurope.cloudapp.azure.com:8080/clickmebaby.php\n");
    }

    @Test
    public void clickMeBabyTest() {
        String actualMessage = driver.findElement(By.cssSelector("p.description")).getText();
        Assert.assertEquals("klikov", actualMessage);

        WebElement clickMeBabyButton = driver.findElement(By.id("clickMe"));
        for (int i = 0; i < 50; i++) {
            clickMeBabyButton.click();
            actualMessage = driver.findElement(By.cssSelector("p.description")).getText();
            if (i + 1 == 1) {
                Assert.assertEquals("klik", actualMessage);
            }
            if (i + 1 > 1 && i + 1 <= 4){
                Assert.assertEquals("kliky", actualMessage);
            }
            if (i + 1 > 4){
                Assert.assertEquals("klikov", actualMessage);
            }
        }
    }
}