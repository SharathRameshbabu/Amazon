package POM;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class FilterPage 
{
	
	@FindBy(id  = "in.amazon.mShop.android.shopping:id/rs_filter_header_label")
	private WebElement filtrbtn;
	
	@FindBy(id = "in.amazon.mShop.android.shopping:id/rs_refinement_group_content")
	private WebElement categbtn;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc=\"Laptops\"]")
	private WebElement laptopbtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Brand']")
	private WebElement brandbtn;
	
	@FindBy(id = "in.amazon.mShop.android.shopping:id/rs_refinements_child_indicator")
	private WebElement applebrand;
	
	
	
	public FilterPage(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public void filtrbtn()
	{
		try
		{
			filtrbtn.isDisplayed();
			System.out.println("Filter button is present");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Filter button is not present");
		}
		filtrbtn.click();
	}
	
	public void categbtn()
	{
		try
		{
			categbtn.isDisplayed();
			System.out.println("Category option under filter is present");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Category option under filter is not present");
		}
		categbtn.click();
	}
	
	public void laptopbtn()
	{
		try
		{
			laptopbtn.isDisplayed();
			System.out.println("Laptop button under categories is present");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Laptop button under categories is not present");
		}
		laptopbtn.click();
		
		try
		{
			laptopbtn.isSelected();
			System.out.println("Laptop option is selected");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Laptop option is not selected");
		}
		
	}
	
	
	
	public void brandbtn()
	{
		try
		{
			brandbtn.isDisplayed();
			System.out.println("Brand button is present");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Brand button is not present");
		}
		brandbtn.click();
	}
	
	public void applebrand()
	{
		try
		{
			applebrand.isDisplayed();
			System.out.println("Apple option is present under brand category");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Apple option is not present under brand category");
		}
		applebrand.click();
		try
		{
			applebrand.isSelected();
			System.out.println("Apple brand option is selected");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Apple brand option is not selected");
		
		}
	}
	
	


}
