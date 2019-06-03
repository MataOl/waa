package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavingsPage {
   @FindBy(xpath = "//button[contains(text(),'Apply for saving')]")
   private WebElement savingsButton;

   @FindBy(css = "ul.saving-list li:last-child")
   private WebElement lastNote;

   @FindBy(xpath = "//div/div[1]/p")
   private WebElement firstSum;

    @FindBy(xpath = "//div/div[2]/p")
    private WebElement secondSum;

    @FindBy(xpath = "//div/div[3]/p")
    private WebElement fieldRisk;

    WebDriver pageDriver;

    public SavingsPage (WebDriver driver){
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver,this);
    }

    public void enterNextData(String sum, String years, String email){
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(sum);
        pageDriver.findElement(By.id("yearsInput")).sendKeys(years);
        pageDriver.findElement(By.id("emailInput")).sendKeys(email);
    }

    public WebElement getSavingsButton (){
        return savingsButton;
    }

    public WebElement getLastNote(){
        return lastNote;
    }

    public String getFirstSum(){
        return firstSum.getText();
    }

    public String getSecondSum(){
        return secondSum.getText();
    }

    public String getTextOfRisk (){
        return fieldRisk.getText();
    }
}
