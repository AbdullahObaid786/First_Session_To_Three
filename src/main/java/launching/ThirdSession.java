package launching;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThirdSession {
	WebDriver driver;

	@Before
	public void launching() {
		System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void login() {
		// There are many ways to use .SendKeys Method
//	 1-	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");

		// 2- ANOTHER way to use sendKeys is; using the WebElement class
		WebElement USERNAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		

		USERNAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc1234");
		SIGNIN_BUTTON_ELEMENT.click();

		// 3- Using thr By class and always Variable name Locator
		By USERNAME_LOCATOR = By.xpath("//input[@id='username']");
		By PASSWORD_LOCATOR = By.xpath("//*[@id=\"password\"]");
		By SIGNIN_IBUTTON_LOCATOR = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DASHBOARD_HEADER_LOCATOR = By.xpath("//h2[contains(text(), 'Dashboard' )]");
//		driver.findElement(USERNAME_LOCATOR).sendKeys("demo@techfios.com");
//	driver.findElement(PASSWORD_LOCATOR).sendKeys("abc123");
//	driver.findElement(SIGNIN_IBUTTON_LOCATOR).click(); 
		
		boolean pageTitleDisplayStatus;
		try {
			WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(), 'Dashboard' )]"));
			pageTitleDisplayStatus = true;
		}catch (Exception e) {
			pageTitleDisplayStatus = false;
			e.getStackTrace();
		}
//		WebDriverWait wait = new WebDriverWait(driver, 15);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_LOCATOR));
		Assert.assertTrue("wrong page!!", pageTitleDisplayStatus);
	}
}
