package genericutilities;



import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	// This method is used to maximize the window
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	// This method is used to capture the size of the window
	public Dimension getSize(WebDriver driver) {
		return driver.manage().window().getSize();
	}

	// This method is used to switch windows
	public void switchWindow(WebDriver driver, String url) {
		// Capturing the Window ids
		Set<String> windows = driver.getWindowHandles();
		// Navigate to all the windows
		for (String wid : windows) {
			driver.switchTo().window(wid);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(url)) {
				break;
			}
		}
	}
		
		//This method is used to right click
		public void rightClick(WebDriver driver){
			Actions actions = new Actions(driver);
			actions.contextClick().perform();
			
		}
		// thois method is used for click and hold
		public void clickandHold(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).perform();
			
		}
		// This method is used to mouse hover on element
		public void mouseHoverElement(WebDriver driver, WebElement element) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();
		}

		// This method is used to mouse hover on element using offsets
		public void mouseHoverElement(WebDriver driver, WebElement element, int x, int y) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element, x, y).perform();
		}

		// This method is used to drag and drop
		public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
			Actions actions = new Actions(driver);
			actions.dragAndDrop(source, target).perform();
		}

		// This method is used to drag and drop
		public void dragAndDrop(WebDriver driver, WebElement element, int x, int y) {
			Actions actions = new Actions(driver);
			actions.dragAndDropBy(element, x, y).perform();
		}
		
		//This method is used to switchTo Frame by webwlement
		public void switchToFrame(WebDriver driver,WebElement frame) {
			driver.switchTo().frame(frame);
		}

		////This method is used to switchTo Frame by Index
		public void switchToFrame(WebDriver driver,int index) {
			driver.switchTo().frame(index);
		}
		////This method is used to switchTo Frame by id
		public void switchToFrame(WebDriver driver,String id) {
			driver.switchTo().frame(id);
		}
		//This method is used select dropdown by id 
		public void selectDropdownByIndex(WebDriver driver,WebElement element ,int index) {
			Select select = new Select(element);
			select.selectByIndex(index);
		}
		// This method is used to select dropdown by value
		public void selectDropdownByValue(WebDriver driver, WebElement element, String value) {
			Select select = new Select(element);
			select.selectByValue(value);
		}

		// This method is used to select dropdown by visibleText
		public void selectDropdownByText(WebDriver driver, WebElement element, String text) {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		}
//this method is used for switch to alert 
		public Alert switchToAlert(WebDriver driver) {
			return driver.switchTo().alert();	
		}
		//this method is used for switch to alert and accept
		public void switchToAlertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
			
		}
		//this method is used for switch to alert and dismiss
		public void switchToAlertAndDismiss(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		//this method is used for switch to alert and send keys
		public void switchToAlertAndsendKeys(WebDriver driver,String data) {
			driver.switchTo().alert().sendKeys(data);
		}
		//this method is used for switch to alert and get data
		public void switchToAlertAndgetdata(WebDriver driver) {
			driver.switchTo().alert().getText();
		}
		public void jsScoll(WebDriver driver,int x,int y){
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("Window, scrollBy("+x+","+y+")");
			
		}
		// This method is used to click using Javascript Executor
		public void jsClick(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("argument[0].click();", element);
		}

		// This method is used to scroll to bottom using Javascript Executor
		public void jsScrollToBottom(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		}

		// This method is used to TakeScreenshot with TimeStamp
		public void takeScreenshot(WebDriver driver, String timestamp) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File tempscreenshot = ts.getScreenshotAs(OutputType.FILE);
			File permanentscreenshot = new File("./Screenshots/screenshot_" + timestamp + ".png");
			FileUtils.copyFile(tempscreenshot, permanentscreenshot);
		}

	}

















