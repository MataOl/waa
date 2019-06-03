package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SavingsPage {
    WebDriver pageDriver;

    public SavingsPage (WebDriver driver){
        this.pageDriver = driver;
    }

    public void enterNextData(String sum, String years, String email){
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(sum);
        pageDriver.findElement(By.id("yearsInput")).sendKeys(years);
        pageDriver.findElement(By.id("emailInput")).sendKeys(email);
    }

    public WebElement getSavingsButton (){
        return pageDriver.findElement(By.xpath("//button[contains(text(),'Apply for saving')]"));
    }

    public WebElement getLastNote(){
        return pageDriver.findElement(By.cssSelector("ul.saving-list li:last-child"));
    }

    public String getFirstSum(){
        return pageDriver.findElement(By.xpath("//div/div[1]/p")).getText();
    }

    public String getSecondSum(){
        return pageDriver.findElement(By.xpath("//div/div[2]/p")).getText();
    }

    public String getTextOfRisk (){
        return pageDriver.findElement(By.xpath("//div/div[3]/p")).getText();
    }
}
