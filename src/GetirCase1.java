import java.net.MalformedURLException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import static io.appium.java_client.touch.offset.ElementOption.element;


public class GetirCase1 extends CapabilitiesClass {

	
	
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		
		driver.findElementById("com.allandroidprojects.getirsample:id/btn_next").click();
		driver.findElementById("com.allandroidprojects.getirsample:id/btn_next").click();
		driver.findElementById("com.allandroidprojects.getirsample:id/btn_next").click();
		
		driver.findElementByXPath("//android.widget.Button[@text='GOT IT']").click();
		
		//driver.findElementByXPath("//*[@content-desc='Open navigation drawer']").click();
	
		driver.findElementByXPath("//android.widget.TextView[@text='BABY CARE']").click();
		
		
		
		
		String dashboardCheckText = driver.findElementByXPath("//android.widget.TextView[@text='GetirSample']").getAttribute("name");

		try {
			//DASHBOARD EKRAN KONTROLU
			Assert.assertEquals("GetirSample", dashboardCheckText);
			System.out.println("Beklenen text değeri karşılandı dashboard düzgün geliyor = " + dashboardCheckText);
			
			//EKRANDA GORUNEN URUNLERIN SAYISI ALINARAK, O SAYIYA KADAR RANDOM SAYI URETILDI
			//RASTGELE OLARAK GELEN SAYI INDEX NUMARASINA GORE URUN ACILIR.
			int count = driver.findElementsByXPath("//android.widget.TextView[@text='Sample Item detail']").size();
			System.out.println("Ekranda tıklanabilir ürün sayısı = " + count);
			
			
				Random r = new Random(); 
				int a = r.nextInt(count);
			
			driver.findElementsById("com.allandroidprojects.getirsample:id/image1").get(a).click();
			
			
			 
			driver.findElementByXPath("//android.widget.TextView[@text='ADD TO CART']").click();
			
			
			
			String toastMessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
	
			
			try {
				//URUN EKLENDIKTEN SONRA EKRANA CIKAN UYARI MESAJININ GELIP GELMEDIGI KONTROLU YAPILIR.
				Assert.assertEquals("Item added to cart.", toastMessage);
				System.out.println("Ürün başarıyla eklendi.");
				
				//GERI BUTONU ILE BIR ONCE KI SAYFAYA GELINIR.
				driver.navigate().back();
				
				
				WebElement item1 = driver.findElementByXPath("//android.widget.TextView[@text='WATER']");
				WebElement item2 = driver.findElementByXPath("//android.widget.TextView[@text='FRUITS & VEG']");
				
				//TÜR BAR'I SAĞA DOĞRU KAYDIRILARAK ISTENILEN "SNACKS" SEKMESINE ULAŞILIR
				TouchAction t = new TouchAction(driver);
				t.longPress(longPressOptions().withElement(element(item1)).withDuration((ofSeconds(1)))).moveTo(element(item2)).release().perform();

				
				driver.findElementByXPath("//android.widget.TextView[@text='SNACKS']").click();
				
				
				
				int count2 = driver.findElementsByXPath("//android.widget.TextView[@text='Sample Item detail']").size();
				System.out.println("Ekranda tıklanabilir ürün sayısı = " + count);
				
				
					Random r2 = new Random(); 
					int a2 = r.nextInt(count2);
				
				driver.findElementsById("com.allandroidprojects.getirsample:id/image1").get(a2).click();
				
				driver.findElementByXPath("//android.widget.TextView[@text='ADD TO CART']").click();
				
				String toastMessage2 = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
				
				try {
					//URUN EKLENDIKTEN SONRA EKRANA CIKAN UYARI MESAJININ GELIP GELMEDIGI KONTROLU YAPILIR.
					Assert.assertEquals("Item added to cart.", toastMessage);
					System.out.println("Ürün başarıyla eklendi.");
					
					//GERI BUTONU ILE BIR ONCE KI SAYFAYA GELINIR.
					driver.navigate().back();
					
					
					driver.findElementById("com.allandroidprojects.getirsample:id/action_cart").click();
					
					
					String priceText = driver.findElementByXPath("//android.widget.TextView[@text='$3.96']").getAttribute("name");
					
					try {
						Assert.assertEquals("$3.96", priceText);
						System.out.println("Toplam fiyat teyit edildi.");
						
						
						driver.findElementByXPath("//android.widget.TextView[@text='Remove']").click();
						driver.findElementByXPath("//android.widget.TextView[@text='Remove']").click();
						
						
						String priceText2 = driver.findElementByXPath("//android.widget.TextView[@text='$0.00']").getAttribute("name");
						
						try {
							Assert.assertEquals("$0.00", priceText2 );
							System.out.println("Ürünler başarılı bir şekilde silindi!");
						}
						catch(Exception e) {
							System.out.println("Hata tespit edildi.");
						}
						
					}
					catch (Exception e) {
						System.out.println("Hata tespit edildi.");
					}
					
				}
				catch (Exception e) {
					System.out.println("Hata tespit edildi.");
				}
				
				}
				catch(Exception e) {
					System.out.println("Hata tespit edildi.");
				}
			
			
			
			}
			catch(Exception e) {
				System.out.println("Hata tespit edildi.");
			}
		
		
		//driver.findElementsByClassName("android.widget.TextView").get(1).click();
	

	}

}
