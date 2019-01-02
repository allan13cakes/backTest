package automation.client;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumClient {
	private Map<String,String> parameters =new HashMap<>();
	private WebDriver driver;
	
	public Map<String, String> getParameters() {
		return parameters;
	}

	public void initialize() {
		driver = new SafariDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void intialize(String remoteUrl) {
		//TODO
	}
	
	public void quit() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	public void openUrl(String url) {
		driver.get(url);
	}
	
	public WebElement findElement(String value) {
		return driver.findElement(By.xpath(value));
	}
	
	public void sendKeys(String locator,String value) {
		WebElement element = findElement(locator);
		element.sendKeys(value);
	}
	
	public void clickElement(String locator) {
		WebElement element = findElement(locator);
		element.click();
	}
	
	public void getElementText(String locator,String value) {
		WebElement element = findElement(locator);
		parameters.put(value, element.getText());
	}
	
	public void wait(int second) throws Exception {
		TimeUnit.SECONDS.sleep(second);
	}
	
	public static void main(String[] args) throws Exception {
		SeleniumClient client = new SeleniumClient();
		client.initialize();
		client.openUrl("https://www.baidu.com");
		TimeUnit.SECONDS.sleep(2);
		client.quit();
	}
}
