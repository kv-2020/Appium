package generalStore;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class MobileBrowser {
	@Test
	public void browsertest() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		options.setChromedriverExecutable("//Users//rahulshetty//documents//chromedriver 11");//
		options.setCapability("browserName", "Chrome");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.get("http://google.com");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		System.out.println("hello appium!!");

	}

}
