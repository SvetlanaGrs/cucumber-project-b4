package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvitationsPage {
    public InvitationsPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//label[contains(text(),'Recipient')]//following-sibling::input")
    public WebElement recipient;
    @FindBy(xpath = "//span[contains(text(),'Search')]")
    public WebElement searchDropdown;
    @FindBy(xpath = "//label[contains(text(),'Sent')]/../div")
    public WebElement sent;
    @FindBy(xpath = "//span[contains(text(),' Search ')]")
    public WebElement searchButtonEnd;
    @FindBy(xpath = "//p[@class='mb-0 subtitle-1']")
    public WebElement resultMessage;

    public void clickButton(String button){
        switch (button.toLowerCase().trim()){
            case "search dropdown":
                BrowserUtils.waitForClickable(searchDropdown, 10).click();
                break;
            case "sent":
                BrowserUtils.waitForClickable(sent,10).click();
                break;
            case "search":
                BrowserUtils.waitForClickable(searchButtonEnd,10).click();
                break;



            default: throw new IllegalArgumentException("Not such a button: " + button);
        }
    }

    public void insertField(String field, String input){
        switch (field.toLowerCase().trim()){
            case "recipient":
                BrowserUtils.waitForVisibility(recipient,10).sendKeys(input);
                break;



            default: throw new IllegalArgumentException("No such a field: " + field);
        }
    }
}
