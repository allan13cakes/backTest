package automation.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Demo {

	public static void main(String[] args) {
		Method[] methods = Demo.class.getMethods();
		for(Method method:methods) {
			System.out.println(method.getName());
			Parameter[] parameters = method.getParameters();
			for(Parameter parameter:parameters) {
				System.out.println(parameter.getName()+","+parameter.getType().getSimpleName()+","+parameter.getParameterizedType().getTypeName());
			}
		}

	}
	
	

}
