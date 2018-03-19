package step_definitions;

import java.net.MalformedURLException;

import com.jyoti.selenium.BasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Class is with all the step definition
 * @author Jyoti Pareek
 *
 */
public class ValidationSteps {

	BasePage base = new BasePage();

	/**
	 * 
	 * @param browsertype
	 *            type of browser
	 * @param url
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	@Given("^Launch Amazon Application using (.*) broswer and (.*) url$")
	public void launch_Amazon_Application(String browsertype, String url)
			throws MalformedURLException, InterruptedException {
		base.createDriver(browsertype, url);
	}

	@Then("^Validate Today Deal$")
	public void validate_Today_s_Deal() {
		base.isTodaysDealDisplayed();
	}

	@Then("^Click on (.*) link$")
	public void clickLink(String link) {
		base.clickonLink(link);
	}

	@Then("^Validate deals displayed in new page$")
	public void validate_deals() {
		base.switch_window();
		base.validateNewTab();
	}

	@Then("^Hover on Category link$")
	public void click_on_categoryLink() {
		base.hoverCategoryLink();
	}

	@Then("^Closed the driver$")
	public void close() {
		base.teardown();
	}

	@Then("^Took the snapshot$")
	public void takescreenshot() {
		base.take_screenshots();
	}

	@Then("^Navigate back to Amazon Page$")
	public void navigateTo() {
		base.switch_window();
	}

	@Then("^Input (.*) on (.*) inputbox$")
	public void inputValues(String inputText, String textAreaName) {
		base.inputText(textAreaName, inputText);
	}

	@Then("^Validate the logged in user$")
	public void validateLogin() {
		base.validate_login();
	}
	
	@Then("^Wait for (.*) seconds$")
	public void waitFor(int waitTime)
	{
		base.WaitForTime(waitTime);
	}
}
