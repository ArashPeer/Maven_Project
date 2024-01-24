package loginPortalStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.Base_PO;
import pageObject.Login_PO;

public class Login_Portal extends Base_PO {

    private Login_PO loginPo;
    public Login_Portal(Login_PO loginPo){

        this.loginPo = loginPo;
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {

        loginPo.navigateTo_WebDriverUniversity_Login_Page();
    }
    @When("I enter specific user name {word}")
    public void i_enter_specific_user_name(String webdriver) {
        loginPo.seUserName(webdriver);

    }
    @And("I enter specific password {word}")
    public void i_enter_unique_password(String pass) {
        loginPo.seUserName(pass);
    }
    @And("I click on login button")
    public void i_click_on_login_button() {
        loginPo.click_On_Login_Button();

    }
    @And("I validate the successful login")
    public void i_validate_the_successful_login() {
        System.out.println("The login is successful");
    }
    @Then("I validate the pop up text message")
    public void i_validate_the_pop_up_text_message() {
       loginPo.validate_unsuccessful_login_message();

    }
    @When("I enter a unique user name")
    public void i_enter_a_unique_user_name() {
        sendKeys(By.id("text"), "AutoUN" + generateRandNum(5));
    }
    @And("I enter a unique password")
    public void i_enter_a_unique_password() {
        sendKeys(By.id("password"), "AutoPWD" + generateRandNum(10));
    }
    @Then("I need to validate the pop up failed message")
    public void i_need_to_validate_the_pop_up_failed_message() {
        loginPo.validate_unsuccessful_login_message();

    }

    }

