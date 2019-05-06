package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PokemonTest {
    WebDriver driver;

    //refaktoring kodu
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/vybersi.php");
    }

////    @After
//    public void tearDown() {
//        driver.close();
//        driver.quit();
//        System.out.println("s panom bohom idem od vas");
//    }

    @Test
    public void itshouldSelectPokemons(){
        String [] selectedPokemons = {"Pikachu","Bulbasaur","Charmander","Diglett","Geodude"};
//        najdem element select
        WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));
        for (String pokemon : selectedPokemons) {
//            vyberiem pokemona
            new Select(pokemonSelect).selectByVisibleText(pokemon);
//            overim hlasku
            String actualMessage = driver.findElement(By.cssSelector("div.pokemon h3")).getText();
            String expectedMessage = "I choose you " + pokemon + " !";
            String expectedMessageByFormat = String.format("I choose you %s !", pokemon);
            Assert.assertEquals( expectedMessage, actualMessage);
        }
    }
}
