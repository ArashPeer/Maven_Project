package pageObject;

import base.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;

import java.time.Duration;

//WE WANT TO ADD CUSTOM METHOD TO THIS CLASS
public class Base_PO {

    public Base_PO(){// constructor

        PageFactory.initElements(getDriver(), this);
    }
    public WebDriver getDriver(){
        return DriverFactory.getDriver();
    }
    public void navigateTo_URL(String url){

        getDriver().get(url);
    }
    public String generateRandNum(int numLength){
        return RandomStringUtils.randomNumeric(numLength);
    }
    public String genRandAlphabetic(int alphaLength){
        return RandomStringUtils.randomAlphabetic(alphaLength);
    }

    public void sendKeys(By by, String textToType){                            //refers to Global_Vars class
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }   public void sendKeys(WebElement element, String textToType){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    } public void waitForWebElementAndClick(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }public void waitFor(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }public void waitFor(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }public void waitForWebElementAndClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void waitForAlert_And_ValidateText(String text){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alert_Message_Text,text);
    }
}

//the method below is the count of string uppercase letter and lowercase letter.
//    public static void main(String[] args) {
//        String str = "dkdSDFDKJsdsSddS";
//        int lowerCaseLetter = 0;
//        int upperCaseLetter = 0;
//
//        for(int i = 0; i<str.length(); i++){
//            char ch = str.charAt(i);
//            if(Character.isUpperCase(ch)){
//                upperCaseLetter++;
//            }else if (Character.isLowerCase(ch)){
//                lowerCaseLetter++;
//            }
//        }
//        System.out.println("upperCaseLetter count:: " + upperCaseLetter);
//        System.out.println("lowerCaseLetter count:: " + lowerCaseLetter);
//    }