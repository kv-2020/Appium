package gestures;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Exercise {
	@Test
	public void exercisetest() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		
		options.setApp("C:\\Users\\kittu\\Appium\\Appium\\src\\test\\java\\appPackages\\ApiDemos-debug.apk");
		URL url=new URL("http://127.0.0.1:4723");
		AndroidDriver driver=new AndroidDriver(url, options);
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Alert Dialogs']")).click();
         driver.findElement(By.id("io.appium.android.apis:id/text_entry_button")).click();
         driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("kittu");
         driver.findElement(By.id("io.appium.android.apis:id/password_edit")).sendKeys("kittu");
         driver.findElement(By.id("android:id/button1")).click();
         
}
}