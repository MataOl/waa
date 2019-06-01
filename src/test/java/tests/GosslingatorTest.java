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
import pages.GosslingatorPage;

public class GosslingatorTest extends TestBase {

    private GosslingatorPage gossPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "gosslingator.php");
        gossPage = new GosslingatorPage(driver);
    }

    @Test
// TEST PRIDANIE 1 RYANA A OVERENIE TEXTU V POCITADLE RYANOV ("1","RYAN")
    public void itShoulAddOneRyan() {
        gossPage.addRyan();
//        overit pocitanie ryanov
        Assert.assertEquals("1", gossPage.getRyanCounterNumber());
    }

    @Test
// TEST PRIDANIE 2 RYANOV A OVERENIE TEXTU V POCITADLE RYANOV ("2","RYANS")
    public void itShoulAddTwoRyans() {
        gossPage.addRyan();
        gossPage.addRyan();

//      overit pocitanie ryanov
        Assert.assertEquals("2", gossPage.getRyanCounterNumber());

//      overit ze je tam text ryans
        Assert.assertEquals("ryans", gossPage.getCounterDescription());
    }

    @Test
// TEST OVERENIE NADPISU "GOSLINGATE ME"
    public void itShoulDisplayTitle() {
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
    }

    @Test
// TEST 50xKLIK NA RYANA A OVERENIE HLASKY "NUMBER OF RYANS IS TOO DAMN HIGH"
    public void itShoulDisplayWarningMessage() {
        for (int i = 0; i < 50; i++) {
            gossPage.addRyan();
            Assert.assertEquals(String.valueOf(i + 1), gossPage.getRyanCounterNumber());

//            overit sklonovanie pomocou podmienky

            if (i + 1 == 1) {
                Assert.assertEquals("ryan", gossPage.getCounterDescription());
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", gossPage.getCounterDescription());
            }
//            overim pocet obrazkov ryana
            Assert.assertEquals(i + 1, gossPage.getNumberOfRyanImages());

            System.out.println("index i = " + i);

            System.out.println("pocet ryanov = " + gossPage.getRyanCounterNumber());
        }

        //alt+J oznacenie kazdeho dalsieho vyskytu, ked som na prvom vyskyte nastavena modrym

        Assert.assertEquals("NUMBER OF\n" +
                "RYANS\n" +
                "IS TOO DAMN\n" +
                "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
    }

    @Test
    public void itShouldDisplayWarningMessageUsingWhileCycle() {
        int clicksLimit = 30;
        int clicks = 0;
        while (!gossPage.getRyanCounterNumber().equals("50") && clicks < clicksLimit) {
            gossPage.addRyan();
            clicks++;
        }
    }

    @Test
    public void itShouldDisplayNoRyanOnPageOpen() {
        Assert.assertEquals(0, gossPage.getNumberOfRyanImages());
    }
}
