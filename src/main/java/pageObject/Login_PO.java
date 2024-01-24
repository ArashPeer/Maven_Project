package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Vars;

/*
We created login page object to model the login page is of webdriveruniversity.com,
We created web elements and page factory annotations then we create custom methods inside login_PO
* */
public class Login_PO extends Base_PO{
    //page factory annotation
    private @FindBy(id = "text")
    WebElement userName_TextField;

    private @FindBy(id = "password")
    WebElement password_TextField;

    private @FindBy(id ="login-button")
    WebElement login_button;

    public Login_PO(){

        super();
    }
    public void navigateTo_WebDriverUniversity_Login_Page(){
        navigateTo_URL(Global_Vars.WEBDRIVER_UNIVERSTIY_URL +"/Login-Portal/index.html?");

    }
    public void seUserName(String username){
        sendKeys(userName_TextField, username);
    }
    public void setPassword(String password){

        sendKeys(password_TextField, password);
    }
    public void click_On_Login_Button(){

        waitForWebElementAndClick(login_button);
    }
    public void validate_successful_login_message(){

        waitForAlert_And_ValidateText("validation succeeded");
    }
    public void validate_unsuccessful_login_message(){

        waitForAlert_And_ValidateText("validation failed");
    }

}
