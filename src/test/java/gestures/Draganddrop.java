package gestures;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Draganddrop {
	@Test
	public void draganddroptest() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		
		options.setApp("C:\\Users\\kittu\\Appium\\Appium\\src\\test\\java\\appPackages\\ApiDemos-debug.apk");
		URL url=new URL("http://127.0.0.1:4723");
		AndroidDriver driver=new AndroidDriver(url, options);
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement element=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "endX", 635,
			    "endY", 580
			));
		
		String name=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getAttribute("text");
        // System.out.println(name);
		Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getAttribute("text"), name);
}
}