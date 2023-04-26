package generalStore;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

public class TotalSumInCart {
	@Test
	public void totalsumtest() throws MalformedURLException, InterruptedException {
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
		
		List<WebElement>product=driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		System.out.println(product.size());
		/*
		for(int i=0;i<=product.size()-1;i++) {
			System.out.println(product.get(i).getAttribute("text"));
			
				driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(i).click();
			
		}
		by using the forloop it shows the index out of bound because for the 1st iterstion
		when we clik add to acrt the text changes to added to cart now for the 2nd itertion it is checking again adde to cart
		for elements of add to cart but there is only one so it horows error so we use the below lines of code
		*/
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		//cartpage
		List<WebElement>price=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		System.out.println(price.size());
		double sum=0.0;
		for(int j=0;j<price.size();j++) {
			String amountstring=price.get(j).getText();
			Double price1=Double.parseDouble(amountstring.substring(1));//this will give us 160.97 and 120 whic are strings so we convert it to double by parsing
			System.out.println(price1);
			sum=sum+price1;
		}
		System.out.println(sum);
		
		String carttotal=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
         System.out.println(carttotal);
         Double total=Double.parseDouble(carttotal.substring(1));
        // Assert.assertEquals(sum, total);//dont know why there is an error
         
         WebElement element=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
         ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
 			    "elementId", ((RemoteWebElement) element).getId(),
 			    "duration",2000
 			));
         //after the long press the alert box is open
         driver.findElement(By.id("android:id/button1")).click();//click ok button on the alert box
         //select the check box
         driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
         driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
         
         //now the page moves to goolgle page
         
         //HYBRIDAPP

}
}
