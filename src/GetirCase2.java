
import java.net.MalformedURLException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class GetirCase2 extends CapabilitiesClass {
	
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//...

		
		driver.findElementById("com.allandroidprojects.getirsample:id/btn_next").click();
		driver.findElementById("com.allandroidprojects.getirsample:id/btn_next").click();
		driver.findElementById("com.allandroidprojects.getirsample:id/btn_next").click();
		
		driver.findElementByXPath("//android.widget.Button[@text='GOT IT']").click();
		
		
		String dashboardCheckText = driver.findElementByXPath("//android.widget.TextView[@text='GetirSample']").getAttribute("name");
		
		try {
			//DASHBOARD EKRAN KONTROLU
			Assert.assertEquals("GetirSample", dashboardCheckText);
			System.out.println("Beklenen text değeri karşılandı dashboard düzgün geliyor = " + dashboardCheckText);
			
			
			driver.findElementByXPath("//*[@content-desc='Open navigation drawer']").click();
			
			int leftTabCount = driver.findElementsByXPath("//android.widget.CheckedTextView").size();
			int categoryCount = leftTabCount - 7;
			
			System.out.println("Kategori sayısı : " + categoryCount);
			
			Random r = new Random(); 
			int a = r.nextInt(categoryCount);
			driver.findElementsById("com.allandroidprojects.getirsample:id/design_menu_item_text").get(a).click();
			
			

			int wishImageSize = driver.findElementsById("com.allandroidprojects.getirsample:id/ic_wishlist").size();
			
			
			

			Random r2 = new Random(); 
			int a2 = r2.nextInt(wishImageSize);
			driver.findElementsById("com.allandroidprojects.getirsample:id/ic_wishlist").get(a2).click();
			
			Random r3 = new Random(); 
			int a3 = r3.nextInt(wishImageSize);
			driver.findElementsById("com.allandroidprojects.getirsample:id/ic_wishlist").get(a3).click();
			
			Random r4 = new Random(); 
			int a4 = r4.nextInt(wishImageSize);
			driver.findElementsById("com.allandroidprojects.getirsample:id/ic_wishlist").get(a4).click();
			
			driver.findElementByXPath("//*[@content-desc='Open navigation drawer']").click();
			
			driver.findElementByXPath("//android.widget.CheckedTextView[@text='My Wishlist']").click();
			
			int count = driver.findElementsByXPath("//android.widget.TextView[@text='Sample Item detail']").size();

			if (count == 3) {
				System.out.println("Istek listesine eklenen ürün adeti doğru geldiği teyit edildi = " + count);
				
				/*
				for (int i = 0; i<=count;i++)
				{
					driver.findElementsById("com.allandroidprojects.getirsample:id/ic_wishlist").get(1).click();
					
					
				}
				*/
				driver.findElementById("com.allandroidprojects.getirsample:id/ic_wishlist").click();
				driver.findElementById("com.allandroidprojects.getirsample:id/ic_wishlist").click();
				driver.findElementById("com.allandroidprojects.getirsample:id/ic_wishlist").click();
				
				
				int count2 = driver.findElementsByXPath("//android.widget.TextView[@text='Sample Item detail']").size();
				if (count2 == 0)
				{
					System.out.println("Ürünler başarıyla silindi!");
				}
				
			}else{
				System.out.println("Hatalı istek listesi tespit edildi!");
			}
			
		} catch (Exception e) {
			System.out.println("hata");
		}
		
		
		
		

		
		
		
		


	}

}
