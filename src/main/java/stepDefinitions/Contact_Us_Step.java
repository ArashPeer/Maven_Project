package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObject.Base_PO;
import pageObject.Contact_Us_PO;
public class Contact_Us_Step extends Base_PO {
    private Contact_Us_PO contact_us_po;
    public Contact_Us_Step(Contact_Us_PO contact_us_po){
        this.contact_us_po = contact_us_po;
    }
    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
//        navigateTo_URL("https://webdriveruniversity.com/Contact-Us/contactus.html");
        contact_us_po.navigateTo_WebDriverUniversity_Contact_Us_Page();
    }
    @And("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandNum(5));
//        sendKeys(By.xpath("//input[@name='first_name']"), "AutoFN" + generateRandNum(5));
        contact_us_po.setUnique_firstName();
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
//        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + generateRandNum(5));
        contact_us_po.setUnique_lastName();
    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
//        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoEmail" + generateRandNum(10) + "@mail.com");
        contact_us_po.setUniqueEmail_ID();
    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
//        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("AutoMessage" + genRandAlphabetic(20));
        contact_us_po.setUniqueComments();
    }
    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
//        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
        contact_us_po.setSpecific_firstName(firstName);
    }
    @And("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
//        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
        contact_us_po.setSpecific_lastName(lastName);
    }
    @And("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
//        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        contact_us_po.setSpecific_Email_ID(email);
    }
    @And("I enter a specific comment {string}")
    public void i_enter_a_specific(String comments) {
//        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
        contact_us_po.setSpecific_Comments(comments);
    }
    @And("I click on Submit Button")
    public void i_click_on_submit_button() {

//        driver.findElement(By.xpath("//input[@type='submit']")).click();
//        waitForWebElementAndClick(By.xpath("//input[@type='submit']"));
        contact_us_po.clickOn_Submit_Button();
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
//       WebElement contact_submission_message =  driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
//        Assert.assertEquals(contact_submission_message.getText(), "Thank You for your Message!");
//        System.out.println("The message is:: "+ contact_submission_message.getText());
        contact_us_po.validate_Successful_Submission_Message_Text();
    }

}
