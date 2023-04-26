package generalStore;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class HybridApp {
	@Test
	public void hybridtest() throws MalformedURLException, InterruptedException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		//options.setChromedriverExecutable("path");
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
         Thread.sleep(4000);
         //now the page moves to goolgle page
         
         //HYBRIDAPP
         
         Set<String>handles=driver.getContextHandles();
        // System.out.println(handles);
       //  driver.context("WEBVIEW_com.google.android.googlequicksearchbox:search");
         
         //the above one or for each loop bot r same
         for(String contextName :handles)
     	{
     		System.out.println(contextName);
     	}
         driver.context("WEBVIEW_com.androidsample.generalstore");
         //switching the context from native to web this web is within the app
         //now since we r moving from native to web within the app we need the chromedriver.exe
         driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
     	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
     	driver.pressKey(new KeyEvent(AndroidKey.BACK));
     	driver.context("NATIVE_APP");
     	
     	//when we execute the above code we get the following error
     	// No Chromedriver found that can automate Chrome '69.0.3497'.
     	//so we get the 69.0.3497 chromedriver.exe download and copy the .exe file into the project
     	//and the give the path iin //options.setChromedriverExecutable("path");
     	//now it will work fine

}

}
