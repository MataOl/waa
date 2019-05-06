package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {
    //POVODNE SME MALI NA ZAC. KAZDEHO TESTU ZADEFINOVANE WebDriver driver = new ChromeDriver();
    WebDriver driver;
    String actualNumberOfRyans;

    //refaktoring kodu
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/gosslingator.php");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        System.out.println("s panom bohom idem od vas");
    }


    @Test
// TEST PRIDANIE 1 RYANA A OVERENIE TEXTU V POCITADLE RYANOV ("1","RYAN")
    public void itShoulAddOneRyan() {
//        kliknut na button addRyan
        WebElement addRyanBtn = driver.findElement(By.id("addRyan"));
        addRyanBtn.click();
        actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        String actualRyanDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
//        overit pocitanie ryanov
        Assert.assertEquals("1", actualNumberOfRyans);
//        vypisem si do konzoly aktualny pocet z pocitadla ryanov
        System.out.println("Number of ryans: " + actualNumberOfRyans);
//        overit ze je tam text ryan
        Assert.assertEquals("ryan", actualRyanDescription);
    }

    @Test
// TEST PRIDANIE 2 RYANOV A OVERENIE TEXTU V POCITADLE RYANOV ("2","RYANS")
    public void itShoulAddTwoRyans() {
        WebElement addRyanBtn = driver.findElement(By.id("addRyan"));
//        2.kliknut na tlacidlo pridat
        addRyanBtn.click();
        addRyanBtn.click();
        actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        String actualRyanDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
//        3.overit pocitanie ryanov
        Assert.assertEquals("2", actualNumberOfRyans);
//        vypisem si do konzoly aktualny pocet z pocitadla ryanov
        System.out.println("Number of ryans: " + actualNumberOfRyans);
//        overit ze je tam text ryans
        Assert.assertEquals("ryans", actualRyanDescription);
    }

    @Test
//  CVICNY TEST OTVORENIE WEBSTRANKY
    public void itShouldOpenWebpage() {
        driver.get("https://www.martinus.sk/");
    }

    @Test
// TEST OVERENIE NADPISU "GOSLINGATE ME"
    public void itShoulDisplayTitle() {
        System.out.println(driver.findElement(By.cssSelector(".ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector(".ryan-title")).getText());
    }

    @Test
// TEST 50xKLIK NA RYANA A OVERENIE HLASKY "NUMBER OF RYANS IS TOO DAMN HIGH"
    public void itShoulDisplayWrongNotice() {

        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        for (int i = 0; i < 50; i++) {
            addRyanButton.click();
            String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans);
//            overit sklonovanie pomocou podmienky

            String actualDescription = driver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", actualDescription);
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", actualDescription);
            }

        }
        //alt+J oznacenie kazdeho dalsieho vyskytu, ked som na prvom vyskyte nastavena modrym

        System.out.println(driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
        Assert.assertEquals("NUMBER OF\n" +
                "RYANS\n" +
                "IS TOO DAMN\n" +
                "HIGH", driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
    }

    @Test
    public void itShouldDisplayWarni
    ngMessageUsingWhileCycle() {
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        int clicksLimit = 30;
        int clicks = 0;
        while (!actualNumberOfRyans.equals("50") && clicks <= clicksLimit){
            addRyanButton.click();
        actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
        clicks++;}
    }
}
