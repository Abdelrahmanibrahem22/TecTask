package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, Logger log) {
        super(driver,log);
    }
    public WebElement signupLoginLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));
        return driver.findElement(By.xpath("//a[@href='/login']"));
    }

    public WebElement loggedInAs() {
        return driver.findElement(By.xpath("//a[contains(. , 'Logged in as')]"));
    }

    public WebElement logoutLink() {
        return driver.findElement(By.xpath("//a[contains(. , ' Logout')]"));
    }

    public WebElement homePageIndicator() {
        return driver.findElement(By.cssSelector("div.features_items"));
    }

    public HomePage open() {
        driver.get("https://automationexercise.com/");
        return this;
    }
    public HomePage navigateToSignupLogin() {
        click(signupLoginLink());
        return this;
    }

    public HomePage logout() {
        click(logoutLink());
        return this;
    }

    public boolean isLoggedInAsVisible() {
        return isDisplayed(loggedInAs());
    }

    public String getLoggedInText() {
        return getText(loggedInAs());
    }

    public boolean isHomePageVisible() {
        return isDisplayed(homePageIndicator());
    }
}