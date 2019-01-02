package automation.dynamiccode;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class PostmanApp {
	public static void main(String[] args) {
		try {
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			String fileToCompile = "tempcode/Test.java";
			int compilationResult = compiler.run(null, null, null, fileToCompile);
			if (compilationResult == 0) {
				System.out.println("Compilation is successful");
			} else {
				System.out.println("Compilation Failed");
			}
			URL classUrl = new File("tempcode").toURI().toURL();
			URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { classUrl });
			Class<?> testClass = Class.forName("Test", true, classLoader);
			Object testinstance = testClass.newInstance();
			Method[] methods = testClass.getMethods();
			for (Method method : methods) {
				System.out.println(method.getName());
				if (method.getName().equals("sayHello")) {
					method.invoke(testinstance, null);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
