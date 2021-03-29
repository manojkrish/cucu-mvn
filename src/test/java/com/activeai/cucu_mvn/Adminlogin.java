package com.activeai.cucu_mvn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Adminlogin{

	WebDriver driver;

	@Given("^Open Browser$")
	public void open_Browser() throws Throwable {
		BrowserConfig bc = new BrowserConfig();
		driver = bc.browserToRun("chrome", driver);
	}

	@Then("^enter the url as \"([^\"]*)\"$")
	public void enter_the_url_as(String arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(arg1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^workspaces login page is displayed$")
	public void workspaces_login_page_is_displayed() throws Throwable {
		waitMethod(driver.findElement(By.xpath("//b[contains(text(),'Sign into Morfeus')]")));
		if (driver.findElement(By.xpath("//b[contains(text(),'Sign into Morfeus')]")).isDisplayed()) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Success");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Failed");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	@Then("^username field is visible$")
	public void username_field_is_visible() throws Throwable {
		waitMethod(driver.findElement(By.xpath("//label[contains(text(),'Username')]")));
		if (driver.findElement(By.xpath("//label[contains(text(),'Username')]")).isDisplayed()) {
			System.out.println("UserName Field is displayed");
		} else {
			System.out.println("UserName Field is not displayed");
		}
	}

	@Then("^password field is visible$")
	public void password_field_is_visible() throws Throwable {
		waitMethod(driver.findElement(By.xpath("//label[contains(text(),'Password')]")));
		if (driver.findElement(By.xpath("//label[contains(text(),'Password')]")).isDisplayed()) {
			System.out.println("Password Field is displayed");
		} else {
			System.out.println("Password Field is not displayed");
		}
	}

	@Then("^enter the username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void enter_the_username_as_and_password_as(String arg1, String arg2) throws Throwable {
		waitMethod(driver.findElement(By.xpath("//input[@id='username']")));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(arg1);
		waitMethod(driver.findElement(By.xpath("//input[@id='password']")));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(arg2);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^click on the login button$")
	public void click_on_the_login_button() throws Throwable {
		waitMethod(driver.findElement(By.xpath("//button[@id='loginBtn']")));
		driver.findElement(By.xpath("//button[@id='loginBtn']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^observe login success message is displayed$")
	public void observe_login_success_message_is_displayed() throws Throwable {
		waitMethod(driver.findElement(By.xpath("(//h5)[1]")));
		if (driver.findElement(By.xpath("(//h5)[1]")).getText().equalsIgnoreCase("Add Workspace")) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Success");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Failed");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	@Then("^click on the logout button$")
	public void click_on_the_logout_button() throws Throwable {
		waitMethod(driver.findElement(By.xpath("//span[@class='user_name_dp']")));
		driver.findElement(By.xpath("//span[@class='user_name_dp']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed()) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Failed");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	@Then("^close Browser$")
	public void close_Browser() throws Throwable {
		driver.close();
		driver.quit();
	}

	@Then("^change the session time as (\\d+) sec$")
	public void change_the_session_time_as_sec(int arg1) throws Throwable {
		waitMethod(driver.findElement(By.xpath(
				"//div[@id='tab3']/div/div/h4[@class='panel-title'][contains(text(),'Configuration')]/parent::div/following-sibling::div/div/div/div/h4[@class='dashboard-sublabel'][contains(text(),'Maximum Session Duration (secs)')]/parent::div/following-sibling::div/div/input[@id='ruleValue']")));
		driver.findElement(By.xpath(
				"//div[@id='tab3']/div/div/h4[@class='panel-title'][contains(text(),'Configuration')]/parent::div/following-sibling::div/div/div/div/h4[@class='dashboard-sublabel'][contains(text(),'Maximum Session Duration (secs)')]/parent::div/following-sibling::div/div/input[@id='ruleValue']"))
				.clear();
		driver.findElement(By.xpath(
				"//div[@id='tab3']/div/div/h4[@class='panel-title'][contains(text(),'Configuration')]/parent::div/following-sibling::div/div/div/div/h4[@class='dashboard-sublabel'][contains(text(),'Maximum Session Duration (secs)')]/parent::div/following-sibling::div/div/input[@id='ruleValue']"))
				.sendKeys(Integer.toString(arg1));
	}

	@Then("^keep idle for (\\d+) sec$")
	public void keep_idle_for_sec(int arg1) throws Throwable {
		waitMethod(driver.findElement(By.xpath("//a/img[@src='imgs/ai-logo-black.png']")));
		Thread.sleep(11000);
		driver.findElement(By.xpath("//a/img[@src='imgs/ai-logo-black.png']")).click();
	}

	@Then("^Observe session timeout message is displayed$")
	public void observe_session_timeout_message_is_displayed() throws Throwable {
		waitMethod(
				driver.findElement(By.xpath("//*[contains(text(),'Your session has timed out. Please login again')]")));
		if (driver.findElement(By.xpath("//*[contains(text(),'Your session has timed out. Please login again')]"))
				.isDisplayed()) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}

	@Then("^observe invalid credentials login message is displayed$")
	public void observe_invalid_credentials_login_message_is_displayed() throws Throwable {
		waitMethod(driver.findElement(By.xpath("//div[@class='toast-message']")));
		if (driver.findElement(By.xpath("//div[@class='toast-message']")).getText()
				.equalsIgnoreCase("Please enter valid user credentials")) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Success");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Failed");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	@Then("^observe empty field validation appears in the password field$")
	public void observe_empty_field_validation_appears_in_the_password_field() throws Throwable {
		waitMethod(driver.findElement(By.xpath(
				"//div[@class='form-group']/label[@class='login-field'][contains(text(),'Password')]/parent::div/ul/li")));
		if (driver.findElement(By.xpath(
				"//div[@class='form-group']/label[@class='login-field'][contains(text(),'Password')]/parent::div/ul/li"))
				.getText().equalsIgnoreCase("This value is required.")) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}

	@Then("^observe empty field validation appears in the username field$")
	public void observe_empty_field_validation_appears_in_the_username_field() throws Throwable {
		waitMethod(driver.findElement(By.xpath(
				"//div[@class='form-group']/label[@class='login-field'][contains(text(),'Username')]/parent::div/ul/li")));
		if (driver.findElement(By.xpath(
				"//div[@class='form-group']/label[@class='login-field'][contains(text(),'Username')]/parent::div/ul/li"))
				.getText().equalsIgnoreCase("This value is required.")) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}

	@Then("^observe empty field validation appears in the username and password field$")
	public void observe_empty_field_validation_appears_in_the_username_and_password_field() throws Throwable {
		waitMethod(driver.findElement(By.xpath(
				"//div[@class='form-group']/label[@class='login-field'][contains(text(),'Username')]/parent::div/ul/li")));
		if (driver.findElement(By.xpath(
				"//div[@class='form-group']/label[@class='login-field'][contains(text(),'Username')]/parent::div/ul/li"))
				.getText().equalsIgnoreCase("This value is required.")
				&& driver.findElement(By.xpath(
						"//div[@class='form-group']/label[@class='login-field'][contains(text(),'Password')]/parent::div/ul/li"))
						.getText().equalsIgnoreCase("This value is required.")) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}

	@Then("^Click on settings$")
	public void click_on_settings() throws Throwable {
		waitMethod(driver.findElement(By.xpath("//ul/li/a[contains(text(),'Settings')]")));
		driver.findElement(By.xpath("//ul/li/a[contains(text(),'Settings')]")).click();
	}

	@Then("^navigate to security$")
	public void navigate_to_security() throws Throwable {
		waitMethod(driver.findElement(By.xpath("(//ul/li/a[contains(text(),'Security')])[2]")));
		driver.findElement(By.xpath("(//ul/li/a[contains(text(),'Security')])[2]")).click();
	}

	@When("^Configuration page is displayed$")
	public void configuration_page_is_displayed() throws Throwable {
		waitMethod(driver.findElement(
				By.xpath("//div[@id='tab3']/div/div/h4[@class='panel-title'][contains(text(),'Configuration')]")));
		if (driver
				.findElement(By
						.xpath("//div[@id='tab3']/div/div/h4[@class='panel-title'][contains(text(),'Configuration')]"))
				.isDisplayed()) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}

	}

	@Then("^Set \"([^\"]*)\" as \"([^\"]*)\"$")
	public void set_as(String arg1, String arg2) throws Throwable {
		waitMethod(driver.findElement(By.xpath(
				"//div[@id='tab3']/div/div/h4[@class='panel-title'][contains(text(),'Configuration')]/parent::div/following-sibling::div/div/div/div/h4[@class='dashboard-sublabel'][contains(text(),'"
						+ arg1 + "')]/parent::div/following-sibling::div/div/input[@id='ruleValue']")));
		if (driver.findElement(By.xpath(
				"//div[@id='tab3']/div/div/h4[@class='panel-title'][contains(text(),'Configuration')]/parent::div/following-sibling::div/div/div/div/h4[@class='dashboard-sublabel'][contains(text(),'"
						+ arg1 + "')]/parent::div/following-sibling::div/div/input[@id='ruleValue']"))
				.isDisplayed()) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(
					"//div[@id='tab3']/div/div/h4[@class='panel-title'][contains(text(),'Configuration')]/parent::div/following-sibling::div/div/div/div/h4[@class='dashboard-sublabel'][contains(text(),'"
							+ arg1 + "')]/parent::div/following-sibling::div/div/input[@id='ruleValue']"))
					.clear();
			driver.findElement(By.xpath(
					"//div[@id='tab3']/div/div/h4[@class='panel-title'][contains(text(),'Configuration')]/parent::div/following-sibling::div/div/div/div/h4[@class='dashboard-sublabel'][contains(text(),'"
							+ arg1 + "')]/parent::div/following-sibling::div/div/input[@id='ruleValue']"))
					.sendKeys(arg2);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	@Then("^click on Save$")
	public void click_on_Save() throws Throwable {
		waitMethod(driver.findElement(By.xpath("//button[@id='saveBtn']")));
		driver.findElement(By.xpath("//button[@id='saveBtn']")).click();
		waitMethod(driver.findElement(By.xpath("//*[contains(text(),'System Rules updated successfully')]")));
		if (driver.findElement(By.xpath("//*[contains(text(),'System Rules updated successfully')]")).isDisplayed()) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}

	@Then("^system should prompt for force change password page$")
	public void system_should_prompt_for_force_change_password_page() throws Throwable {
		waitMethod(driver.findElement(By.xpath("//h1/b[contains(text(),'Change Password')]")));
		if (driver.findElement(By.xpath("//h1/b[contains(text(),'Change Password')]")).isDisplayed()) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}

	@Then("^Enter new password as \"([^\"]*)\" and Re Enter new password as \"([^\"]*)\"$")
	public void enter_new_password_as_and_Re_Enter_new_password_as(String arg1, String arg2) throws Throwable {
		waitMethod(driver.findElement(By.xpath("//input[@id='oldPassword']")));
		if (driver.findElement(By.xpath("//input[@id='oldPassword']")).isDisplayed()) {
			driver.findElement(By.xpath("//input[@id='oldPassword']")).sendKeys(arg1);
		} else {
			System.out.println("Failed");
		}
		if (driver.findElement(By.xpath("//input[@id='newPassword']")).isDisplayed()) {
			driver.findElement(By.xpath("//input[@id='newPassword']")).sendKeys(arg2);
		} else {
			System.out.println("Failed");
		}
	}

	@Then("^Enter new password as \"([^\"]*)\"$")
	public void enter_new_password_as(String arg1) throws Throwable {

	}

	@Then("^click on submit$")
	public void click_on_submit() throws Throwable {
		waitMethod(driver.findElement(By.xpath("//button[@id='changePasswordBtn']")));
		if (driver.findElement(By.xpath("//button[@id='changePasswordBtn']")).isDisplayed()) {
			driver.findElement(By.xpath("//button[@id='changePasswordBtn']")).click();
		} else {
			System.out.println("Failed");
		}
	}

	@Then("^Password should be changed successfully message should be displayed$")
	public void password_should_be_changed_successfully_message_should_be_displayed() throws Throwable {
		waitMethod(driver.findElement(By.xpath("//*[contains(text(),'Password changed successfully')]")));
	}

	public void waitMethod(WebElement we) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(we));
	}

}
