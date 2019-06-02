package tests;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RandomTableTest extends TestBase {

    @Before
    public void openPage() {
        driver.get(BASE_URL + "tabulka.php");
    }


    @Test
    public void itShoulFindInTable() {

//2.vytlacit udaje z posledneho zobrazeneho riadku
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()]")).getText());
//3.vytlacit udaj z predposledneho zobrazeneho riadku v druhom stlpci
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[2]")).getText());
    }

    @Test
    public void itShouldContainDataForEachRow() {
        for (WebElement tableRow : getTableRows()) {
            Assert.assertFalse(tableRow.getText().isEmpty());
            System.out.println(tableRow.getText());
        }
    }

    @Test
    public void itShoulContainNameForEachRow() {
        List<WebElement> tableRows = getTableRows();
        for (WebElement tableRow : tableRows) {
            Assert.assertFalse(tableRow.getText().isEmpty());
            System.out.println(tableRow.getText());
//            tableRow.findElement(By.cssSelector("td:nth-child(2)"));
            WebElement rowName = tableRow.findElement(By.xpath("./td[2]"));
            Assert.assertFalse(rowName.getText().isEmpty());
        }
    }

    private List<WebElement> getTableRows (){
        return driver.findElements(By.cssSelector("table tbody tr"));
    }
}

