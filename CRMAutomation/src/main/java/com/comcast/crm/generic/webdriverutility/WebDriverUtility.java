 package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.support.ui.Select; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}

	public void waitForElementPresent(WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void switchToTabonURL(WebDriver driver,String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it= set.iterator();
		while(it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			
			String actUrl= driver.getCurrentUrl();
			
		if (actUrl.contains(partialURL)) {
			break;
		}}}
		
	
	
		public void switchToTabonTitle(WebDriver driver,String partialTitle) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it= set.iterator();
			while(it.hasNext()) {
				String windowId = it.next();
				driver.switchTo().window(windowId);
				
				String actUrl= driver.getTitle();
				
			if (actUrl.contains(partialTitle)) {
				break;
			}
		}
		
		
	}
	// in case of utility or faramwork have u use any overloaded method so here is ans-----
	public void switchtoFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
		
	}
	
	public void switchtoFrame(WebDriver driver,String nameID) {
		driver.switchTo().frame(nameID);
		
	}
	
	public void switchtoFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
		
	}
	
	public void switchtoAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
		}
	
	public void switchtoAlertAndCancle(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		}

	
	public void Select(WebElement element, String text) {
	 Select sel = new Select(element);
	sel.selectByVisibleText(text);
	}
	
	public void Select(WebElement element, int index) {
		 Select sel = new Select(element);
		sel.selectByIndex(index);
		}
	public void mousemoveonElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleclick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
