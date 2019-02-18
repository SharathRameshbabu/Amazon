package POM;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class AmazonHomePage extends BaseClass {

	@FindBy(id = "in.amazon.mShop.android.shopping:id/rs_search_src_text")

	private WebElement Srchbtn;

	public AmazonHomePage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void Srchbtn() {
		try {
			Srchbtn.isDisplayed();
			System.out.println("Search text box is present in Amazon Homepage");
		} catch (NoSuchElementException e) {
			System.out.println("Search text box is not present in Amazon Homepage");
		}
		Srchbtn.click();
	}

}
