package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Calc {
	@Test
	public void calctest() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		options.setPlatformName("Android");
		options.setCapability("platformVersion","9.0");
		options.setCapability("automationName", "UIAutomator2");
		options.setCapability("appPackage", "com.android.calculator2");
		options.setCapability("appActivity", "com.android.calculator2.Calculator");
		URL url=new URL("http://127.0.0.1:4723");
		AndroidDriver driver=new AndroidDriver(url, options);
		driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("×")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit_0")).click();
		//driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result=driver.findElement(By.id("com.android.calculator2:id/result")).getText();
		Assert.assertEquals(result,"1,000,000");
		
	}

}
