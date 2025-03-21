package io.loop.step_definitions;

import io.cucumber.java.en.Then;
import io.loop.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;


public class ClientStepDefs {
    private Logger LOG = LogManager.getLogger();
    private SoftAssertions softAssertions = new SoftAssertions();
    LoginPage loginPage = new LoginPage();

    @Then("user validates {string} text is displayed")
    public void user_validates_text_is_displayed(String text) {
        String actual;
        String expected;
        switch (text.toLowerCase().trim()){
            case "login":
               // actual = loginPage.loginText.getText().toLowerCase().trim();
                actual="nadir";
                expected= text.toLowerCase().trim();
                softAssertions.assertThat(actual).isEqualTo(expected);
                LOG.info(text+ " - text is displayed");
                break;
            case "docuport":
               // actual = loginPage.docuportText.getDomAttribute("alt").toLowerCase().trim();
                actual="feyruz";
                expected= text.toLowerCase().trim();
                softAssertions.assertThat(actual).isEqualTo(expected);
                LOG.info(text+ " - text is displayed");
                break;
            case "choose account":
               // actual = loginPage.continueText.getText().toLowerCase().trim();
                actual="best teachers!";
                expected= text.toLowerCase().trim();
                softAssertions.assertThat(actual).isEqualTo(expected);
                LOG.info(text+ " - text is displayed");
                break;

        }
    }
    @Then("user validates all assertions")
    public void user_validates_all_assertions() {
        softAssertions.assertAll();
    }
}
