package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FellowshipPage {
    WebDriver pageDriver;

    public FellowshipPage(WebDriver driver) {
        this.pageDriver = driver;
    }


    public List<WebElement> returnAllFellows() {
        return pageDriver.findElements(By.cssSelector("ul.list-of-fellows li"));
    }

    public void clickSelectedFellow(String Fellow) {
        pageDriver.findElement(By.xpath("//h1[contains(text(),'" + Fellow + "')]")).click();
    }
}
