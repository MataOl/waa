package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KalkulackaPage {
    @FindBy(id = "firstInput")
    private WebElement firstInput;

    @FindBy(id = "secondInput")
    private WebElement secondInput;

    @FindBy (id = "count")
    private WebElement countButton;

    @FindBy (id = "deduct")
    private WebElement deductButton;

    @FindBy (id = "reset")
    private WebElement resetButton;

    @FindBy (id = "result")
    private WebElement result;

    private WebDriver pageDriver;

    public KalkulackaPage (WebDriver pageDriver){
        this.pageDriver = pageDriver;
        PageFactory.initElements(pageDriver,this);
    }

    public void enterFirstInput(String textToInput){
        firstInput.sendKeys(textToInput);
    }

    public void enterSecondInput(String textToInput){
        secondInput.sendKeys(textToInput);
    }

    public void sumNumbers(){
        countButton.click();
    }

    public void deductNumbers(){
        deductButton.click();
    }

    public void resetCalculator(){
        resetButton.click();
    }

    public String getResult(){
        return result.getText();
    }

    public WebElement getLatestCalculation(){
        return pageDriver.findElement(By.cssSelector("ul.latest-results li"));
    }

    public List<WebElement> getLatestCalculations(){
        return pageDriver.findElements(By.cssSelector("ul.latest-results li"));
    }

    public WebElement getFirstInput(){
        return firstInput;
    }

    public WebElement getSecondInput(){
        return secondInput;
    }
}
