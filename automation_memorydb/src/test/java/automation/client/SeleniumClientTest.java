package automation.client;

import org.junit.Test;

public class SeleniumClientTest {
	private SeleniumClient client = new SeleniumClient();

	@Test
	public void test() {
		try {
			client.initialize();
			client.openUrl("https://www.baidu.com");
			client.sendKeys("//input[@id='kw']", "test");
			client.clickElement("//input[@id='su']");
			 client.getElementText("//span[@class='nums_text']", "result");
			 System.out.println(client.getParameters().get("result"));
			client.wait(10);
			client.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
