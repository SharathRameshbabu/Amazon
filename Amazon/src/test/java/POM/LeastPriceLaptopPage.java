package POM;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LeastPriceLaptopPage 
{
	@FindBy(xpath = ".//*[@text = 'Add to Cart']")
	private WebElement add_to_cart_btn;
	
	@FindBy(id = "in.amazon.mShop.android.shopping:id/action_bar_cart_image")
	private WebElement my_cart;
	
	public LeastPriceLaptopPage(AndroidDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void add_to_cart_btn()
	{
		try
		{
			add_to_cart_btn.isDisplayed();
			System.out.println("Add to Cart button is present");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Add to Cart button is not present");
		}
		add_to_cart_btn.click();
		
	}
	
	public void my_cart()
	{
		try
		{
			my_cart.isDisplayed();
			System.out.println("Cart option is present");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Cart option not present");
		}
		my_cart.click();
		
		try
		{
		String val = my_cart.getText().toString();
		System.out.println(val);
		System.out.println("Smallest price apple laptop present in cart : " +val );
		}
		catch(Exception e)
		{
			System.out.println("No element present in cart");
		}
	}

}
