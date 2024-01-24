package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Global_Vars;

public class Contact_Us_PO extends Base_PO{

    private  @FindBy(how = How.XPATH, using = "//input[@name='first_name']") WebElement firtName_TextField;
    private  @FindBy(how = How.XPATH, using = "//input[@name='last_name']") WebElement lastName_TextField;
    private @FindBy(xpath = "//input[@name='email']") WebElement email_TextField;
    private @FindBy(xpath = "//textarea[@name='message']") WebElement comments_TextField;
    private @FindBy(xpath = "//input[@type='submit']") WebElement submitButton;
    private @FindBy(xpath = "//div[@id='contact_reply']/h1") WebElement successful_Submission_Message;

    public Contact_Us_PO(){

        super();
    }
    public void navigateTo_WebDriverUniversity_Contact_Us_Page(){
        navigateTo_URL(Global_Vars.WEBDRIVER_UNIVERSTIY_URL + "/Contact-Us/contactus.html");
    }
    public void setUnique_firstName(){
        sendKeys(firtName_TextField, "AutoFN" + generateRandNum(5));
    }  public void setUnique_lastName(){
        sendKeys(lastName_TextField, "AutoFN" + generateRandNum(6));
    }
    public void setUniqueEmail_ID(){
        sendKeys(email_TextField, "AutoEmail" + generateRandNum(10) + "@mail.com");
    }
    public void setUniqueComments(){
        sendKeys(comments_TextField, "AutoMessage" + genRandAlphabetic(20));
    }
    public void setSpecific_firstName(String firstName){
        sendKeys(firtName_TextField, firstName);

    } public void setSpecific_lastName(String lastName){
        sendKeys(lastName_TextField, lastName);

    }public void setSpecific_Email_ID(String emailId){
        sendKeys(email_TextField, emailId);

    }public void setSpecific_Comments(String comments){
        sendKeys(comments_TextField, comments);

    }
    public void clickOn_Submit_Button(){
    waitForWebElementAndClick(submitButton);
    }
    public void validate_Successful_Submission_Message_Text(){
        waitFor(successful_Submission_Message);
        Assert.assertEquals(successful_Submission_Message.getText(), "Thank You for your Message!");
        System.out.println(successful_Submission_Message.getText());

    }

}
