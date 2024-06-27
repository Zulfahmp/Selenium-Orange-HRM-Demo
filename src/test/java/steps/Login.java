package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import object_repositories.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.SeleniumHelpers;

import java.time.Duration;

public class Login {

    WebDriver driver;
    WebDriverWait wait;
    SeleniumHelpers seleniumHelpers;
    WebElement webElement;
    LoginPage loginObject;

    @Given("the user is on the Orange HRM Login page")
    public void the_user_is_on_the_Orange_HRM_Login_page(){
        seleniumHelpers = new SeleniumHelpers(driver);
        loginObject = new LoginPage(webElement);
        seleniumHelpers.navigateToPage("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user input {string} and {string}")
    public void the_user_clicks_on_the_button(String username, String password){
        seleniumHelpers.inputField(loginObject.fieldUsername, "Admin");
        seleniumHelpers.inputField(loginObject.fieldPassword, "admin123");
    }

    @Then("the user click Login button")
    public void the_user_should_be_redirected_to_the_google_login_form() {
        seleniumHelpers.clickButton(loginObject.buttonLogin);
    }

    @And("redirect to Dashboard page")
    public void redirect_to_Dashboard_page(){
        String getTextDashboard = seleniumHelpers.getText(loginObject.textDashboardTile);
        seleniumHelpers.verifyTextEqual(getTextDashboard,"Dashboard");
    }
}
