package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ListSmartWatchPage {
    private final WebDriver driver;
    private final By firstSmartWatchLocator = By.xpath("//*[@id=\"osAppInnerContainer\"]/main/div[3]/div/div[1]/div/div[2]/div[2]/div[1]");


    public ListSmartWatchPage(WebDriver driver) {
        this.driver = driver;
    }

    public SmartWatchInfoPage chooseFirstSmartWatch() {
        WebElement firstSmartWatch = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS)).until(
                ExpectedConditions.elementToBeClickable(firstSmartWatchLocator));
        firstSmartWatch.click();
       return new SmartWatchInfoPage(driver);
    }
}
