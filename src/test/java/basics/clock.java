package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class clock {
	@Test
	public void clockTest() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		options.setPlatformName("Android");
		options.setCapability("platformVersion","9.0");
		options.setCapability("automationName", "UIAutomator2");
		options.setCapability("appPackage", "com.google.android.deskclock");
		options.setCapability("appActivity", "com.android.deskclock.DeskClock");
		URL url=new URL("http://127.0.0.1:4723");
		AndroidDriver driver=new AndroidDriver(url, options);
		String value=driver.findElement(By.id("com.google.android.deskclock:id/digital_clock")).getText();
		Assert.assertEquals(value,"4:58 PM") ;
	}

}
