package tests;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ConchitaPage;

public class ConchitaTest extends TestBase {
    private ConchitaPage conchitaPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "zenaalebomuz.php");
        conchitaPage = new ConchitaPage(driver);
    }

    @Test
//    TEST, ZE PO OTVORENI STRANKY NIE JE VYBRATA ANI JEDNA MOZNOST
    public void noOptionShouldBeSelected() {
        Assert.assertFalse(conchitaPage.getMaleCheckbox().isSelected());
        Assert.assertFalse(conchitaPage.getWomanCheckbox().isSelected());
    }

    @Test
//    TEST, ZE PO KLIKNUTI NA MUZ SA ZOBRAZI HLASKA IT'S WURST
    public void itShouldSelectMale() {
        conchitaPage.getMaleCheckbox().click();
        Assert.assertTrue(conchitaPage.getActualMessage().isDisplayed());
        Assert.assertEquals("It's wurst", conchitaPage.getActualMessage().getText());
    }

    @Test
//    TEST, ZE PO KLIKNUTI NA MUZ NIE JE MOZNOST ZENA VYBRATA
    public void clickMuzZenaNotSelected() {
        conchitaPage.getMaleCheckbox().click();
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Zena']")).isSelected());
    }

    @Test
//    TEST ZE SA PO OTVORENI STRANKY ZOBRAZI OBRAZOK
    public void checkImageIsDisplayed() {
        Assert.assertTrue(conchitaPage.getConchitaPicture().isDisplayed());
    }
}