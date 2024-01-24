package base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if (webDriver.get()== null){
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }
    private static WebDriver createDriver(){

        WebDriver driver = null;

        String browserType = "chrome";

        switch (browserType){
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                ChromeOptions chrOption = new ChromeOptions();
                chrOption.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chrOption);
                break;
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
                FirefoxOptions fireOption = new FirefoxOptions();
                fireOption.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(fireOption);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
//    public static String getBrowserType() //throws
//    {
//        String browserType = null;
//
//        try{
//            Properties properties = new Properties();
//            FileInputStream file = new FileInputStream(System.getProperty("Selenium_Cucumber/java/properties/config.properties"));
//            properties.load(file);
//            browserType = properties.getProperty("browser").toLowerCase().trim();
//        } catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }
//
//        return browserType;

//    }
    public static void cleanupDriver(){
        webDriver.get().quit();
        webDriver.remove();
    }


}
