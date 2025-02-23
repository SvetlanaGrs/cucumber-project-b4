package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.DocuportConstance;
import io.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement continueButton;

    public  void login(WebDriver driver, String role) throws InterruptedException {
        switch (role.toLowerCase()){
            case "client":
                usernameInput.sendKeys(DocuportConstance.USERNAME_CLIENT);
                passwordInput.sendKeys(DocuportConstance.PASSWORD);
                break;

            case "supervisor":
                usernameInput.sendKeys(DocuportConstance.USERNAME_SUPERVISOR);
                passwordInput.sendKeys(DocuportConstance.PASSWORD);
                break;

            case "advisor":
                usernameInput.sendKeys(DocuportConstance.USERNAME_ADVISOR);
                passwordInput.sendKeys(DocuportConstance.PASSWORD);
                break;

            case "employee":
                usernameInput.sendKeys(DocuportConstance.USERNAME_EMPLOYEE);
                passwordInput.sendKeys(DocuportConstance.PASSWORD);
                break;

            default: throw new InterruptedException("There is not such a role: " + role);

        }

        loginButton.click();
        if(role.toLowerCase().equals("client")){
            Thread.sleep(3000);
            WebElement con = driver.findElement(By.xpath("//button[@type='submit']"));
            con.click();
            Thread.sleep(3000);
        }

    }


    public void login2 (String username, String password){
        BrowserUtils.waitForClickable(loginButton, 10);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        if (BrowserUtils.waitForVisibility(continueButton,10).isDisplayed()) {
            continueButton.click();
        }
    }
}
