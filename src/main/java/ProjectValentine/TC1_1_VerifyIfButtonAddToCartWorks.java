package ProjectValentine;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_1_VerifyIfButtonAddToCartWorks {

		@Test
		public static void testAddButtonWorks(){
			
		System.setProperty("webdriver.chrome.driver", "//Users//Serhiy//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		driver.navigate().to("http://awful-valentine.com/");
		
		String expectedPrice = driver.findElement(By.cssSelector(".special-item [href*='togetherness'] img+span")).getText();
		
		String expectedName = driver.findElement(By.cssSelector("#special-items > div:nth-child(1) > h4 > a")).getText();
		
		expectedName = expectedName.substring(expectedName.indexOf(""));
		
		expectedPrice = expectedPrice.substring(expectedPrice.indexOf("$") + 1).trim();
		
		driver.findElement(By.cssSelector(".special-item [href*='togetherness']+h4+div>a.add-to-cart")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='fancybox-content'] form [type='submit']")));
		
		String actualName = driver.findElement(By.cssSelector("#et-offer-post-30 > div > h2")).getText();
		
		actualName = actualName.substring(actualName.indexOf(""));
		
		System.out.println("Expected Name " + expectedName + "\nActualName " + actualName);
		
		Assert.assertEquals("Name don't match", expectedName, actualName);
		
		String actualPrice = driver.findElement(By.cssSelector("[id='fancybox-content'] form span")).getText();
		
		actualPrice = actualPrice.substring(actualPrice.indexOf("$") + 1).trim();
		
		System.out.println("Expected Price " + expectedPrice + "\nActual price " + actualPrice);
		
		Assert.assertEquals("Price don't match", expectedPrice, actualPrice);
		
		driver.findElement(By.cssSelector("[id='fancybox-content'] form [type='submit']")).click();
		
		driver.close();
	}
}
