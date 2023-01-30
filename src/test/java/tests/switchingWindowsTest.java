package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import static utilities.ReusableMethods.*;

public class switchingWindowsTest {

    @Test
    public void test01(){
        waits(2);


        Driver.getDriver().get(ConfigReader.getProperty("herokuApp"));
        Driver.getDriver().findElement(By.linkText("Elemental Selenium")).click();

        ReusableMethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");


        String expectedYazi="Elemental Selenium";
        String actualYazi= Driver.getDriver().findElement(By.tagName("h1")).getText();

        Assert.assertEquals(actualYazi,expectedYazi);

        Driver.quitDriver();
    }
}
