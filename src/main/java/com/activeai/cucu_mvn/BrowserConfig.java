package com.activeai.cucu_mvn;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import com.google.common.collect.ImmutableMap;

public class BrowserConfig {
	
	private static String osName;
	private static String driverPath;
	static File file;
	
	@SuppressWarnings("deprecation")
	public  WebDriver browserToRun(String browser, WebDriver driver) throws Exception {
		
		osName = System.getProperty("os.name");
		driverPath = getPath(osName);
		System.out.println(driverPath);
		System.out.println("in before test");
		if (!osName.toLowerCase().trim().contains("windows")) {
			Process p;
			try {
				p = Runtime.getRuntime().exec("chmod 777 -R " + driverPath);

				p.waitFor();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setCapability("marionette", true);
			driver = new FirefoxDriver(capability);
		}
		else if (browser.equalsIgnoreCase("chrome")) 
		{
			ChromeOptions chrmOp = new ChromeOptions();
			chrmOp.addArguments("--headless");
			chrmOp.addArguments("--disable-gpu");
			chrmOp.addArguments("--window-size=1920x1080");
			chrmOp.addArguments("--no-sandbox");
			chrmOp.addArguments("--disable-dev-shm-usage");
			file = new File(driverPath + "chromedriver.exe");
			ChromeDriverService chromeDriverService = new ChromeDriverService.Builder().usingDriverExecutable(file)
					.usingAnyFreePort().withEnvironment(ImmutableMap.of("DISPLAY", ":1")).build();
			chromeDriverService.start();
			// System.setProperty("webdriver.chrome.driver",
			//ChromeDriverService);
			try {
				driver = new ChromeDriver(chromeDriverService,chrmOp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (browser.equalsIgnoreCase("Safari")) 
		{
			driver = new SafariDriver();
		}
		Dimension d = new Dimension(1400, 900);
		driver.manage().window().setSize(d);	
		return driver;
	}
	
	public String getPath(String osName) {

		String path = "/Mac/";
		if (osName.toLowerCase().contains("mac")) {
			path = "Mac/";
		} else if (osName.toLowerCase().contains("linux")) {
			path = "Linux/";
		} else if (osName.toLowerCase().contains("windows"))
			path = "Windows/";
		return path;

	}

	public void tearDown(WebDriver driver) 
	{
		System.out.println("in after test");

		driver.close();
		driver.quit();
	}
	
}
