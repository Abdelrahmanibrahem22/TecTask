package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.utils.TestData;
import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.logging.Logger;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    private Faker faker = new Faker(new Locale("en-US"));

    // Element locator methods
    public WebElement nameInput() {
        return driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
    }

    public WebElement emailInput() {
        return driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
    }

    public WebElement signupButton() {
        return driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
    }

    public WebElement titleMrRadio() {
        return driver.findElement(By.id("id_gender1"));
    }

    public WebElement titleMrsRadio() {
        return driver.findElement(By.id("id_gender2"));
    }

    public WebElement passwordInput() {
        return driver.findElement(By.id("password"));
    }

    public WebElement daysDropdown() {
        return driver.findElement(By.id("days"));
    }

    public WebElement monthsDropdown() {
        return driver.findElement(By.id("months"));
    }

    public WebElement yearsDropdown() {
        return driver.findElement(By.id("years"));
    }

    public WebElement newsletterCheckbox() {
        return driver.findElement(By.id("newsletter"));
    }

    public WebElement specialOffersCheckbox() {
        return driver.findElement(By.id("optin"));
    }

    public WebElement firstNameInput() {
        return driver.findElement(By.id("first_name"));
    }

    public WebElement lastNameInput() {
        return driver.findElement(By.id("last_name"));
    }

    public WebElement companyInput() {
        return driver.findElement(By.id("company"));
    }

    public WebElement address1Input() {
        return driver.findElement(By.id("address1"));
    }

    public WebElement address2Input() {
        return driver.findElement(By.id("address2"));
    }

    public WebElement countryDropdown() {
        return driver.findElement(By.id("country"));
    }

    public WebElement stateInput() {
        return driver.findElement(By.id("state"));
    }

    public WebElement cityInput() {
        return driver.findElement(By.id("city"));
    }

    public WebElement zipcodeInput() {
        return driver.findElement(By.id("zipcode"));
    }

    public WebElement mobileNumberInput() {
        return driver.findElement(By.id("mobile_number"));
    }

    public WebElement createAccountButton() {
        return driver.findElement(By.cssSelector("button[data-qa='create-account']"));
    }

    public WebElement accountCreatedMessage() {
        return driver.findElement(By.cssSelector("h2[data-qa='account-created']"));
    }

    public WebElement continueButton() {
        return driver.findElement(By.cssSelector("a[data-qa='continue-button']"));
    }

    // Fluent methods for signup process
    public SignUpPage fillSignupForm(String name, String email) {
        type(nameInput(), name);
        type(emailInput(), email);
        click(signupButton());
        return this;
    }

    public SignUpPage fillAccountInformation(TestData testData) {
        // Select random title
        if (Math.random() > 0.5) {
            click(titleMrRadio());
        } else {
            click(titleMrsRadio());
        }

        type(passwordInput(), testData.getPassword());

        // Select random date of birth
        selectByValue(daysDropdown(), String.valueOf(faker.number().numberBetween(1, 28)));
        selectByValue(monthsDropdown(), String.valueOf(faker.number().numberBetween(1, 12)));
        selectByValue(yearsDropdown(), String.valueOf(faker.number().numberBetween(1970, 2000)));

        // Subscribe to newsletter and special offers
        if (Math.random() > 0.5) click(newsletterCheckbox());
        if (Math.random() > 0.5) click(specialOffersCheckbox());

        return this;
    }

    public SignUpPage fillAddressInformation(TestData testData) {
        type(firstNameInput(), testData.getFirstName());
        type(lastNameInput(), testData.getLastName());
        type(companyInput(), testData.getCompany());
        type(address1Input(), testData.getAddress1());
        type(address2Input(), testData.getAddress2());
        selectByVisibleText(countryDropdown(), testData.getCountry());
        type(stateInput(), testData.getState());
        type(cityInput(), testData.getCity());
        type(zipcodeInput(), testData.getZipcode());
        type(mobileNumberInput(), testData.getMobileNumber());

        return this;
    }

    public SignUpPage createAccount() {
        click(createAccountButton());
        return this;
    }

    public SignUpPage continueAfterAccountCreation() {
        click(continueButton());
        return this;
    }

    public boolean isAccountCreated() {
        return isDisplayed(accountCreatedMessage());
    }
}