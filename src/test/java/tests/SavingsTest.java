package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.PokemonPage;

import java.awt.*;

public class SavingsTest extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "savingscalculator.php");
    }

    @Test
    public void checkButtonEnabled() {
        String[] fundsToSelect = {"Death Star real estate"};
        WebElement fundSelect = driver.findElement(By.id("fundSelect"));
        for (String fundToSelect : fundsToSelect) {
            new Select(fundSelect).selectByVisibleText(fundToSelect);
        }
        String sum = "2000";
        String years = "5";
        String email = "Maol@gmail.com";

        enterNextData(sum,years,email);

        Assert.assertTrue(getSavingsButton().getAttribute("class").contains("btn-success"));
    }

    @Test
    public void checkSumsAreNotEmpty() {
        String[] fundsToSelect = {"Death Star real estate"};
        WebElement fundSelect = driver.findElement(By.id("fundSelect"));
        for (String fundToSelect : fundsToSelect) {
            new Select(fundSelect).selectByVisibleText(fundToSelect);
        }
        String sum = "2000";
        String years = "5";
        String email = "Maol@gmail.com";

        enterNextData(sum,years,email);

        Assert.assertFalse(getFirstSum().isEmpty());
        Assert.assertFalse(getSecondSum().isEmpty());
    }

    @Test
    public void checkRiskIsNotEmpty() {
        String[] fundsToSelect = {"Death Star real estate"};
        WebElement fundSelect = driver.findElement(By.id("fundSelect"));
        for (String fundToSelect : fundsToSelect) {
            new Select(fundSelect).selectByVisibleText(fundToSelect);
        }
        String sum = "2000";
        String years = "5";
        String email = "Maol@gmail.com";

        enterNextData(sum,years,email);

        Assert.assertFalse(getTextOfRisk().isEmpty());
    }

    @Test
    public void itShouldCheckNewNote() {
        String[] fundsToSelect = {"Death Star real estate"};
        WebElement fundSelect = driver.findElement(By.id("fundSelect"));
        for (String fundToSelect : fundsToSelect) {
            new Select(fundSelect).selectByVisibleText(fundToSelect);
        }
        String sum = "2000";
        String years = "5";
        String email = "Maol@gmail.com";

        enterNextData(sum,years,email);

        getSavingsButton().click();

        Assert.assertTrue(getLastNote().isDisplayed());
        Assert.assertEquals("Death Star real estate", getLastNote().findElement(By.cssSelector("p.fund-description")).getText());
    }





    private void enterNextData(String sum, String years, String email){
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(sum);
        driver.findElement(By.id("yearsInput")).sendKeys(years);
        driver.findElement(By.id("emailInput")).sendKeys(email);
    }

    private WebElement getSavingsButton (){
        return driver.findElement(By.xpath("//button[contains(text(),'Apply for saving')]"));
    }

    private WebElement getLastNote(){
        return driver.findElement(By.cssSelector("ul.saving-list li:last-child"));
    }

    private String getFirstSum(){
        return driver.findElement(By.xpath("//div/div[1]/p")).getText();
    }

    private String getSecondSum(){
        return driver.findElement(By.xpath("//div/div[2]/p")).getText();
    }

    private String getTextOfRisk (){
        return driver.findElement(By.xpath("//div/div[3]/p")).getText();
    }
}