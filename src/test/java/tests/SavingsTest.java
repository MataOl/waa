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
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        driver.findElement(By.id("yearsInput")).sendKeys("5");
        driver.findElement(By.id("emailInput")).sendKeys("Maol@gmail.com");

        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Apply for saving')]")).getAttribute("class").contains("btn-success"));
    }

    @Test
    public void checkSumsAreNotEmpty() {
        String[] fundsToSelect = {"Death Star real estate"};
        WebElement fundSelect = driver.findElement(By.id("fundSelect"));
        for (String fundToSelect : fundsToSelect) {
            new Select(fundSelect).selectByVisibleText(fundToSelect);
        }
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        driver.findElement(By.id("yearsInput")).sendKeys("5");
        driver.findElement(By.id("emailInput")).sendKeys("Maol@gmail.com");

        Assert.assertFalse(driver.findElement(By.xpath("//div/div[1]/p")).getText().isEmpty());
        Assert.assertFalse(driver.findElement(By.xpath("//div/div[2]/p")).getText().isEmpty());
    }

    @Test
    public void checkRiskIsNotEmpty() {
        String[] fundsToSelect = {"Death Star real estate"};
        WebElement fundSelect = driver.findElement(By.id("fundSelect"));
        for (String fundToSelect : fundsToSelect) {
            new Select(fundSelect).selectByVisibleText(fundToSelect);
        }
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        driver.findElement(By.id("yearsInput")).sendKeys("5");
        driver.findElement(By.id("emailInput")).sendKeys("Maol@gmail.com");

        Assert.assertFalse(driver.findElement(By.xpath("//div/div[3]/p")).getText().isEmpty());
    }

    @Test
    public void itShouldCheckNewNote() {
        String[] fundsToSelect = {"Death Star real estate"};
        WebElement fundSelect = driver.findElement(By.id("fundSelect"));
        for (String fundToSelect : fundsToSelect) {
            new Select(fundSelect).selectByVisibleText(fundToSelect);
        }
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        driver.findElement(By.id("yearsInput")).sendKeys("5");
        driver.findElement(By.id("emailInput")).sendKeys("Maol@gmail.com");

        driver.findElement(By.xpath("//div/button[contains(text(),'Apply for saving')]")).click();
        WebElement lastNote = driver.findElement(By.cssSelector("ul.saving-list li:last-child"));
        Assert.assertTrue(lastNote.isDisplayed());
        Assert.assertEquals("Death Star real estate", lastNote.findElement(By.cssSelector("p.fund-description")).getText());
    }
}