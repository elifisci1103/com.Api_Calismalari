package test;

import baseUrl.BaseUrlDummy;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C23_Get_DeSerialization extends BaseUrlDummy {
    @Test
    public void get01(){
/*   http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un status code’unun 200, content Type’inin
    application/json ve body’sinin asagidaki gibi oldugunu test edin.
    Response Body
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
   //Url hazırla
        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);
        //Expected Body hazırla
        TestDataDummy testDataDummy = new TestDataDummy();
       HashMap<String,Object> expectedData=testDataDummy.expectedBodyMap();
       //Response hazırla
        Response response = given().spec(specDummy).get("/{pp1}/{pp2}/{pp3}/{pp4}");
        HashMap<String,Object> resMap=response.as(HashMap.class);
        //Assert et
        Assert.assertEquals(testDataDummy.statusCode,response.getStatusCode());
      //  Assert.assertEquals(testDataDummy.contentType,response.getContentType());
        Assert.assertEquals(expectedData.get("status"),resMap.get("status"));
        Assert.assertEquals(((Map)expectedData.get("data")).get("id"),((Map)resMap.get("data")).get("id"));
        Assert.assertEquals(((Map)expectedData.get("data")).get("employee_name"),((Map)resMap.get("data")).get("employee_name"));
        Assert.assertEquals(((Map)expectedData.get("data")).get("employee_salary"),((Map)resMap.get("data")).get("employee_salary"));
        Assert.assertEquals(((Map)expectedData.get("data")).get("employee_age"),((Map)resMap.get("data")).get("employee_age"));
        Assert.assertEquals(((Map)expectedData.get("data")).get("profile_image"),((Map)resMap.get("data")).get("profile_image"));
        Assert.assertEquals(expectedData.get("message"),resMap.get("message"));
}}
