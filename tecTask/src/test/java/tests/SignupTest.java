package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.SignUpPage;
import com.utils.DataGenerator;
import com.utils.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("User Registration")
@Feature("Signup Process")
public class SignupTest extends BaseTest {
    private HomePage homePage;
    private SignUpPage signupPage;

    @BeforeMethod
    public void pageSetup() {
        homePage = new HomePage(driver, log);
        signupPage = new SignUpPage(driver, log);
    }
    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        return new Object[][] {
                {DataGenerator.generateRandomTestData()},
                {DataGenerator.generateRandomTestData()},
                {DataGenerator.generateRandomTestData()}
        };
    }

    @Test(dataProvider = "userData")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test to verify user registration with random data")
    @Story("User should be able to register with valid credentials")
    public void testUserSignup(TestData testData) {

        homePage.open()
                .navigateToSignupLogin();

        signupPage
                .fillSignupForm(testData.getName(), testData.getEmail())
                .fillAccountInformation(testData)
                .fillAddressInformation(testData)
                .createAccount();

        verifyAccountCreation();

        signupPage.continueAfterAccountCreation();

        verifyLoggedInStatus();

        homePage.logout();
    }

    @Step("Verify account creation")
    private void verifyAccountCreation() {
        assert signupPage.isAccountCreated() : "Account was not created successfully";
    }

    @Step("Verify user is logged in")
    private void verifyLoggedInStatus() {
        assert homePage.isLoggedInAsVisible() : "User is not logged in after registration";
    }
}