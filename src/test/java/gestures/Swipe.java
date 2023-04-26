package gestures;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Swipe {
	
	@Test
	public void swipetest() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		
		options.setApp("C:\\Users\\kittu\\Appium\\Appium\\src\\test\\java\\appPackages\\ApiDemos-debug.apk");
		URL url=new URL("http://127.0.0.1:4723");
		AndroidDriver driver=new AndroidDriver(url, options);
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
		System.out.println(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"));
		 /*this one is wiht coordinates
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "left",
			    "percent", 0.75
			));*/
		WebElement element=driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
			    "direction", "left",
			    "percent", 0.75
			));
		System.out.println(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"));

}
}