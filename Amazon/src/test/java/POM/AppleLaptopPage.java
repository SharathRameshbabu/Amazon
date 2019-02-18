package POM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppleLaptopPage 
{
	AndroidDriver<MobileElement> driver;

	public AppleLaptopPage(AndroidDriver<MobileElement> driver)
	{
		this.driver=driver;
	}

	List<Integer> convertedIntPrice;
	private By pricepath = By.xpath(".//*[@class='android.widget.ListView']//android.widget.LinearLayout//android.widget.TextView[contains(@text,'MacBook')]/../..//android.widget.TextView[contains(@text,'₹')][contains(@index,'0')]");
	public void findingTheLowsestPriceAppleProduct()
	{
		convertedIntPrice = new ArrayList<Integer>();
		for (int i = 0; i <= 15; i++) 
		{
			try 
			{
				List<MobileElement> ProducePricePath = driver.findElements(pricepath);
				for (WebElement m : ProducePricePath) 
				{
					String ProductPrice = m.getText();
					String ActualProductPrice = ProductPrice.substring(1, 9);
					String PriceWithoutCommaCharacter = ActualProductPrice.replaceAll(",", "");
					char[] charactersOfPriceWithoutCommaCharacter = ActualProductPrice.toCharArray();
					for (int j = 0; j < charactersOfPriceWithoutCommaCharacter.length; j++) 
					{
						if (charactersOfPriceWithoutCommaCharacter[j] == '₹') 
						{
							PriceWithoutCommaCharacter = PriceWithoutCommaCharacter.replaceFirst(String.valueOf(PriceWithoutCommaCharacter.charAt(j - 1)), "");
						}
					}
					PriceWithoutCommaCharacter = PriceWithoutCommaCharacter.trim();
					int PriceWithoutCommaCharacterConvertedtoString = Integer.parseInt(PriceWithoutCommaCharacter);
					convertedIntPrice.add(PriceWithoutCommaCharacterConvertedtoString);
					System.out.println(m.getText() + " edited -> " + ActualProductPrice + " converted -> " + PriceWithoutCommaCharacter);
				}
				//swiping down
				new TouchAction(driver).press(PointOption.point(550, 1650))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
						.moveTo(PointOption.point(550, 900)).release().perform();
			} 
			catch (NoSuchElementException e) 
			{
				System.out.println("Element not found");
			}
		}
	}
		
	public void scrollToTopPage()
	{
		for(int i=0;i<=7;i++)
		{
			new TouchAction(driver).press(PointOption.point(550, 800)).waitAction().moveTo(PointOption.point(550, 1710)).release().perform();
		}
	}
	
	public String clickTheLowsetPriceAppleProduct()
	{
		Collections.sort(convertedIntPrice);
		int lowestPrice = convertedIntPrice.get(0);
		String lowestPriceString = Integer.toString(lowestPrice);
		String LowestPriceWithComma =null;
		if(lowestPriceString.length()==5)
		{
			String a = lowestPriceString.substring(0, 2);
			String b = lowestPriceString.substring(2);
			LowestPriceWithComma = a+","+b;
		}
		else
		{
			String a = lowestPriceString.substring(0, 1);
			String b = lowestPriceString.substring(1, 3);
			String c = lowestPriceString.substring(3);
			LowestPriceWithComma = a+","+b+","+c;
		}
		System.out.println("now -> "+LowestPriceWithComma);
		return LowestPriceWithComma;
	}
	
	public void clikTheLowestPricedAppleElement(String LowestPriceWithComma)
	{
		for (int i = 0; i <= 15; i++) 
		{
			try 
			{
				List<MobileElement> ProducePricePath = driver.findElements(pricepath);
				int count = 0;
				for (WebElement m : ProducePricePath) 
				{
					String temp = m.getText();
					
					if(temp.contains("₹"+LowestPriceWithComma))
					{
						System.out.println("clicking on lowest price");
						System.out.println("(REFURBISHED) Apple MacBook Pro MD101HN/A 13-inch Laptop");
						m.click();
						count++;
					}
					
				}
				if(count ==1)
				{
					break;
				}
				new TouchAction(driver).press(PointOption.point(550, 1650))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
						.moveTo(PointOption.point(550, 900)).release().perform();
			} 
			catch (NoSuchElementException e) 
			{
				System.out.println("Element not found");
			}
		}
	}
}
	