package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.GosslingatorPage;

public class KalkulackaTest extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "kalkulacka.php");
    }

    @Test
    public void itShoulSumTwoNumbers() {
        driver.findElement(By.cssSelector("[id = 'firstInput']")).sendKeys("4");
        driver.findElement(By.cssSelector("[id = 'secondInput']")).sendKeys("2");

        driver.findElement(By.id("count")).click();

        Assert.assertEquals("6", driver.findElement(By.id("result")).getText());
    }

    @Test
    public void itShouldDeductTwoNumbers() {

        driver.findElement(By.cssSelector("[id = 'firstInput']")).sendKeys("4");
        driver.findElement(By.cssSelector("[id = 'secondInput']")).sendKeys("2");

        driver.findElement(By.id("deduct")).click();

        Assert.assertEquals("2", driver.findElement(By.id("result")).getText());

    }

    @Test
    public void itShouldResetFields() {
        driver.findElement(By.cssSelector("[id = 'firstInput']")).sendKeys("4");
        driver.findElement(By.cssSelector("[id = 'secondInput']")).sendKeys("2");

        driver.findElement(By.id("deduct")).click();
        driver.findElement(By.id("reset")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("[id = 'firstInput']")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id = 'secondInput']")).getAttribute("value").isEmpty());
    }

    @Test
    public void itShouldDisplayLastCalculationsForSum() {
        driver.findElement(By.cssSelector("[id = 'firstInput']")).sendKeys("10");
        driver.findElement(By.cssSelector("[id = 'secondInput']")).sendKeys("8");

        driver.findElement(By.id("count")).click();

        Assert.assertEquals("10+8 = 18", driver.findElement(By.cssSelector("ul.latest-results li")).getText());
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul.latest-results li")).size());
    }
}