package tests;

import base.TestBase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegistrationPage;

import java.util.Locale;

import static io.codearte.jfairy.Fairy.*;
import static io.codearte.jfairy.producer.person.PersonProperties.*;

public class RegistrationTest extends TestBase {
   private RegistrationPage regPage;

    @Before
    public void openPage() {
        driver.get(BASE_URL + "registracia.php");
        regPage = new RegistrationPage(driver);
    }

    @Test
//    USPESNA REGISTRACIA
    public void itShouldRegisterValidUser() {


        regPage.sendRegistrationData();
        regPage.clickRobotBtn();
        regPage.clickRegistrujSa();
        Assert.assertTrue(regPage.getSuccessMessage().isDisplayed());
    }

    @Test
//    NEUSPESNA REGISTRACIA
    public void itShouldDisplayErrorMessageWhenInputsAreEmpty() {

        regPage.clickRobotBtn();
        regPage.clickRegistrujSa();
        Assert.assertTrue(regPage.getErrorMessage().isDisplayed());
    }
}
