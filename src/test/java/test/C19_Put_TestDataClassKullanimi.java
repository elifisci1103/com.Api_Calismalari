package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestdataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C19_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    @Test
    public void put(){
   /* https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
    PUT request yolladigimizda donen response’in
    status kodunun 200, content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
    {
        "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
    }
    Expected Data :
    {
        "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
    }*/
        specJson.pathParams("pp1","posts","pp2",70);
        TestdataJsonPlaceHolder testdataJsonPlaceHolder=new TestdataJsonPlaceHolder();
        JSONObject requestBody=testdataJsonPlaceHolder.reqbodyOlustur();
        Response response=given().contentType(ContentType.JSON).spec(specJson).when().body(requestBody.toString()).put("/{pp1}/{pp2}");
        JsonPath resJP = response.jsonPath();
        response.prettyPrint();
        JSONObject expectedData=testdataJsonPlaceHolder.expectedData();
        System.out.println(expectedData);
        Assert.assertEquals(expectedData.getJSONObject("Expected Data").get("title"),resJP.get("title"));
        Assert.assertEquals(expectedData.getJSONObject("Expected Data").get("body"),resJP.get("body"));
        Assert.assertEquals(expectedData.getJSONObject("Expected Data").get("userId"),resJP.get("userId"));
        Assert.assertEquals(expectedData.getJSONObject("Expected Data").get("id"),resJP.get("id"));
        Assert.assertEquals(testdataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(testdataJsonPlaceHolder.contentType,response.getContentType());
        Assert.assertEquals(testdataJsonPlaceHolder.coonectionHeader,response.getHeader("Connection"));

}}
