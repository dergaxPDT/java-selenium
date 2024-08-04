package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class SmartWatchInfoPage {
    private final WebDriver driver;

    private final By addToCardLocator = By.xpath("//button//span/div[text()='Dodaj do koszyka']");
    private final By priceOnStartLocator = By.xpath("//div[text()='Do zapłaty na start']//..//..//div[contains(@class, 'dt_price_change')]");
    private final By monthlyInstallmentLocator = By.xpath("//div[text()='Do zapłaty miesięcznie']//..//..//div[contains(@class, 'dt_price_change')]");
    public static String priceOnStart;
    public static String monthlyInstallment;

    public SmartWatchInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public SummaryCardPage addToCard() {
        WebElement addToCard = new WebDriverWait(driver, Duration.of(10L, ChronoUnit.SECONDS)).until(
                ExpectedConditions.elementToBeClickable(addToCardLocator));
        addToCard.click();
        priceOnStart = driver.findElement(priceOnStartLocator)
                .getText()
                .replace(" zł", "");
        monthlyInstallment = driver.findElement(monthlyInstallmentLocator)
                .getText()
                .replace(" zł", "");
        return new SummaryCardPage(driver);
    }
}
