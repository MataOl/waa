package pages;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

import static io.codearte.jfairy.producer.person.PersonProperties.*;

public class RegistrationPage {

    @FindBy(name = "robot")
    WebElement robotBtn;

    @FindBy(css = "button.btn.btn-success")
    WebElement registrujSaBtn;

    private WebDriver pageDriver;

    public RegistrationPage (WebDriver driver){
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver, this);
    }

    public void sendRegistrationData() {
// ta fairy by tam nemala byt podla Furbyho
        Fairy fairy = Fairy.create(Locale.GERMAN);
        Person person = fairy.person(minAge(18), maxAge(30), male());

        pageDriver.findElement(By.name("email")).sendKeys(person.getEmail());
        pageDriver.findElement(By.name("name")).sendKeys(person.getFirstName());
        pageDriver.findElement(By.name("surname")).sendKeys(person.getLastName());
        pageDriver.findElement(By.name("password")).sendKeys(person.getPassword());
        pageDriver.findElement(By.name("password-repeat")).sendKeys(person.getPassword());
    }
    public void clickRobotBtn() {
        robotBtn.click();
    }

    public void clickRegistrujSa() {
        registrujSaBtn.click();
    }
    public WebElement getSuccessMessage() {
        return pageDriver.findElement(By.cssSelector("div.alert-success"));
    }

    public WebElement getErrorMessage() {
        return pageDriver.findElement(By.cssSelector("div.alert-danger"));
    }
}
