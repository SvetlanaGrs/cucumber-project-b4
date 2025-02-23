package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.loop.pages.POM;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProductSteps {
    POM pages=new POM();
    private static final Logger LOG = LogManager.getLogger();

    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("product.url"));
       // Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LOG.info("User is on HomePage");
    }
    @Then("User should be able to see expected prices in the following product")
    public void user_should_be_able_to_see_expected_prices_in_the_following_product(List<Map<String,String>> productDetails) {
        for (Map<String, String> productDetail : productDetails) {
//            System.out.println("========Product Details========");
//            System.out.println("productDetail.get(\"Category\") = " + productDetail.get("Category"));
//            System.out.println("productDetail.get(\"Product\") = " + productDetail.get("Product"));
//            System.out.println("productDetail.get(\"expectedPrice\") = " + productDetail.get("expectedPrice"));

            //click the category
            pages.getProductPage().clickCategory(productDetail.get("Category"));

            //get actual price first
            String actualPrice = pages.getProductPage().getProductPrice(productDetail.get("Product"));

            //get product price from my datatable
            String expectedPrice = productDetail.get("expectedPrice");
            assertEquals("Actual price does not match with actual", expectedPrice,actualPrice);

            LOG.info("Validation of the price for: " + productDetail.get("Category") + " ,for Product: " + productDetail.get("Product") + "Expected: " + expectedPrice + " - actual: " + actualPrice);
        }

    }

    @Then("User should be able to see expected prices in the following products with listOfLists")
    public void user_should_be_able_to_see_expected_prices_in_the_following_products_with_list_of_lists(List<List<String>> productDetails) {
        for (List<String> productDetail : productDetails) {
            //get category
            pages.getProductPage().clickCategory(productDetail.get(0));

            //get actual price for each product i have
            String actualPrice = pages.getProductPage().getProductPrice(productDetail.get(1));

            //get expected price from feature
            String expectedPrice = productDetail.get(2);

            assertEquals("Expected does not match the actual", expectedPrice, actualPrice);
            LOG.info("Validation of the price for: " + productDetail.get(0) + ", for product: " + productDetail.get(1) + " expected price: " + expectedPrice + " - actual price: "+ actualPrice);
        }
    }

    @Then("user should be able to see the following names in their groups")
    public void user_should_be_able_to_see_the_following_names_in_their_groups(Map<String,List<String>> students) {
       List<String> group1 = students.get("Group 1");
        System.out.println("Group 1 = " + group1);

        List<String> group2 = students.get("Group 2");
        System.out.println("Group 2 = " + group2);
    }
}
