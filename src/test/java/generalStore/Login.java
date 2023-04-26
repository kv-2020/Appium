package generalStore;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Login {
	@Test
	public void logintest() throws MalformedURLException, InterruptedException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		//options.setDeviceName("KVPixel6");
		options.setApp("C:\\Users\\kittu\\Appium\\Appium\\src\\test\\java\\appPackages\\General-Store.apk");
		URL url=new URL("http://127.0.0.1:4723");
		AndroidDriver driver=new AndroidDriver(url, options);
		Thread.sleep(3000);
		
		
		driver.findElement(By.id("android:id/text1")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[text()='Antarctica']")).click();
		//driver.findElement(By.xpath("(//android.widget.TextView)[8]")).click();
		//WebElement element= driver.findElement(By.xpath("//android.widget.TextView[@text='India']"));
		//this line is only for scrolling and then when u want to select Inndia we use line 30
		 //this line of scrolling worked perfectly
		 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));

		 driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("kittu");
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//this worked perfectly fine
		

}
}