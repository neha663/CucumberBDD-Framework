package ExecutionRepo.StepDefinition;

import org.openqa.selenium.WebDriver;

import ExecutionRepo.Hooks;
import ObjectRepo.readOR;

public class NavigationSteps extends GlobalData {
	WebDriver driver;
	static ClickSteps clickObj;
	static WaitStep wait;
	static FillSteps fillObj;
	static VerifySteps verifyObj;
	readOR objOR;
	static CommonSteps commObj;
	static GlobalData global;
	static Hooks hookObj;

	public NavigationSteps() {
		driver = Hooks.driver;
		clickObj = new ClickSteps();
		wait = new WaitStep();
		fillObj = new FillSteps();
		verifyObj = new VerifySteps();
		objOR = new readOR();
		global = new GlobalData();
		commObj = new CommonSteps();
		hookObj = new Hooks();
	}

}
