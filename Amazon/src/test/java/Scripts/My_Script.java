package Scripts;

import org.testng.annotations.Test;

import Generic.BaseClass;
import POM.AmazonHomePage;
import POM.AppleLaptopPage;
import POM.FilterPage;
import POM.LeastPriceLaptopPage;
import POM.SearchLaptopPage;
import POM.SigninPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class My_Script extends BaseClass
{

	@Test

	public void script() throws InterruptedException
	{
		// To login with username and password in Amazon app
		SigninPage s = new SigninPage(driver);
		s.Signinbtn();
		s.usrnmtextbox();
		s.contbtn();
		s.pwdtextbox();
		s.loginbtn();
		System.out.println("***************************");
		System.out.println("Login successful");
		System.out.println("***************************");

		// To search the Apple Laptop
		AmazonHomePage a = new AmazonHomePage(driver);
		a.Srchbtn();

		// To find the Apple laptop and click the search results
		SearchLaptopPage sl = new SearchLaptopPage(driver);
		sl.srchtextbox();
		sl.clksrchres();

		// To filter only apple laptops
		FilterPage fp = new FilterPage(driver);
		fp.filtrbtn();
		fp.categbtn();
		fp.laptopbtn();
		Thread.sleep(2000);
		new TouchAction(driver).press(PointOption.point(500, 900)).waitAction().moveTo(PointOption.point(500, 600)).release().perform();
		fp.brandbtn();
		fp.applebrand();
		Thread.sleep(1000);

		// TouchAction to come out of the filter
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(183, 1047)).perform();

		// To iterate to lowest price AppleLaptop and click
		AppleLaptopPage page = new AppleLaptopPage(driver);
		page.findingTheLowsestPriceAppleProduct();
		page.scrollToTopPage();
		page.clikTheLowestPricedAppleElement(page.clickTheLowsetPriceAppleProduct());
		
		
		//To print the description of laptop and adding the product to cart
		Thread.sleep(3000);
		LeastPriceLaptopPage lp = new LeastPriceLaptopPage(driver);
		for(int i = 0;i<=1;i++)
		{
		new TouchAction(driver).press(PointOption.point(500, 1500)).waitAction().moveTo(PointOption.point(500, 450)).release().perform();
		}
		lp.add_to_cart_btn();
		lp.my_cart();
	}

}
