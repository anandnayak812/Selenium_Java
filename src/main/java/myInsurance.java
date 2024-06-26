import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.openqa.selenium.remote.server.handler.GetTitle;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.relevantcodes.extentreports.HTMLReporter;

public class myInsurance {
	static WebDriver driver;

	static String Gmail = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=3&rip=3&hl=en&flowName=GlifWebSignIn&flowEntry=ServiceLogin%22";
	static ExtentTest test;
	static ExtentReports report;
	static ChromeOptions options = new ChromeOptions();
	static boolean status = false;

	public static void main(String[] args) throws Throwable {
		try {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "driver" + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Browser is Launched");
			driver.manage().window().maximize();
			driver.get("https://wallet.ewatpa.com/public/login");
			System.out.println("EWA url is opened");
			highlightElement(driver.findElement(By.xpath("//input[@placeholder='Username']")));
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("anand.banoth@cigniti.com");
			Thread.sleep(5000);
			highlightElement(driver.findElement(By.xpath("//input[@placeholder='Password']")));
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Anand@123");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[text()=' Log in ']")).click();
			Thread.sleep(5000);
			System.out.println("User is Logged in");
			String msg = selectPatient("Swapna");
			loginToGmail();
			composeEmail("anandnayak812@gmail.com", "Swapna :- Your Status of insurance is " + msg);
			status = true;
		} finally {
			if (status == true) {
				driver.quit();
				System.out.println("Successfully Executed");
			}

		}
	}

	public static String selectPatient(String name) throws Throwable {
		// ion-label[contains(text(),' Swapna ')]//parent::div
		highlightElement(driver.findElement(By.xpath("//ion-label[contains(text(),'" + name + "')]//parent::div")));
		driver.findElement(By.xpath("//ion-label[contains(text(),'" + name + "')]//parent::div")).click();
		Thread.sleep(5000);

//		WebElement viewAll = driver.findElement(By.xpath(
//				"//ion-label[text()='Your Recent Claims (1)']//parent::ion-col//following::ion-label[contains(text(),'View All')]"));
//		scrollToElement(viewAll);
//		if (viewAll.isDisplayed()) {
//			viewAll.click();
//		} else {
//			System.out.println("Element Not Found");
//		}
		Thread.sleep(5000);
		scrollToElement(driver.findElement(By.xpath("(//ion-col/*[contains(text(),'Status')]/span)[1]")));
		highlightElement(driver.findElement(By.xpath("(//ion-col/*[contains(text(),'Status')]/span)[1]")));
		String Status = driver.findElement(By.xpath("(//ion-col/*[contains(text(),'Status')]/span)[1]")).getText();

		System.out.println(Status);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(@class,'QSR')]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[contains(text(),'Logout')]//parent::ion-col")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()=' Cancel ']")).click();
		Thread.sleep(5000);
		return Status;
	}

	public static void scrollToElement(WebElement Text) {
		try {
			WebElement element = Text;

			((JavascriptExecutor) driver)
					.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
		} catch (Exception e) {
			System.out.println("Element not found for Scrolling --> " + e.getMessage());

		}
	}

	public static void loginToGmail() throws InterruptedException, Throwable {
		driver.get(Gmail);
		Thread.sleep(5000);

		// WebElement gmailNext = driver.findElement(By.xpath("//span[text()='Next']"));
		String username = "vocautomation12@gmail.com";
		String password = "Mayur123$";

		Thread.sleep(5000);
		WebElement gmailUsername = driver.findElement(By.xpath("//*[@type='email']"));
		gmailUsername.sendKeys(username);
		gmailUsername.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		WebElement gmailPassword = driver.findElement(By.xpath("//*[@type='password']"));
		highlightElement(gmailPassword);
		gmailPassword.sendKeys(password);
		gmailPassword.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

	}

	public static void composeEmail(String To, String Body) throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@class='agP aFw']")).sendKeys(To);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='aoT']")).sendKeys("From Automation");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(Body);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[text()='Send']")).click();
		Thread.sleep(10000);
	}

	public static void highlightElement(WebElement element) throws Throwable {
		System.out.println("Highlighting WebElemnt On UI !!");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
	}

	public static void extentReport() {

	}

	public static void startTest() throws Throwable {

	}

	public static void capture(WebDriver webdriver, String fileWithPath) throws Exception {
		System.out.println("Hello");

	}

}
