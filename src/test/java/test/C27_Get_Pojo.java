package test;

import baseUrl.BaseUrlDummy;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoDummyData;
import pojos.PojoDummyExpected;

import static io.restassured.RestAssured.given;

public class C27_Get_Pojo extends BaseUrlDummy {
    @Test
    public void get(){
     /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

	Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }

}*/
        //Url hazırla
        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);
        //Expected data hazırla
        PojoDummyData data =new PojoDummyData(3,"Ashton Cox",86000,66,"");
        PojoDummyExpected expectedData = new PojoDummyExpected("success",data,"Successfully! Record has been fetched.");
        System.out.println(expectedData);
        //Response
        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");
        response.prettyPrint();
        PojoDummyExpected resPojo=response.as(PojoDummyExpected.class);
       // 4)Assert et
        Assert.assertEquals(expectedData.getStatus(),resPojo.getStatus());
        Assert.assertEquals(expectedData.getMessage(),resPojo.getMessage());
        Assert.assertEquals(expectedData.getData().getId(),resPojo.getData().getId());
        Assert.assertEquals(expectedData.getData().getEmployee_name(),resPojo.getData().getEmployee_name());
        Assert.assertEquals(expectedData.getData().getEmployee_age(),resPojo.getData().getEmployee_age());
        Assert.assertEquals(expectedData.getData().getProfile_image(),resPojo.getData().getProfile_image());
}}