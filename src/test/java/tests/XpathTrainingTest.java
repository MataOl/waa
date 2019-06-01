package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class XpathTrainingTest extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "xpathtrainingcenter.php");
    }


    @Test
//    TEST KLIKNUTIE NA ONE MORE BUTTON A OVERENIE TEXTU V HLASKE
    public void itShouldDisplayAction() {
        String buttonText = "One more button";
        driver.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]")).click();
        String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();
        Assert.assertEquals("you clicked " + buttonText.toLowerCase(), actualMessage);
    }

    @Test
//    TEST VPISANIE TEXTU DO 3.OKNA, KLIK 'HIT ME!' BUTTON A OVERENIE ZOBRAZENEHO TEXTU
    public void itShouldDisplayEnteredMessage() {
        String message = "vonku prsi";
        driver.findElement(By.cssSelector("input")).sendKeys(message);
        driver.findElement(By.cssSelector("#hitme")).click();
        String actualMessage = driver.findElement(By.xpath("//h2/span")).getText();
        Assert.assertEquals("you entered " + message, actualMessage);
    }

    @Test
    public void itshouldSelectButtons() {
//        Moj postup, Furby ukazoval ine riesenie
        List<WebElement> selectedButtons = driver.findElements(By.cssSelector("div.useless button"));
        for (WebElement selectedButton : selectedButtons) {
            selectedButton.click();
            String actualMessage = driver.findElement(By.cssSelector("h2 span")).getText();
            Assert.assertEquals("you clicked " + selectedButton.getText().toLowerCase(), actualMessage);
        }
    }

    @Test
    public void itshouldSelectMoznost() {
        String[] selectedMoznosti = {"Moznost 1", "Moznost 2", "Moznost 3", "Moznost 4", "Moznost 5", "Moznost 6"};
//        najdem element select
        WebElement moznostSelect = driver.findElement(By.cssSelector("select.form-control"));
        for (String moznost : selectedMoznosti) {
//            vyberiem moznost
            new Select(moznostSelect).selectByVisibleText(moznost);
//            overim hlasku
            String actualMessage = driver.findElement(By.xpath("//h2/span")).getText();
            String expectedMessage = "you have chosen " + moznost.toLowerCase();
            String expectedMessageByFormat = String.format("you have chosen %s", moznost.toLowerCase());
            Assert.assertEquals(expectedMessageByFormat, actualMessage);
        }
    }

    @Test
    public void itshouldSelectOption() {
        String[] selectedOptions = {"Option 1", "Option 2", "Option 3", "Option 4", "Option 5", "Option 6"};
//        najdem element select
        WebElement optionSelect = driver.findElement(By.cssSelector("select.form-control.second-select"));
        for (String option : selectedOptions) {
//            vyberiem moznost
            new Select(optionSelect).selectByVisibleText(option);
//            overim hlasku
            String actualMessage = driver.findElement(By.xpath("//h2/span")).getText();
            String expectedMessage = "you have chosen " + option.toLowerCase();
            String expectedMessageByFormat = String.format("you have chosen %s", option.toLowerCase());
            Assert.assertEquals(expectedMessageByFormat, actualMessage);
        }
    }

    @Test
    public void itShouldClickAllButtons() {
// sposob aky potom ukazoval Furby
        String[] selectedButtons = {"First one", "Second button", "Next button", "One more button", "Danger", "Success", "Warning"};

        for (String button : selectedButtons) {
            itShouldClickButton(button);
            String expectedMessage = "you clicked " + button.toLowerCase();
            Assert.assertEquals(expectedMessage, actualMessage());
        }
    }


    private void itShouldClickButton(String butt) {
        driver.findElement(By.xpath("//button[contains(text(), '" + butt + "')]")).click();
    }

    private String actualMessage() {
        return driver.findElement(By.cssSelector("div.output h2 span")).getText();
    }

}