package launching;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondSession {
	WebDriver drive;

	@Before
	public void launchingBrowser() {
		System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
		drive = new ChromeDriver();
		drive.manage().deleteAllCookies();
		drive.manage().window().maximize();
		drive.get("https://objectspy.space/");
		drive.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Login() {
		// Element Locators: Name - Attribute
		drive.findElement(By.name("firstname")).sendKeys("Abdullah");
		drive.findElement(By.name("Password")).sendKeys("2123456");

		// ID - Attribute
		// drive.findElement(By.id("photo")).sendKeys("C:\\Users\\Abdul\\OneDrive\\Desktop\\TechFios
		// QA\\Selenium\\PowerPoint Slides\\Session 1--2022-02-20.pptx");

		// ClassName - Attribute
		drive.findElement(By.className("input-file"))
				.sendKeys("C:\\Users\\Abdul\\OneDrive\\Desktop\\TechFios QA\\Selenium\\All Codes\\4th class codes.txt");

		// Link Text - HyperLink
		// drive.findElement(By.linkText("OS-API Product FrontEnd")).click();

		// Partial Link Text - Part of the HyperLink
		// drive.findElement(By.partialLinkText("TF-API")).click();

		// CSS Selector : TagName#Value
		drive.findElement(By.cssSelector("input#sex-0")).click();

		// CSS Selector : TagName[attribute = ‘value’]
//	drive.findElement(By.cssSelector("input[id='exp-3']")).click();
		drive.findElement(By.cssSelector("input[name='exp'][id='exp-6']")).click();

		// Xpath
		// Xpath: Absolute - starts with a slash /
		drive.findElement(By.xpath("html/body/div/div[2]/div[2]/form/div[10]/input")).sendKeys("I'm The Legend");
		// Xpath : //Tag[@Attribute Node=‘Value’]
		drive.findElement(By.xpath("//input[@id='profession-1']")).click();
		// Xpath: //Tag[@ Attribute Node =‘Value’ and @ Attribute Node =‘Value’ ]
		drive.findElement(By.xpath("//input[@name='tool' and @id='tool-2']")).click();
		// Xpath for the links: //Tag[text()='value'] or //Tag[contains(text(),'value')]
		drive.findElement(By.xpath("//strong[text()='Link Test : New Page']")).click();
		// or
		drive.findElement(By.xpath("//strong[contains(text(),'Link Test : New Page')]")).click();

	}
}
