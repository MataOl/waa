package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class KalkulackaPage {
    private WebDriver pageDriver;

    public KalkulackaPage (WebDriver pageDriver){
        this.pageDriver = pageDriver;
    }

    public void enterFirstInput(String textToInput){
        pageDriver.findElement(By.cssSelector("[id = 'firstInput']")).sendKeys(textToInput);
    }

    public void enterSecondInput(String textToInput){
        pageDriver.findElement(By.cssSelector("[id = 'secondInput']")).sendKeys(textToInput);
    }

    public void sumNumbers(){
        pageDriver.findElement(By.id("count")).click();
    }

    public void deductNumbers(){
        pageDriver.findElement(By.id("deduct")).click();
    }

    public void resetCalculator(){
        pageDriver.findElement(By.id("reset")).click();
    }

    public String getResult(){
        return pageDriver.findElement(By.id("result")).getText();
    }

    public WebElement getLatestCalculation(){
        return pageDriver.findElement(By.cssSelector("ul.latest-results li"));
    }

    public List<WebElement> getLatestCalculations(){
        return pageDriver.findElements(By.cssSelector("ul.latest-results li"));
    }
}
