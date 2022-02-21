package managers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.java.After;

public class Hooks extends Base {

	@After(order=1)
	public void takeScreenshotOnFailure(Scenario scenario) {
	if (scenario.isFailed()) {
		TakesScreenshot ts=(TakesScreenshot) driver;
	byte[] src = ts.getScreenshotAs(OutputType.BYTES);	
	scenario.attach(, "image/png", "screenshot name");
	
	}
		
	}
	
}
