package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidApp {
	@Test
	public void apptest() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		//options.setDeviceName("KVPixel6");
		options.setApp("C:\\Users\\kittu\\Appium\\Appium\\src\\test\\java\\appPackages\\ApiDemos-debug.apk");
		URL url=new URL("http://127.0.0.1:4723");
		AndroidDriver driver=new AndroidDriver(url, options);
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String title=driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(title);
		Assert.assertEquals(title, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("kittu");
		driver.findElement(By.id("android:id/button1")).click();
	}

}
