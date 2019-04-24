package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {

    @Test
    public void itShoulAddOneRyan() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        0.spustit prehliadac
        WebDriver driver = new ChromeDriver();
//        WebDriver je typ zadef. v seleniu

//      1.otvorit stranku
        driver.get("http://localhost/gosslingator.php");
//        2.kliknut na tlacidlo pridat
        driver.findElement(By.id("addRyan")).click();
//        3.overit pocitanie ryanov
        Assert.assertEquals("1", driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
//vypisem si do konzoly aktualny pocet z pocitadla ryanov
        System.out.println("Number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryan", driver.findElement(By.cssSelector("div.ryan-counter h3")).getText());

//        4.zatvorit prehliadac
        driver.close();
//        5.ukoncit session
        driver.quit();
    }

    @Test
    public void itShouldOpenWebpage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.martinus.sk/");
    }

    @Test
    public void itShoulDisplayTitle() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        0.spustit prehliadac
        WebDriver driver = new ChromeDriver();
//        WebDriver je typ zadef. v seleniu

//      1.otvorit stranku
        driver.get("http://localhost/gosslingator.php");

        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
//        5.ukoncit session
        driver.quit();
    }

    @Test
    public void itShoulDisplayWrongNotice() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        0.spustit prehliadac
        WebDriver driver = new ChromeDriver();
//        WebDriver je typ zadef. v seleniu

//      1.otvorit stranku
        driver.get("http://localhost/gosslingator.php");
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();

        System.out.println(driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
        Assert.assertEquals(
                "NUMBER OF\n" +
                "RYANS\n" +
                "IS TOO DAMN\n" +
                "HIGH",
                driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
//        5.ukoncit session
        driver.quit();
    }

}
