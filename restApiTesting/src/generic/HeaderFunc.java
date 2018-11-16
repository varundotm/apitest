package generic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class HeaderFunc {

	public static Headers headersto(String input) throws IOException{
		if("test".equals(input)) {
			String propertyFilePath=".//property//application.properties";
			BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
			Properties obj = new Properties();
			obj.load(reader);
			Header h1= new Header(obj.getProperty("headerKey1"), obj.getProperty("headerValue1"));
			Header h2 = new Header(obj.getProperty("headerKey2"), obj.getProperty("headerValue2"));
			Header h3 = new Header(obj.getProperty("headerKey3"), obj.getProperty("headerValue3"));
			List<Header> list = new ArrayList<Header>();
			list.add(h1);
			list.add(h2);
			list.add(h3);
			Headers headerto=new Headers(list);
			System.out.println(headerto);
			return headerto;
		}else {
			String propertyFilePath=".//property//kfka.properties";
			BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
			Properties obj = new Properties();
			obj.load(reader);
			Header h1= new Header(obj.getProperty("headerKey1"), obj.getProperty("headerValue1"));
			Header h2 = new Header(obj.getProperty("headerKey2"), obj.getProperty("headerValue2"));
			Header h3 = new Header(obj.getProperty("headerKey3"), obj.getProperty("headerValue3"));
			Header h4 = new Header(obj.getProperty("headerKey4"), obj.getProperty("headerValue4"));
			List<Header> list = new ArrayList<Header>();
			list.add(h1);
			list.add(h2);
			list.add(h3);
			list.add(h4);
			Headers headerto=new Headers(list);
			System.out.println(headerto);
			return headerto;		
		}
	}
}