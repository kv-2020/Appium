package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DeviceRotation1 {
	@Test
	public void devicetest() throws MalformedURLException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		//options.setDeviceName("KVPixel6");
		options.setApp("C:\\Users\\kittu\\Appium\\Appium\\src\\test\\java\\appPackages\\ApiDemos-debug.apk");
		URL url=new URL("http://127.0.0.1:4723");
		AndroidDriver driver=new AndroidDriver(url, options);
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landscape=new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String title=driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(title);
		Assert.assertEquals(title, "WiFi settings");
		driver.setClipboardText("kittu");//copy the text
		//driver.findElement(By.id("android:id/edit")).sendKeys("kittu");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());//paste the text
		driver.findElement(By.id("android:id/button1")).click();
		
		
		//key events home ,back,menu
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

}
}