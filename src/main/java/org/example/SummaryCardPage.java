package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class SummaryCardPage {
    private final WebDriver driver;
    private final By mainImageLocator = By.xpath("//span//div/img");
    private final By priceOnStartLocator = By.xpath("//span[contains(@class, 'main-amount')]//div//span[1]");
    private final By monthlyInstallmentLocator = By.xpath("//span[@data-qa='BKT_TotalMonthly']");

    public static String priceOnStart;
    public static String monthlyInstallment;

    public SummaryCardPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage backToMainPage() {
        WebElement elementPrice = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS)).until(
                ExpectedConditions.visibilityOfElementLocated(priceOnStartLocator));
        priceOnStart = elementPrice.getText();
        WebElement elementMonthlyInstallment = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS)).until(
                ExpectedConditions.visibilityOfElementLocated(monthlyInstallmentLocator));
        monthlyInstallment = elementMonthlyInstallment.getText();
        WebElement mainImage = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS)).until(
                ExpectedConditions.elementToBeClickable(mainImageLocator));
        mainImage.click();
        return new MainPage(driver);
    }
}
