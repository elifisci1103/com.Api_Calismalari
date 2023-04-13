package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testData.TestdataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    @Test
    public void get01(){
    /*
  https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
  request yolladigimizda donen response’in status kodunun 200 ve
  response body’sinin asagida verilen ile ayni oldugunu test ediniz
   Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */

        TestdataJsonPlaceHolder testdataJsonPlaceHolder=new TestdataJsonPlaceHolder();
        JSONObject expData = testdataJsonPlaceHolder.expectedBodyOlusturJson();
        specJson.pathParams("pp1","posts","pp2",22);
        Response response = given().spec(specJson).when().get("/{pp1}/{pp2}");
        response.prettyPrint();
        JsonPath resJP =response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(resJP.get("userId"),expData.get("userId"));
        softAssert.assertEquals(resJP.get("id"),expData.get("id"));
        softAssert.assertEquals(resJP.get("title"),expData.get("title"));
        softAssert.assertEquals(resJP.get("body"),expData.get("body"));
        softAssert.assertEquals(testdataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        softAssert.assertAll();

}}
