package loginPortalStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pageObject.Base_PO;
import pageObject.Login_PO;

public class Login_Second_Practice extends Base_PO {
    private Login_PO loginPo;
    public Login_Second_Practice(Login_PO loginPo){
        this.loginPo = loginPo;
    }
    @Given("I access the webdriver university - Contact Us Page")
    public void i_access_the_webdriver_university_contact_us_page() {
    loginPo.navigateTo_WebDriverUniversity_Login_Page();
    }
    @When("I enter username {string}")
    public void i_enter_username(String userName) {
        //wait for clickable than we want to sendkeys to that element.
        //driver.findElement(By.id("text")).sendKeys(userName);
//        sendKeys(By.id("text"), userName);
        loginPo.seUserName(userName);
    }
    @When("I enter unique username {word}")
    public void i_enter_unique_username(String username) {
//        driver.findElement(By.id("text")).sendKeys(user_name);
//        sendKeys(By.id("text"), user_name);
        loginPo.seUserName(username);
    }
    @And("I enter password {word}")
    public void i_enter_password(String password) {
        loginPo.setPassword(password);
    }
    @And("I click on login btn")
    public void i_click_on_login_btn() {
//        driver.findElement(By.id("login-button")).click();
        loginPo.click_On_Login_Button();
    }
    @Then("I should present with successful message")
    public void i_should_present_with_successful_message() {
    loginPo.validate_successful_login_message();
    }
    @When("I enter unique username")
    public void i_enter_unique_username() {
//        driver.findElement(By.id("text")).sendKeys("AutoUN" + generateRandNum(5));
        sendKeys(By.id("text"), "AutoUN" + generateRandNum(5));
    }
    @And("I enter unique password")
    public void i_enter_unique_password() {
//        driver.findElement(By.id("password")).sendKeys("AutoPwd", genRandAlphabetic(5));
        sendKeys(By.id("password"), "AutoPwd" + genRandAlphabetic(5));
    }
    @Then("I should be presented with unsuccessful message")
    public void i_should_be_presented_with_unsuccessful_message() {
       loginPo.validate_unsuccessful_login_message();
    }
    @Then("I should presented with the following login validation message {}")
    public void i_should_presented_with_the_following_login_validation_message(String expectedMessage) {
        waitForAlert_And_ValidateText(expectedMessage);

    }

}
