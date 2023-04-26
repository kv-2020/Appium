package gestures;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Scroll {
	@Test
	public void scrolltest() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		
		options.setApp("C:\\Users\\kittu\\Appium\\Appium\\src\\test\\java\\appPackages\\ApiDemos-debug.apk");
		URL url=new URL("http://127.0.0.1:4723");
		AndroidDriver driver=new AndroidDriver(url, options);
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		/*
		boolean canScrollMore;
		do {
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 500, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0));
		}
		while(canScrollMore);     */
		 
		/*
		 * here the  canScrollMore will scroll only little so to keep going till what we want we keep 
		 * going i.e till page end in do  while loop
		 * 
		 * this worked perfectly fine
		 * 
		 */
		
		//but this way of scrolling using JSE with coordinates is not much useful so we use Android UIautomaotr
		 
		//WebElement element=driver.findElement(AppiumBy.accessibilityId("WebView"));
		
      
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

       
	}//this line did not work

}
