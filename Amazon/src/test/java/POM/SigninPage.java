package POM;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class SigninPage extends BaseClass 
{

	@FindBy(id = "in.amazon.mShop.android.shopping:id/sign_in_button")
	private WebElement Signinbtn;
	
	@FindBy(className  = "android.widget.EditText")
	private WebElement usrnmtextbox;
	
	@FindBy(className = "android.widget.Button")
	private WebElement contbtn;
	
	@FindBy(xpath  = "//android.view.View[1]/android.view.View[8]/android.view.View[2]/android.widget.EditText")
	private WebElement pwdtextbox;
	
	@FindBy(className = "android.widget.Button")
	private WebElement loginbtn;

	

	public SigninPage(AndroidDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void Signinbtn() 
	{
		try
		{
		Signinbtn.isDisplayed();
		System.out.println("Already a customer--Signin button exists");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Already a customer--Signin button does not exist");
		}
		Signinbtn.click();
	}
	
	public void usrnmtextbox()
	{
		try
		{
			usrnmtextbox.isDisplayed();
			System.out.println("Username text box is present");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Username text box does not exist");
		}
		usrnmtextbox.sendKeys("8553323800");
	}
	
	public void contbtn()
	{
		try
		{
			contbtn.isDisplayed();
			System.out.println("Continue button is present");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Continue button is present");
		}
		contbtn.click();
	}
	
	public void pwdtextbox()
	{
		try
		{
			pwdtextbox.isDisplayed();
			System.out.println("Password textbox is present");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Password text box is not present");
		}
		pwdtextbox.sendKeys("PSharu07$#");
	}
	
	public void loginbtn()
	{
		try
		{
			loginbtn.isDisplayed();
			System.out.println("Login button is present");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Login button is not present");
		}
		loginbtn.click();
	}
	

}
