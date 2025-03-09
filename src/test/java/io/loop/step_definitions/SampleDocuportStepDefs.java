package io.loop.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.LeftNavigatePage;
import io.loop.pages.LoginPage;
import io.loop.pages.POM;
import io.loop.pages.ReceivedDocsPage;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class SampleDocuportStepDefs {
    LoginPage loginPage=new LoginPage();
    LeftNavigatePage leftNavigatePage=new LeftNavigatePage();
    ReceivedDocsPage receivedDocsPage=new ReceivedDocsPage();
    private static final Logger LOG = LogManager.getLogger();
    POM pages=new POM();

    @When("user inserts {string} to {string} field on {string} page")
    public void user_inserts_to_field_on_page(String input, String field, String page)  {
        switch (page.toLowerCase().trim()){
            case "login":
                loginPage.insertField(field,input);
                LOG.info(input + " - was successfully sent to - "+ field);
                break;
            case "received doc":
                receivedDocsPage.insertField(field,input);
                LOG.info(input + " - was successfully sent to - "+ field);
                break;
            case "my uploads":
                pages.getMyUploadsPage().insertField(field,input);
                LOG.info(input + " - was successfully sent to - "+ field);
                break;
            case "invitations":
                pages.getInvitationsPage().insertField(field,input);
                LOG.info(input + " - was successfully sent to - "+ field);
                break;
            default: throw new IllegalArgumentException("Not such a page: " + page);

        }
    }
    @When("user clicks {string} button on {string} page")
    public void user_clicks_button_on_page(String button, String page) throws InterruptedException {
        switch (page.toLowerCase().trim()){
            case "login", "choose account":
                loginPage.clickButton(button);
                LOG.info(button+ " - was successfully clicked");
                break;
            case "left navigate":
                leftNavigatePage.clickButton(button);
                Thread.sleep(5000);
                LOG.info(button+ " - was successfully clicked");
                break;
            case "received docs":
               receivedDocsPage.clickButton(button);
                LOG.info(button+ " - was successfully clicked");
                break;
            case "my uploads":
               pages.getMyUploadsPage().clickButton(button);
                LOG.info(button+ " - was successfully clicked");
                break;
            case "invitations":
                pages.getInvitationsPage().clickButton(button);
                LOG.info(button+ " - was successfully clicked");
                break;

            default: throw new IllegalArgumentException("Not such a page: " + page);
            //case "login", "choose account" -> loginPage.clickButton(button);
        }
    }

    @Then("user should see {string} message on {string} page")
    public void user_should_see_message(String finalMessage,String page) {
        switch (page.toLowerCase().trim()){
            case "received doc":
                Assert.assertEquals("Expected message not match with actual",finalMessage,receivedDocsPage.resultMessage.getText());
                LOG.info("Actual info match with expected");
                break;
            case "my uploads":
                Assert.assertEquals("Expected message not match with actual",finalMessage,pages.getMyUploadsPage().resultMessage.getText());
                LOG.info("Actual info match with expected");
                break;
            case "invitations":
                Assert.assertEquals("Expected message not match with actual",finalMessage,pages.getInvitationsPage().resultMessage.getText());
                LOG.info("Actual info match with expected");
                break;
            case "terms and conditions":
                Assert.assertEquals("Expected message not match with actual",finalMessage, pages.getTermsAndConditionsPage().serviceTermsAndConditionsHeader.getText());
                LOG.info("Actual info match with expected");
                break;
        }
    }

    @Then("validate that new tab opens")
    public void validate_that_new_tab_opens() {
        String expectedUrl="https://numbersquad.com/service-terms-and-conditions";
        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        Set<String> windowHandles=Driver.getDriver().getWindowHandles();
        for (String eachWindowHandle:windowHandles){
            if(!eachWindowHandle.equals(mainWindowHandle)){
                Driver.getDriver().switchTo().window(eachWindowHandle);
                break;
            }
        }
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals("Actual title does not match with expected",expectedUrl,actualUrl);
        LOG.info("Actual title match with expected");
    }
}
