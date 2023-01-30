package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import static utilities.ReusableMethods.*;


public class amazonTest {
    AmazonPage amazonPage = new AmazonPage();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void before(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }
    @AfterMethod
    public void after(){
        waits(1);
        Driver.quitDriver();
    }
    @Test
    public void test01(){
        WebElement ddn = amazonPage.dropdown;
        Select select = new Select(ddn);
        select.selectByVisibleText("Electronics");
        amazonPage.searchBox.sendKeys("Samsung"+Keys.ENTER);

        ((JavascriptExecutor) Driver.getDriver()).
                executeScript("arguments[0].scrollIntoView(true);", amazonPage.urun4);

        JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
        executor.executeScript("arguments[0].click();", amazonPage.urun4);

        Assert.assertTrue(amazonPage.urunTitle.getText().contains("SAMSUNG"));

    }
}
