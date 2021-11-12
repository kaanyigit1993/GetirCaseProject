

import java.net.MalformedURLException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class GetirCase3Bug1 extends CapabilitiesClass {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		try {

			driver.findElementById("com.allandroidprojects.getirsample:id/btn_next").click();
			driver.findElementById("com.allandroidprojects.getirsample:id/btn_next").click();
			driver.findElementById("com.allandroidprojects.getirsample:id/btn_next").click();
			
			driver.findElementByXPath("//android.widget.Button[@text='GOT IT']").click();
			
			driver.findElementsById("com.allandroidprojects.getirsample:id/image1").get(1).click();
			
			driver.findElementByXPath("//android.widget.TextView[@text='BUY NOW']").click();
			
			driver.findElementById("com.allandroidprojects.getirsample:id/text_action2").click();
			
		}catch (Exception e) {
			System.out.println("Edit butonu tıklanmıyor!");
		}
		
		
	}

}
