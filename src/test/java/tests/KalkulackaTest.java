package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.GosslingatorPage;

import java.util.List;

public class KalkulackaTest extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "kalkulacka.php");
    }

    @Test
    public void itShoulSumTwoNumbers() {
        enterFirstInput("4");
        enterSecondInput("2");

        sumNumbers();

        Assert.assertEquals("6", getResult());
    }

    @Test
    public void itShouldDeductTwoNumbers() {

        enterFirstInput("4");
        enterSecondInput("2");

        deductNumbers();

        Assert.assertEquals("2", getResult());

    }

    @Test
    public void itShouldResetFields() {
        enterFirstInput("4");
        enterSecondInput("2");

        deductNumbers();
        resetCalculator();

        Assert.assertTrue(driver.findElement(By.cssSelector("[id = 'firstInput']")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.cssSelector("[id = 'secondInput']")).getAttribute("value").isEmpty());
    }

    @Test
    public void itShouldDisplayLastCalculationsForSum() {
        enterFirstInput("10");
        enterSecondInput("8");

        sumNumbers();

        Assert.assertEquals("10+8 = 18", getLatestCalculation().getText());
        Assert.assertEquals(1, getLatestCalculations().size());
    }

    private void enterFirstInput(String textToInput){
        driver.findElement(By.cssSelector("[id = 'firstInput']")).sendKeys(textToInput);
    }

    private void enterSecondInput(String textToInput){
        driver.findElement(By.cssSelector("[id = 'secondInput']")).sendKeys(textToInput);
    }

    private void sumNumbers(){
        driver.findElement(By.id("count")).click();
    }

    private void deductNumbers(){
        driver.findElement(By.id("deduct")).click();
    }

    private void resetCalculator(){
        driver.findElement(By.id("reset")).click();
    }

    private String getResult(){
       return driver.findElement(By.id("result")).getText();
    }

    private WebElement getLatestCalculation(){
        return driver.findElement(By.cssSelector("ul.latest-results li"));
    }

    private List<WebElement> getLatestCalculations(){
        return driver.findElements(By.cssSelector("ul.latest-results li"));
    }
}