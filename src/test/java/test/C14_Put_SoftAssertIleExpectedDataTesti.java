package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {
    /*
https://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki
body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
       Request Body
       {
           "status":"success",
           "data":{
                   "name":“Ahmet",
                   "salary":"1230",
                   "age":"44",
                   "id":40
                   }
       }
       Response Body
       {
       "status":"success",
       "data":{
           "status":"success",
           "data":{
                   "name":“Ahmet",
                   "salary":"1230",
                   "age":"44",
                   "id":40
                   }
              },
       "message":"Successfully! Record has been updated."
       }
            */
    @Test
    public void put01(){
        // 1 - URL ve body olustur, Put metodu icin body gerekli

        String url = "https://dummy.restapiexample.com/api/v1/update/21";

        /*
        Request Body
            {
                "status":"success",
                "data":{
                        "name":“Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
            }
         */
        JSONObject data = new JSONObject();
        JSONObject reqBody = new JSONObject();

        data.put("name","Ahmet");
        data.put("salary","1230");
        data.put("age","44");
        data.put("id",40);

        reqBody.put("data",data);
        reqBody.put("status","success");
        System.out.println("req :"+reqBody);

        // 2 - Expected Data hazirla

        /*
        {
            "status":"success",
            "data":{
                "status":"success",
                "data":{
                        "name":“Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                        }
                   },
            "message":"Successfully! Record has been updated."
            }
         */

        JSONObject expData = new JSONObject();

        expData.put("status","success");
        expData.put("data",reqBody);
        expData.put("message","Successfully! Record has been updated.");
        System.out.println("expected:"+expData);
        // 3 - Response'u kaydet

        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                put(url);
        response.prettyPrint();
        JsonPath resJP = response.jsonPath();

     //4)Assert et
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(resJP.get("status"),expData.get("status"));
        softassert.assertEquals(resJP.get("message"),expData.get("message"));
        softassert.assertEquals(resJP.get("data.status"),expData.getJSONObject("data").get("status"));
        softassert.assertEquals(resJP.get("data.data.name"),expData.getJSONObject("data").getJSONObject("data").get("name"));
        softassert.assertEquals(resJP.get("data.data.id"),expData.getJSONObject("data").getJSONObject("data").get("id"));
        softassert.assertEquals(resJP.get("data.data.salary"),expData.getJSONObject("data").getJSONObject("data").get("salary"));
        softassert.assertEquals(resJP.get("data.data.age"),expData.getJSONObject("data").getJSONObject("data").get("age"));
}}
