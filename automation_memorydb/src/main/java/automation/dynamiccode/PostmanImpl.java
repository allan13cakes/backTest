package automation.dynamiccode;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PostmanImpl implements Postman {
	private PrintStream output;

	public PostmanImpl() throws Exception {
		output = new PrintStream(new FileOutputStream("msg.txt"));
	}

	@Override
	public void deliverMessage(String msg) {
		output.println(msg);
		output.flush();
	}

}
