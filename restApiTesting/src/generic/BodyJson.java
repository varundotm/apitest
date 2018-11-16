package generic;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BodyJson {


	public static JSONObject sendJsonBody(String requestParams,String arg) throws ParseException {

		JSONParser parser = new JSONParser(); 

		JSONObject json = (JSONObject) parser.parse(requestParams);

		ArrayList<JSONObject> arrayL=new ArrayList<JSONObject>();

		arrayL.add(json);

		//System.out.println(arrayL);
		JSONObject sendJsonBodyobj = new JSONObject();
		if("test".equals(arg)) {
			sendJsonBodyobj.put("VALUES", arrayL);
		}else {
			sendJsonBodyobj.put("LocationData", arrayL);
		}

		System.out.println(sendJsonBodyobj.toJSONString());
		return sendJsonBodyobj;

	}



}

