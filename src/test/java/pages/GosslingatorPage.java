package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GosslingatorPage {
    @FindBy(id = "addRyan")
    WebElement addRyanBtn;

    @FindBy(css = "div.ryan-counter h3")
    WebElement ryanDescription;

    private WebDriver pageDriver;

    //vytvorim novy konstruktor (= cele tieto 3 riadky)
    public GosslingatorPage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver, this);
    }

    public void addRyan() {
        addRyanBtn.click();
    }

    public String getRyanCounterNumber() {
        return pageDriver.findElement(By.id("ryanCounter")).getText();
    }

    public String getCounterDescription() {
        return ryanDescription.getText();
    }

    public int getNumberOfRyanImages() {
        return pageDriver.findElements(By.cssSelector("img")).size();
    }
}
