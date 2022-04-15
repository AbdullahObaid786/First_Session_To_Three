package launching;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	WebDriver web;

	@Before
	public void launching() {
		System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
		web = new ChromeDriver();
		web.manage().deleteAllCookies();
		web.manage().window().maximize();
		web.get("https://www.techfios.com/billing/?ng=admin/");
	}

	@Test
	public void loginTest() {
		web.findElement(By.id("username")).sendKeys("demo@techfios.com");
		web.findElement(By.id("password")).sendKeys("abc123");
		web.findElement(By.name("login")).click();
	}

	@Test
	public void NegLoginTest() {
		web.findElement(By.id("username")).sendKeys("demo@techfios.com");
		web.findElement(By.id("password")).sendKeys("abc123");
		web.findElement(By.name("login1")).click();
	}

	@After
	public void tearDown() {
		web.close();
		web.quit();
	}
}
