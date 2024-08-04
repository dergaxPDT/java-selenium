package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCardStepDefinitions {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Given("I am on the OpenCart main page")
    public void i_am_on_the_open_cart_main_page() {
        driver.get("https://www.t-mobile.pl/");
        mainPage = new MainPage(driver);

    }

    @When("I have added first smartwatch to card")
    public void i_have_added_first_smart_watch_to_card() {
        mainPage
                .openTopMenu()
                .chooseSmartWatchWithoutContract()
                .chooseFirstSmartWatch()
                .addToCard()
                .backToMainPage();
    }

    @Then("I should check the values of Smartwatch")
    public void i_should_check_the_values_of_Smartwatch() {
        Assert.assertEquals(SummaryCardPage.priceOnStart, SmartWatchInfoPage.priceOnStart);
        Assert.assertEquals(SummaryCardPage.monthlyInstallment, SmartWatchInfoPage.monthlyInstallment);
    }
}

