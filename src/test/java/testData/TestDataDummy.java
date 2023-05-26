package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataDummy {
    public int statusCode=200;
    public String contentType="application/json; charset=utf-8";

   /* Response Body
    {
        "status": "success",
            "data": {
                  "id": 3,
                "employee_name": "Ashton Cox",
                "employee_salary": 86000,
                "employee_age": 66,
                "profile_image": ""
    },
        "message": "Successfully! Record has been fetched."
    }*/
    public JSONObject expectedBody(){
       JSONObject data =new JSONObject();
       data.put("id", 3);
       data.put("employee_name", "Ashton Cox");
       data.put("employee_salary", 86000);
       data.put("employee_age", 66);
       data.put("profile_image", "");
        JSONObject expected=new JSONObject();
        expected.put( "status", "success");
        expected.put("data",data);
        expected.put("message", "Successfully! Record has been fetched.");
        return expected;
    }
    public HashMap expectedBodyMap(){
        HashMap<String,Object> data =new HashMap<>();
        data.put("id", 3.0);
        data.put("employee_name", "Ashton Cox");
        data.put("employee_salary", 86000.0);
        data.put("employee_age", 66.0);
        data.put("profile_image", "");
        HashMap<String,Object>expected=new HashMap<>();
        expected.put( "status", "success");
        expected.put("data",data);
        expected.put("message", "Successfully! Record has been fetched.");
        return expected;
    }
}
