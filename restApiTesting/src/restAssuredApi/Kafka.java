package restAssuredApi;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.BodyJson;
import generic.ExelData;
import generic.HeaderFunc;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Kafka {
	public class ApiPostTest {
		@Test(dataProvider="data")
		public void postTest(String requestParams) throws IOException, ParseException {
			RestAssured.baseURI ="http://172.16.2.193:9091/kafka/pushAssetDataKafka/";
			RequestSpecification request = RestAssured.given();
			request.headers(HeaderFunc.headersto("te"));
			request.body(BodyJson.sendJsonBody(requestParams,"t").toJSONString());
			Response response = request.post("");
			int statusCode = response.getStatusCode();
			String statusLine=response.getStatusLine();
			System.out.println("The status code recieved: " + statusCode);
			System.out.println("The status line recieved: " + statusLine);
			System.out.println("Response body: " + response.body().asString());
		}
		@DataProvider
		public Object[][] data() throws Exception{
			Object[][] datas=ExelData.getTableArray(".\\data\\input.xls", "input");
			return datas;
		}
	}
}
