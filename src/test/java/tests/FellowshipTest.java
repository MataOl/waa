package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FellowshipPage;

import java.util.ArrayList;
import java.util.List;

public class FellowshipTest extends TestBase {
    private FellowshipPage fellowPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "fellowship.php");
        fellowPage = new FellowshipPage(driver);
    }

    @Test
    public void itShouldContainNameForEachFellow() {
        List<WebElement> fellowElements = fellowPage.returnAllFellows();
        for (WebElement fellowElement : fellowElements) {
            Assert.assertFalse(fellowElement.findElement(By.cssSelector("h1")).getText().isEmpty());
            System.out.println(fellowElement.findElement(By.cssSelector("h1")).getText());
        }
    }

    @Test
    public void itShouldContainSpecifiedFellows() {
        List<WebElement> fellowElements = fellowPage.returnAllFellows();
//        predpripravim si zoznam stringov do ktoreho si ulozim jedn. mena
        List<String> fellowNames = new ArrayList<String>();
//      prejdem zoznam elementov, kachliciek
        for (WebElement fellowElement : fellowElements) {
            System.out.println(fellowElement.findElement(By.cssSelector("h1")).getText());
//      v ramci kazdej kachlicky si najdem meno a to ulozim do zoznamu mien
            fellowNames.add(fellowElement.findElement(By.cssSelector("h1")).getText());
            System.out.println(fellowNames);
        }
//      over ze list obsahuje Gandalfa, Aragona a Froda
        Assert.assertTrue(fellowNames.contains("Gandalf"));
        Assert.assertTrue(fellowNames.contains("Aragorn"));
        Assert.assertTrue(fellowNames.contains("Frodo"));

    }

    @Test
    public void itShoulCheckInitialPoints25() {
        String initialPoints = driver.findElement(By.cssSelector("div.points-left h2")).getText();
        Assert.assertEquals("25", initialPoints);
    }

    @Test
    public void itShouldContainPointsForEachFellow() {
        List<WebElement> fellowElements = fellowPage.returnAllFellows();
        for (WebElement fellowElement : fellowElements) {
            Assert.assertFalse(fellowElement.findElement(By.cssSelector("div.fellow-points h2")).getText().isEmpty());
            System.out.println(fellowElement.findElement(By.cssSelector("div.fellow-points h2")).getText());
        }
    }
    @Test
//    1. uloha z DU sposob aky ukazal Martin
    public void itShouldDisplayMessageComplete () {
        List<String> fellowsToSelect = new ArrayList<String>();
        fellowsToSelect.add("Gandalf");
        fellowsToSelect.add("Aragorn");
        fellowsToSelect.add("Legolas");
        fellowsToSelect.add("Frodo");

        for (String fellowToSelect : fellowsToSelect) {
            fellowPage.clickSelectedFellow(fellowToSelect);
        }
        Assert.assertEquals("Complete", driver.findElement(By.cssSelector("div.points-left h3")).getText());
    }
}


