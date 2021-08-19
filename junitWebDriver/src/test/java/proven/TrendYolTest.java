package proven;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import java.util.List;

public class TrendYolTest extends ParentTest{

	static final Logger logger = LogManager.getLogger(TrendYolTest.class.getName());
	@Test
	public void favProduceTest() throws InterruptedException{
		navigateToPage("https://www.trendyol.com/giris");

		logger.info("proven");

		WebElement loginMail = driver.findElement(By.name("login email"));
		loginMail.sendKeys("ilhangursel@hotmail.com");

		WebElement loginPassword = driver.findElement(By.name("login-password"));
		loginPassword.sendKeys("123456Ab");

		WebElement clickLogin = driver.findElement(By.xpath("//button[@type='submit']"));
		clickLogin.click();
		Thread.sleep(1500);

		WebElement searchText = driver.findElement(By.xpath("//input[@type='text']"));
		Thread.sleep(500);

		searchText.sendKeys("iphone");
		Thread.sleep(500);

		WebElement searchIcon = driver.findElement(By.xpath("//i[@class='search-icon']"));

		searchIcon.click();
		Thread.sleep(1000);

		List<WebElement> lstElementsss = driver.findElements(By.className("prdct-desc-cntnr-wrppr"));
		String expectedProduceName = lstElementsss.get(1).getText();

		Thread.sleep(1000);

		List<WebElement> lstElements = driver.findElements(By.className("fvrt-btn"));
		lstElements.get(1).click();

		Thread.sleep(1000);

		WebElement clickFav = driver.findElement(By.xpath("//*[text()='Favorilerim']"));
		clickFav.click();

		Thread.sleep(1000);

		List<WebElement> listProduce = driver.findElements(By.className("prdct-desc-cntnr-wrppr"));
		String actualProduceName = listProduce.get(0).getText();


		Assert.assertEquals(actualProduceName.split("\\n")[0],expectedProduceName.split("\\n")[0]);

		Thread.sleep(1000);
		WebElement clickDelFav = driver.findElement(By.xpath("//i[@class='i-close']"));
		clickDelFav.click();

	}
	



	

}
