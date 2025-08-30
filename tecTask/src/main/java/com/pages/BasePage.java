package com.pages;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage{
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log;

    public BasePage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.log = log;
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Fluent methods for common actions
    protected BasePage click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        return this;
    }

    protected BasePage type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
        return this;
    }

    protected BasePage selectByValue(WebElement element, String value) {
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(element)));
        dropdown.selectByValue(value);
        return this;
    }

    protected BasePage selectByVisibleText(WebElement element, String text) {
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(element)));
        dropdown.selectByVisibleText(text);
        return this;
    }

    protected String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected boolean isDisplayed(WebElement element) {
        return isElementPresent(element);
    }
}