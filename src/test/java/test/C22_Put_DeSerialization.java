package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestdataJsonPlaceHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz

    Request Body

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

    Expected Data :

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

     */
    @Test
    public void put(){
        //1)Url ve request body hazırla
        specJson.pathParams("pp1","posts","pp2",70);
        TestdataJsonPlaceHolder testdataJsonPlaceHolder=new TestdataJsonPlaceHolder();
       HashMap<String,Object> reqBody= testdataJsonPlaceHolder.requestBody();
       //Expected data hazırla
        HashMap<String,Object> expBody= testdataJsonPlaceHolder.requestBody(); //Normalde tekrar expected data hazırlamak
        //gerekir ancak bu soruda exp ve req body aynı olduğu için yeni bir değer atayarak onu kullanıyoruz.
        //Response hazırla
        Response response=given().spec(specJson).contentType(ContentType.JSON).when().body(reqBody).put("/{pp1}/{pp2}");
        response.prettyPrint();
        HashMap<String,Object>respMap=response.as(HashMap.class);//Bu adımda De-Serialization işlemi yapıldı.Response json dönüyo biz
        //onu map e ceviriyoruz.
        //Assert et
        Assert.assertEquals(testdataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(expBody.get("id"), respMap.get("id"));
        Assert.assertEquals(expBody.get("title"), respMap.get("title"));
        Assert.assertEquals(expBody.get("body"), respMap.get("body"));
        Assert.assertEquals(expBody.get("userId"), respMap.get("userId"));
    }
}
