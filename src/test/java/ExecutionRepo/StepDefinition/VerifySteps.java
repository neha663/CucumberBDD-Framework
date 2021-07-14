package ExecutionRepo.StepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExecutionRepo.Hooks;
import ObjectRepo.readOR;
import ReporterRepo.Reporter;
import cucumber.api.java.en.*;
import io.cucumber.datatable.DataTable;

public class VerifySteps extends GlobalData {
	static WebDriver driver;
	readOR objOR;
	static WaitStep wait;
	static CommonSteps commonObj;
	static ClickSteps clickObj;
	static FillSteps fillObj;

	public VerifySteps() {
		driver = Hooks.driver;
		objOR = new readOR();
		wait = new WaitStep();
		commonObj = new CommonSteps();
		clickObj = new ClickSteps();
		fillObj = new FillSteps();
	}

	@Then("^Print the dropdown options displayed$")
	public void VerifyDropDownItems() throws Exception {

		for (int j = 1; j <= 4; j++) {

			Thread.sleep(5000);
			WebElement obj = driver.findElement(By.xpath("//li[@class='dropdown'][" + j + "]/ul"));

			List<WebElement> list = obj.findElements(By.tagName("li"));

			for (int i = 0; i < list.size(); i++) {

				if (list.get(i).getText().equals("About")) {
					System.out.println("Print About");
				} else if (list.get(i).getText().equals("Pricing & Package")) {
					System.out.println("Print Pricing & Package");
				}

			}

		}
	}

	@Then("^I verify current url after clicking about$")
	public void verify_URL() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Current URL after clicking on About:= " + driver.getCurrentUrl());

	}

	@Then("^I see current url as signup$")
	public void Verify_CurrentURL() {

		String currentURL = driver.getCurrentUrl();
		if (currentURL.equals("https://www.fourmodules.com/signup")) {
			System.out.println("Current URL:= " + currentURL);
		} else {
			System.out.println("Current URL:= " + currentURL);
		}
	}

	@Then("^I see a button \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void verifyButton(String sPageName, String sControlName) throws Exception {

		Thread.sleep(10000);

		WebElement obj = driver.findElement(By.xpath("//span[contains(text(),'Any Questions?')]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", obj);

		driver.findElement(By.xpath("//html")).sendKeys(Keys.PAGE_UP);

		if (obj.isEnabled()) {
			System.out.println("AnyQuestions Button is enabled.............");
		} else {
			System.out.println("AnyQuestions Button is disabled............");
		}

	}

	// @Then("^I see current url as signup$")
	public void i_see_current_url_as(String sControlName, String sPageName) {
		System.out.println(driver.getCurrentUrl());
	}

	@When("^I see Navbar that includes the \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void see_navbar_spicejet(String sControlName, String sPageName) throws Exception {

		WebElement obj = objOR.getObject(sPageName, sControlName);

		List<WebElement> list = obj.findElements(By.tagName("li"));

		for (int i = 0; i < list.size(); i++) {
			System.out.println("Print SpiceJet Menu Items:= " + list.get(i).getText());
		}

	}

	@Then("^I see \"([^\"]*)\" is selected by default on \"([^\"]*)\" page$")
	public void verify_flights_selected(String sControlName, String sPageName) throws Exception {

		WebElement obj = objOR.getObject(sPageName, sControlName);

		WebElement obj2 = obj.findElement(By.tagName("li"));

		List<WebElement> list2 = obj2.findElements(By.tagName("a"));

		for (int i = 0; i < list2.size(); i++) {

			if (list2.get(i).getText().equals("Flights") && list2.get(i).getAttribute("class").equals("selected")) {

				System.out
						.println("Print SpiceJet Menu Flights Items selected:= " + list2.get(i).getAttribute("class"));
				System.out.println("Print SpiceJet Menu Flights Items:= " + list2.get(i).getText());
				System.out.println("Flights in menu is selected by default........");
				break;

			}
		}
	}

	@When("^I select 1Adult_textbox and \"([^\"]*)\" on \"([^\"]*)\" page$")
	public void selectInfants(String sControlName, String sPageName) throws Exception {
		Thread.sleep(5000);

		WebElement objs = driver.findElement(By.xpath("//div[@id='divpaxinfo']"));
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(objs));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", objs);
		Thread.sleep(5000);

		Thread.sleep(5000);

		Select select1 = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Infant']")));
		Thread.sleep(5000);
		select1.selectByIndex(3);

	}

	@Then("^I see a pop-up window with a message$")
	public void popup_window_message() throws InterruptedException, AWTException {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message:= " + alert.getText());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Then("^Record the message and print it to the Console$")
	public void record_popup_window_message() throws InterruptedException {
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Then("^Redirect me to book_url$")
	public void redirect_me_to() {
		String currentURL = driver.getCurrentUrl();
		if (currentURL.equals("https://book.spicejet.com/Select.aspx")) {
			System.out.println("Current URL:= " + currentURL);
		} else {
			System.out.println("Current URL:= " + currentURL);
		}
	}

	@Then("Verify the user has advanced to the next page by printing to Console the URL")
	public void verify_the_user_has_advanced_to_the_next_page_by_printing_to_Console_the_URL() {
		String currentURL = driver.getCurrentUrl();

	}

	@Then("^Clicking on \"([^\"]*)\" CTA button will redirect me to url on \"([^\"]*)\" page$")
	public void verify_redirect_url(String sControlName, String sPageName) {

		// if(driver.getCurrentUrl().equals("https://book.spicejet.com/Select.aspx")){
		System.out.println("current url redirected successfully:= " + driver.getCurrentUrl());
		// }
	}

	@Then("^I see the page interstitial$")
	public void interstital_page() {
		System.out.println("Page Interstitial:= " + driver.getCurrentUrl());
	}

	@Then("^If no fares are available, record the message and print to the Console$")
	public void getMessage_no_fair() {

		try {
			WebElement element = driver.findElement(By.xpath(
					"//div[contains(text(),'Sorry, no fares aSorry, no fares available for this date. Please select another date and try again.vailable for this date. Please se')]"));

			if (element.isDisplayed()) {
				System.out.println("Sorry, no fares available for this date. Please se");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@When("^I see the \"([^\"]*)\" CTA button on \"([^\"]*)\" page$")
	public void verify_go_icon(String sControlName, String sPageName) throws Exception {
		Thread.sleep(5000);
		WebElement obj = objOR.getObject(sPageName, sControlName);

		if (obj.isEnabled()) {
			System.out.println("Go_CTA_button is enabled");
		} else {
			System.out.println("Go_CTA_button is disabled");
		}

	}

}
