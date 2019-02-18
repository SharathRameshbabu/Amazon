package POM;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class SearchLaptopPage 
{
	
	@FindBy(className  = "android.widget.EditText")
	private WebElement srchtextbox;
	
	@FindBy(id = "in.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout")
	private WebElement clksrchres;

	public SearchLaptopPage(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void srchtextbox()
	{
		try
		{
			srchtextbox.isDisplayed();
			System.out.println("Search text box is displayed");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Search text box not present");
		}
		srchtextbox.sendKeys("Apple Laptops");
	}
	
	public void clksrchres()
	{
		try
		{
			clksrchres.isDisplayed();
			System.out.println("Apple laptops is displayed in search results");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Apple laptops is not displayed in search results");
		}
		clksrchres.click();
	}

}
