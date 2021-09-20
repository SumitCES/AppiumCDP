package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ClassMain {

	@Test

	public void Launch() throws MalformedURLException, InterruptedException {
       //Xpath By Locators
		
		By lblAzamTvMax = By.xpath("//android.widget.TextView[@text='AZAMTV MAX']");		
		By lbl_Language_Eng=By.xpath("//android.widget.TextView[@text='English']");
			
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("devicename", "emulator-5554");
		dc.setCapability("appPackage", "com.azamtv.max.media");
		dc.setCapability("appActivity", "com.azamtv.max.media.MainActivity");
		dc.setCapability("platformName", "Android");
		AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),
				dc);
        driver.resetApp();
		Thread.sleep(5000);
		ClickAndroidElementOptional(driver, "get started");
		Thread.sleep(5000);
		WaitForElementTobeVisible(driver, lbl_Language_Eng, 10);
		ClickAndroidElementWithText(driver,"English");	
		ClickAndroidElementOptional(driver, "Continue");
		WaitForElementTobeVisible(driver, lblAzamTvMax, 10);	
		
		
		
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[3]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView\r\n"
				)).click();
		
		
		Thread.sleep(6000);
		
				
				
//		driver.findElementByXPath("//android.widget.TextView[@text='Max Movies']/android.widget.ImageView").click();
//		Thread.sleep(5000);
//		
		
		
		driver.quit();

	}

	
	
	
	public static void ClickAndroidElementOptional(AppiumDriver<MobileElement> driver, String sElementText) {
		List<MobileElement> els = driver.findElementsByClassName("android.widget.TextView");
		if (els.size() > 0) {
			for (MobileElement el : els)
				if (el.getText().toLowerCase().trim().equals(sElementText.trim().toLowerCase())) {
					el.click();
					System.out.println("Clicked " + sElementText);
					break;
				}
		}
	}
	
	
	public static void ClickAndroidElementWithText(AppiumDriver<MobileElement> driver, String sElementText) {
		List<MobileElement> els = driver.findElementsByClassName("android.widget.TextView");
		if (els.size() > 0) {
			for (MobileElement el : els)
				if (el.getText().toLowerCase().trim().equals(sElementText.trim().toLowerCase())) {
					el.click();
					System.out.println("Clicked " + sElementText);
					break;
				}
		}
		
		else {
			
			System.err.println("Could not locate element with text " + sElementText);
		}
	}


	public static void WaitForElementTobeVisible(AppiumDriver<MobileElement> driver, By MobileElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		MobileElement el = null;
		el = (io.appium.java_client.MobileElement) wait
				.until(ExpectedConditions.visibilityOfElementLocated(MobileElement));
		if (String.valueOf(el).toLowerCase() == "null") {
			System.err.println("Element not Visible " + MobileElement.toString());
		} else {
			System.out.println("Element Not Visible " + MobileElement.toString());
		}
	}
	



}
