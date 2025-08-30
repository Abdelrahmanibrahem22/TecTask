package com.utils;

import com.github.javafaker.Faker;
import java.util.Locale;

public class DataGenerator {
    private static Faker faker = new Faker(new Locale("en-US"));

    public static TestData generateRandomTestData() {
        TestData testData = new TestData();

        testData.setName(faker.name().username());
        testData.setEmail(faker.internet().emailAddress());
        testData.setPassword(faker.internet().password(8, 16, true, true, true));
        testData.setFirstName(faker.name().firstName());
        testData.setLastName(faker.name().lastName());
        testData.setCompany(faker.company().name());
        testData.setAddress1(faker.address().streetAddress());
        testData.setAddress2(faker.address().secondaryAddress());
        testData.setCountry("United States");
        testData.setState(faker.address().state());
        testData.setCity(faker.address().city());
        testData.setZipcode(faker.address().zipCode());
        testData.setMobileNumber(faker.phoneNumber().cellPhone());

        return testData;
    }
}