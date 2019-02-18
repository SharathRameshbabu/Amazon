package Generic;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass implements Constant 
{
	public AndroidDriver<MobileElement> driver;
	DesiredCapabilities cap;

	@BeforeSuite

	public void setup()
	{

		try {
			cap = new DesiredCapabilities();
			cap.setCapability("automationName", automationName);
			cap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
			cap.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
			cap.setCapability("deviceName", deviceName);
			cap.setCapability("platformName", platformName);
			cap.setCapability("platformVersion", platformVersion);
			cap.setCapability("autoGrantPermissions", "true");
			cap.setCapability("fullReset", "false");
			cap.setCapability("noReset", "false");
			
			//Instantiate Android Driver session
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			} 
		catch (Exception e)
			{
			System.out.println("Unable to launch app");
			}
		
		String windowName = driver.currentActivity();
		System.out.println("Window name is :" + windowName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}

}
