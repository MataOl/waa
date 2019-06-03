package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.PokemonPage;
import pages.SavingsPage;

import java.awt.*;

public class SavingsTest extends TestBase {
private SavingsPage savingsPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "savingscalculator.php");
        savingsPage = new SavingsPage(driver);
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

        savingsPage.enterNextData(sum,years,email);

        Assert.assertTrue(savingsPage.getSavingsButton().getAttribute("class").contains("btn-success"));
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

        savingsPage.enterNextData(sum,years,email);

        Assert.assertFalse(savingsPage.getFirstSum().isEmpty());
        Assert.assertFalse(savingsPage.getSecondSum().isEmpty());
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

        savingsPage.enterNextData(sum,years,email);

        Assert.assertFalse(savingsPage.getTextOfRisk().isEmpty());
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

        savingsPage.enterNextData(sum,years,email);

        savingsPage.getSavingsButton().click();

        Assert.assertTrue(savingsPage.getLastNote().isDisplayed());
        Assert.assertEquals("Death Star real estate", savingsPage.getLastNote().findElement(By.cssSelector("p.fund-description")).getText());
    }
}