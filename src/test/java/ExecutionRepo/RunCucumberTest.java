package ExecutionRepo;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import DriverRepo.CreateDriver;
import ReporterRepo.ReportManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = { "~@skip-test", "@Regression1" },
		monochrome = true,
		plugin = { "pretty", "json:target/result/cucumber.json",
				"html:target/result/cucumber-reports" },
		features = "src/test/resources/features/SmokeTests",dryRun=false
)

public class RunCucumberTest {
	@AfterClass
	public static void testMethod() throws Throwable {
		System.out.println("after class");
		ReportManager.reportCreate();
		CreateDriver.killInstance();
		Hooks.driver.quit();
		Hooks.driver = null;
	}
}