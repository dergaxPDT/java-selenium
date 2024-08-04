package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class TopMenuPage {
    private final WebDriver driver;

    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By buttonDevicesLocator = By.xpath("//button[text()='Urządzenia']//*//*");
    ;
    private final By buttonNoContractLocator = By.xpath("//button[text()='Bez abonamentu']");
    private final By buttonSmartwatchLocator = By.xpath("//a[text()='Smartwatche']");


    public ListSmartWatchPage chooseSmartWatchWithoutContract() {
        WebElement buttonDevice = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS)).until(
                ExpectedConditions.elementToBeClickable(buttonDevicesLocator));
        new Actions(driver).moveToElement(buttonDevice, 0, 0).click().perform();
        WebElement buttonNoContract = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS)).until(
                ExpectedConditions.elementToBeClickable(buttonNoContractLocator));
        new Actions(driver).moveToElement(buttonNoContract, 0, 0).click().perform();
        WebElement buttonSmartWatch = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS)).until(
                ExpectedConditions.elementToBeClickable(buttonSmartwatchLocator));
        new Actions(driver).moveToElement(buttonSmartWatch, 0, 0).click().perform();
        return new ListSmartWatchPage(driver);
    }
}
