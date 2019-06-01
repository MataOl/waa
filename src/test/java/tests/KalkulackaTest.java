package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.GosslingatorPage;
import pages.KalkulackaPage;

import java.util.List;

public class KalkulackaTest extends TestBase {
    private KalkulackaPage kalkulackaPage;


    @Before
    public void openPage() {
        driver.get(BASE_URL + "kalkulacka.php");
        kalkulackaPage = new KalkulackaPage(driver);
    }

    @Test
    public void itShoulSumTwoNumbers() {
        kalkulackaPage.enterFirstInput("4");
        kalkulackaPage.enterSecondInput("2");

        kalkulackaPage.sumNumbers();

        Assert.assertEquals("6", kalkulackaPage.getResult());
    }

    @Test
    public void itShouldDeductTwoNumbers() {

        kalkulackaPage.enterFirstInput("4");
        kalkulackaPage.enterSecondInput("2");

        kalkulackaPage.deductNumbers();

        Assert.assertEquals("2", kalkulackaPage.getResult());

    }

    @Test
    public void itShouldResetFields() {
        kalkulackaPage.enterFirstInput("4");
        kalkulackaPage.enterSecondInput("2");

        kalkulackaPage.deductNumbers();
        kalkulackaPage.resetCalculator();

        Assert.assertTrue(driver.findElement(By.cssSelector("[id = 'firstInput']")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id = 'secondInput']")).getAttribute("value").isEmpty());
    }

    @Test
    public void itShouldDisplayLastCalculationsForSum() {
        kalkulackaPage.enterFirstInput("10");
        kalkulackaPage.enterSecondInput("8");

        kalkulackaPage.sumNumbers();

        Assert.assertEquals("10+8 = 18", kalkulackaPage.getLatestCalculation().getText());
        Assert.assertEquals(1, kalkulackaPage.getLatestCalculations().size());
    }

}