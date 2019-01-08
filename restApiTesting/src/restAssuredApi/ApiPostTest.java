package restAssuredApi;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic.BodyJson;
import generic.ExelData;
import generic.HeaderFunc;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiPostTest {
	
	@Test(dataProvider="dataset",invocationCount=5)
	public void postTest(String requestParams) throws IOException, ParseException, InterruptedException {
		RestAssured.baseURI ="http://104.211.178.63/TelematicsRESTService/services/ServiceProcess/DriverCreation";
		RequestSpecification request = RestAssured.given();
		request.headers(HeaderFunc.headersto("test"));
		request.body(BodyJson.sendJsonBody(requestParams,"test").toJSONString());
		Response response = request.post("");
		int statusCode = response.getStatusCode();
		String statusLine=response.getStatusLine();
		System.out.println("The status code recieved: " + statusCode);
		System.out.println("The status line recieved: " + statusLine);
		System.out.println("Response body: " + response.body().asString());
		Thread.sleep(3000);
		Assert.assertEquals(statusCode, 200);
	}
	@DataProvider
	public static Object[][] dataset() throws Exception{
		Object[][] datas=ExelData.getTableArray(".\\data\\testdata.xls", "jsonBody");
		return datas;
	}
}
