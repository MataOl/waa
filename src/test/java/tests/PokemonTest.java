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
import org.openqa.selenium.support.ui.Select;
import pages.PokemonPage;

public class PokemonTest extends TestBase {
    PokemonPage pokPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "vybersi.php");
        pokPage = new PokemonPage(driver);
    }

    @Test
    public void itshouldSelectPokemons() {
        String[] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander", "Diglett", "Geodude"};
//        najdem element select
        for (String pokemon : selectedPokemons) {
//            vyberiem pokemona
            pokPage.selectPokemon(pokemon);
//            overim hlasku
            Assert.assertEquals(getExpectedMessage(pokemon), pokPage.getActualMessage());
        }
    }


    private String getExpectedMessage(String pokemonName) {
        return String.format("I choose you %s !", pokemonName);
    }
}
