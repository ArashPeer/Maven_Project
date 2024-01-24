package base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Timestamp;

import static base.DriverFactory.getDriver;
import static base.DriverFactory.cleanupDriver;

//we cannot extend classed that contains Hooks like @Before or @After etc using cucumber.
public class Hooks {

    @Before
    public void setupChrome() {
        getDriver();
    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //this will save in the form of long DT
            //we want to save this as String as follows,
            String timeMillieSeconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeMillieSeconds);

        }
    }
    @After
    public void tearDown() {

        cleanupDriver();


    }

}
