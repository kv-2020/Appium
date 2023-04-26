package generalStore;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProductSelect {
	@Test
	public void producttest() throws MalformedURLException, InterruptedException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		//options.setDeviceName("KVPixel6");
		options.setApp("C:\\Users\\kittu\\Appium\\Appium\\src\\test\\java\\appPackages\\General-Store.apk");
		URL url=new URL("http://127.0.0.1:4723");
		AndroidDriver driver=new AndroidDriver(url, options);
		Thread.sleep(3000);
		driver.findElement(By.id("android:id/text1")).click();
		 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));
		 driver.findElement(By.xpath("//android.widget.TextView[@text='Australia']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("kittu");
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		
		 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		List<WebElement>product=driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		System.out.println(product.size());
		System.out.println(product);
		for(int i=0;i<product.size();i++) {
			System.out.println(product.get(i).getAttribute("text"));
			if(product.get(i).getText().equalsIgnoreCase("Jordan 6 Rings")){
				 
				driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(i).click();
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		//cart page
		//driver.findElement(By.id("com.androidsample.generalstore:id/productName"))
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text" , "Cart"));
		String lastPageProduct =driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
		
		/*
		 * in product page and cart page i.e product and lastpageproduct element loctors are same
		 * so if our phone is slow then before the navigation from product page to cart page it will look at the same 
		 * locator and the test will fail so we use WebDriverWait
		 */

}
}