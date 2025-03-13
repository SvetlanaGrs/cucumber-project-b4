package io.loop.pages;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class MyUploadsPage {
    public MyUploadsPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[contains(text(),'Upload file')]/../..")
    public WebElement uploadFile;

    @FindBy(xpath = "//span[contains(text(),'Upload documents')]/../..")
    public WebElement uploadDocuments;

    @FindBy (xpath = "//span[contains(text(),' Upload ')]")
    public WebElement upload;

    @FindBy (xpath = "//span[contains(text(),'Search')]")
    public WebElement searchDropdown;

    @FindBy (xpath = "//p[@class='mb-0 subtitle-1']")
    public WebElement resultMessage;

    public void clickButton(String button) throws AWTException {
        switch (button.toLowerCase().trim()){
            case "upload documents":
                BrowserUtils.waitForClickable(uploadDocuments, 10).click();
                break;
            case "upload":
                BrowserUtils.waitForClickable(upload,10).click();
                break;
            case "search dropdown":
                BrowserUtils.waitForClickable(searchDropdown,10).click();
                break;
            case "upload file":
                BrowserUtils.waitForClickable(uploadFile,10).click();
                BrowserUtils.uploadFile("\"C:\\Users\\advok\\OneDrive\\Desktop\\example.txt\"");
                break;
            default: throw new IllegalArgumentException("Not such a button: " + button);
        }
    }
    public void insertField(String field, String input)  {
        switch (field.toLowerCase().trim()){
            case "upload file":
                WebElement element=Driver.getDriver().findElement(By.xpath("//input[@type='file']"));
                element.sendKeys(input);
                break;
            default: throw new IllegalArgumentException("No such a field: " + field);
        }
    }
}
