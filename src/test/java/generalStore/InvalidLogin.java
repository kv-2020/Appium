package generalStore;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class InvalidLogin {
	@Test
	public void invalidlogintest() throws MalformedURLException, InterruptedException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		//options.setDeviceName("KVPixel6");
		options.setApp("C:\\Users\\kittu\\Appium\\Appium\\src\\test\\java\\appPackages\\General-Store.apk");
		URL url=new URL("http://127.0.0.1:4723");
		AndroidDriver driver=new AndroidDriver(url, options);
		Thread.sleep(3000);
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(By.xpath("(//android.widget.TextView)[8]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//String name=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		//System.out.println(name);
		//toast did not work
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage,"Please enter your name");


}
}