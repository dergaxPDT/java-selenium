package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class MainPage {

    public final WebDriver driver;

    // Locators
    private final By buttonAcceptAllLocator = By.xpath("//*[@id=\"didomi-notice-agree-button\"]/span");
    private final By buttonMenuLocator = By.xpath("//*[@id=\"__next\"]/div/div/header/div/div[2]/div/div/button[2]");


    // Constructor
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public TopMenuPage openTopMenu() {
        WebElement buttonAccept = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS)).until(
                ExpectedConditions.elementToBeClickable(buttonAcceptAllLocator));
        buttonAccept.click();
        WebElement buttonMenu = driver.findElement(buttonMenuLocator);
        buttonMenu.click();
        return new TopMenuPage(driver);
    }

}
