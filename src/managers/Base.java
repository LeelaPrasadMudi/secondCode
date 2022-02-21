package managers;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.mongodb.MapReduceCommand.OutputType;

import java.io.IOException;

import org.apache.log4j.Logger;

import io.cucumber.java.AfterStep;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class Base {

	public Logger log = Logger.getLogger(this.getClass());

    public WebDriver driver;

    public Base()  {

        driver = DriverFactory.getDriver();
    }


    /**
     *  Takes screenshot
     *
     * @Param driver
     */
    @Attachment
    public  byte[] saveScreenShot(WebDriver driver)
    {
        log.info("Taking the screenshot of the current screen :");
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
	
    @AfterStep
    public void as(Scenario scenario) throws IOException, InterruptedException
    {
        scenario.attach(, "image/png", "screenshot name");		
    }
}
TakesScreenshot.getByteScreenshot()