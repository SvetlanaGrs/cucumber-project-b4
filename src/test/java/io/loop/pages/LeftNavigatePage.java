package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNavigatePage {
public LeftNavigatePage (){PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//span[.='Received docs']")
    public WebElement receivedDocs;

    @FindBy(xpath = "//span[.='Home']")
    public WebElement homeButton;

    @FindBy(xpath = "//span[.='My uploads']")
    public WebElement myUploads;

    @FindBy(xpath = "//span[.='Invitations']")
    public WebElement invitations;

    @FindBy(xpath = "//a[contains(text(),'Terms')]")
    public WebElement termsAndConditionsButton;

public void clickButton(String button){
    switch (button.toLowerCase().trim()){
        case "received docs":
            BrowserUtils.waitForClickable(receivedDocs,15).click();
            break;
        case "home":
            BrowserUtils.waitForClickable(homeButton,10).click();
            break;
        case "my uploads":
            BrowserUtils.waitForClickable(myUploads,10).click();
            break;
        case "invitations":
            BrowserUtils.waitForClickable(invitations,10).click();
            break;
        case "terms and conditions":
            BrowserUtils.waitForClickable(termsAndConditionsButton,10).click();
            break;
        default: throw new IllegalArgumentException("Not such a button: " + button);
    }
}
}
