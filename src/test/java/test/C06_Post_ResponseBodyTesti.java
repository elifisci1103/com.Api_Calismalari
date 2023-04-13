package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Post_ResponseBodyTesti {
    @Test
    public void postResponseBody(){
    /*  https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde
  {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }

        donen Response’un,

        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
      */
        String url="https://jsonplaceholder.typicode.com/posts";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","API");
        jsonObject.put("body","API ogrenmek ne guzel");
        jsonObject.put("userId",10);
        System.out.println(jsonObject);
        Response response=given().contentType(ContentType.JSON).when().body(jsonObject.toString()).post(url);
        response.prettyPrint();
        response.then().assertThat().statusCode(201).contentType(ContentType.JSON)
                .body("title", Matchers.equalTo("API"))
                .body("userId",Matchers.lessThan(100)).body("body",Matchers.containsString("API"));
}}
