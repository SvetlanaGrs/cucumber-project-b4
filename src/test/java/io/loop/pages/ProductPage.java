package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductPage {
    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void clickCategory(String category){
        Driver.getDriver().findElement(By.xpath("//a[contains(., '"+ category+"')]")).click();

    }

    public String getProductPrice (String product){
        try{
            String actualPrice = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'"+ product+"')]/../following-sibling::h5")).getText();
            return actualPrice.substring(1);
        }catch (StaleElementReferenceException s ) {
            String actualPrice = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'"+ product+"')]/../following-sibling::h5")).getText();
            return actualPrice.substring(1);
        }

    }
}
