package pages;

import models.Note;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotePage {
    @FindBy(name = "title")
    private WebElement title1;

    @FindBy(name = "author")
    private WebElement author1;

    @FindBy(name = "message")
    private
    WebElement message1;

    private WebDriver pageDriver;

    public NotePage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver,this);
    }

    public void enterNoteData(Note note) {

        title1.sendKeys(note.getTitle());

        author1.sendKeys(note.getAuthor());

        message1.sendKeys(note.getMessage());
    }


    public void submitNewNote() {

        pageDriver.findElement(By.cssSelector("button.btn-block")).click();

    }


    public WebElement getLastNoteFromList() {

        return pageDriver.findElement(By.cssSelector("ul.list-of-sins > li:last-child"));

    }


    public void checkNoteDetail(Note note) {

        WebElement detail = pageDriver.findElement(By.cssSelector("div.content"));

        Assert.assertEquals(note.getTitle(), detail.findElement(By.cssSelector("h4.title")).getText());

        Assert.assertEquals(note.getAuthor(), detail.findElement(By.cssSelector("h4.recipent")).getText());

        Assert.assertEquals(note.getMessage(), detail.findElement(By.cssSelector("p")).getText());

    }


    public void checkNoteInList(String title) {

        WebElement listItem = getLastNoteFromList();

        Assert.assertTrue(listItem.getText().contains(title));

        Assert.assertTrue(listItem.findElement(By.cssSelector("div.description a")).isDisplayed());

        Assert.assertEquals("detail", listItem.findElement(By.cssSelector("div.description a")).getText());

    }
}
