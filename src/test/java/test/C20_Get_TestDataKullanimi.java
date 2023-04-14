package test;

import baseUrl.BaseUrlDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;

public class C20_Get_TestDataKullanimi extends BaseUrlDummy {
    @Test
    public void testDataKullanimi(){
    /*http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
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
        //1)Url hazırla
        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);
        //2)Expected hazırla
        TestDataDummy testDataDummy=new TestDataDummy();
        JSONObject expected = testDataDummy.expectedBody();
        //3)Response kaydet
        Response response = given().spec(specDummy).get("/{pp1}/{pp2}/{pp3}/{pp4}");
        JsonPath resJP=response.jsonPath();
        //4)Assert et
        Assert.assertEquals(expected.get("status"),resJP.get("status"));
        Assert.assertEquals(expected.getJSONObject("data").get("id"),resJP.get("data.id"));
        Assert.assertEquals(expected.getJSONObject("data").get("employee_name"),resJP.get("data.employee_name"));
        Assert.assertEquals(expected.getJSONObject("data").get("employee_salary"),resJP.get("data.employee_salary"));
        Assert.assertEquals(expected.getJSONObject("data").get("employee_age"),resJP.get("data.employee_age"));
        Assert.assertEquals(expected.getJSONObject("data").get("profile_image"),resJP.get("data.profile_image"));
        Assert.assertEquals(expected.get("message"),resJP.get("message"));


}}
