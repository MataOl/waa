package tests;


import java.sql.Timestamp;


import models.Note;
import org.junit.Assert;

import org.junit.Before;

import org.junit.Test;

import org.openqa.selenium.By;


import base.TestBase;

import io.codearte.jfairy.Fairy;

import io.codearte.jfairy.producer.person.Person;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.NotePage;


public class NoteTest extends TestBase {
    private NotePage notePage;

    @Before

    public void openPage() {

        driver.get(BASE_URL + "odkazovac.php");
        notePage = new NotePage(driver);
    }


    @Test

    public void itShouldAddNote(){


        Fairy fairy = Fairy.create();

        Person fakePerson = fairy.person();


        String title = generateUniqueTitle();

//        String author = fakePerson.getFirstName() + " " + fakePerson.getLastName();
        String author = "Anton";

        String message = "toto je velmi dlhy a zmysluplny odkaz";



        Note noteToAdd = new Note(title, author, message);



        notePage.enterNoteData(noteToAdd);

        notePage.submitNewNote();

        notePage.checkNoteInList(noteToAdd.getTitle());

        notePage.getLastNoteFromList().click();

        new WebDriverWait(driver,10).
                until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.content")));

        notePage.checkNoteDetail(noteToAdd);

    }


    @Test

    public void itShouldAddNoteWithHashtags(){


        Fairy fairy = Fairy.create();

        Person fakePerson = fairy.person();


        String title = generateUniqueTitle();

        String author = fakePerson.getFirstName() + " " + fakePerson.getLastName();

        String message = "toto je velmi dlhy a zmysluplny odkaz";

        Note noteToAdd = new Note(title, author, message);

        notePage.enterNoteData(noteToAdd);
        driver.findElement(By.cssSelector("[value='sport']")).click();
        driver.findElement(By.cssSelector("[value='praca']")).click();

        notePage.submitNewNote();

        notePage.checkNoteInList(noteToAdd.getTitle());

        notePage.getLastNoteFromList().click();


        new WebDriverWait(driver,10).
          until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.content")));

        notePage.checkNoteDetail(noteToAdd);
        Assert.assertEquals("#sport", driver.findElement(By.cssSelector("div.tags ul > li:nth-child(1)")).getText());
        Assert.assertEquals("#praca", driver.findElement(By.cssSelector("div.tags ul > li:nth-child(2)")).getText());

    }

//    tuto metodu sme nedali na NotePage, lebo je to len akoby formatovanie, nijako to nesuvisi s krokmi
        private String generateUniqueTitle() {
            //vytvorim si casovu peciatku pre unikatnost title
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            return "Title " + timestamp.getTime();
        }
    }



