package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConchitaPage {
    private WebDriver pageDriver;

    public ConchitaPage(WebDriver driver){
        this.pageDriver = driver;
    }

    public WebElement getMaleCheckbox() {
        return pageDriver.findElement(By.cssSelector("[value='wurst']"));
    }

    public WebElement getWomanCheckbox() {
        return pageDriver.findElement(By.cssSelector("[value='conchita']"));
    }

    public WebElement getActualMessage() {
        return pageDriver.findElement(By.cssSelector("h1.description"));
    }

    public WebElement getConchitaPicture() {
        return pageDriver.findElement(By.cssSelector("[src='img/conchita.jpg']"));
    }
}
