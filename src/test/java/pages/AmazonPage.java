package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="twotabsearchtextbox" )
    public WebElement searchBox;
    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement searchResultElement;

    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    public WebElement dropdown;

    @FindBy(xpath = "(//*[@class='a-size-medium a-color-base a-text-normal'])[1]")
    public WebElement urun1;

    @FindBy(xpath = "(//*[@class='a-size-medium a-color-base a-text-normal'])[4]")
    public WebElement urun4;

    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement urunTitle;
}
