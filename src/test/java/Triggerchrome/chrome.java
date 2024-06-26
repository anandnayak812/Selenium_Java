package Triggerchrome;

import java.util.HashMap;
import java.util.List;

import org.apache.tools.ant.taskdefs.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;

public class chrome {
	static WebDriver driver;

//43+34
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\E008148\\eclipse-workspace123\\Practise\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		HashMap<String, String> map = new HashMap<String, String>();
		try {

			driver.get(
					"https://cdn3.digialm.com//per/g28/pub/2083/touchstone/AssessmentQPHTMLMode1//2083O24112/2083O24112S10D35189/17127743947449782/TL011201147_2083O24112S10D35189E2.html");
			driver.manage().window().maximize();
			waitfor(4);

			System.out.println();
			List<WebElement> likedButtons = driver
					.findElements(By.xpath("(//td[text()='Question ID :']/following-sibling::td)"));
			System.out.println(likedButtons.size());
			for (int i = 1; i <= 20; i++) {
				System.out.println(i);
				WebElement status = driver
						.findElement(By.xpath("(//td[text()='Status :']//following-sibling::td)[" + i + "]"));
				String flag = status.getText();

				if (flag.equals("Answered")) {
					waitfor(2);
					WebElement like = driver
							.findElement(By.xpath("(//td[text()='Question ID :']/following-sibling::td)[" + i + "]"));
					String storeAnswer = like.getText();

					WebElement option = driver.findElement(By.xpath(
							"((//td[text()='Question ID :']/following-sibling::td)//parent::tr//following-sibling::tr/td[text()='Chosen Option :']//following-sibling::td)["
									+ i + "]"));
					String Option = "";
					if (option.isDisplayed()) {
						String count = option.getText();
						WebElement chosen = driver.findElement(By.xpath("//td[text()='" + storeAnswer.trim()
								+ "']//parent::tr/following-sibling::tr/td[text()='Option " + count.trim()
								+ " ID :']//following-sibling::td"));
						System.out.println(chosen);
						scrolltoelement(like);
						Option = chosen.getText();
						waitfor(2);
					} else {
						WebElement answered = driver.findElement(
								By.xpath("(//td[text()='Given Answer :']//following-sibling::td)[" + i + "]"));
						Option = answered.getText();
					}
					map.put(storeAnswer, Option.trim());
				}

			}

			int correctAnswer = 0;
			int wrongAnswer = 0;
			driver.get("https://jeemainsession2.ntaonline.in/frontend/web/answer-key-challenge/candidate-challenge");
			driver.manage().window().maximize();
			for (int i = 1; i <= 20; i++) {
				WebElement ele = driver.findElement(By.xpath("//th[text()='" + i + ".']//following-sibling::td"));
				scrolltoelement(ele);
				WebElement ans = driver.findElement(
						By.xpath("(//th[text()='" + i + ".']//following-sibling::td//following-sibling::td)[1]"));
				String id = ele.getText();
				String pop = ans.getText();
				String value = map.get(id);
				if (value.contains(pop)) {
					correctAnswer++;
				} else {
					wrongAnswer++;
				}
				System.out.println(correctAnswer);
				System.out.println(wrongAnswer);
			}

			driver.quit();
		} catch (

		Exception e) {
			System.out.println(e);
			// driver.quit();
		}
	}

	public static void scrolltoelement(WebElement answer) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", answer);

	}

	public static void waitfor(int i) throws Throwable {
		Thread.sleep(i * 1000);
		// System.out.println(hello + ": of both " + n1 + " and " + n2 + " is : " +
		// value);
	}

	public static void clickMethod(String value, String log) throws Throwable {
		String key;
		switch (log) {
		case "1":
			String[] split = value.split(",");
			for (int i = 0; i < split.length; i++) {
				WebElement checkbox = driver.findElement(By.xpath("//span[text()='" + split[i] + "']"));
				checkbox.click();
				waitfor(4);
			}
			break;
		case "2":
			String[] splits = value.split(",");
			for (int i = 0; i < splits.length; i++) {
				WebElement checkbox = driver.findElement(By.xpath("//*[@name='" + splits[i] + "']"));
				if (splits[i].contains("pass") || splits[i].contains("email")) {
					if (splits[i].contains("pass")) {
						key = "############";
					} else {
						key = "##############";
					}
					checkbox.sendKeys(key);
				} else {
					checkbox.click();
				}
				waitfor(4);
			}
		}
	}
}
