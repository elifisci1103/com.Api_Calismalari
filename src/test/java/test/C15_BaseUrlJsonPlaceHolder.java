package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C15_BaseUrlJsonPlaceHolder extends JsonPlaceHolderBaseUrl {
    @Test
    public void baseurl(){
    //Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
    /*
        1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET
         request gonderdigimizde donen response’un status code’unun 200 oldugunu
         ve Response’ta 100 kayit oldugunu test edin.
        */
        specJson.pathParam("pp1","posts");
        Response response=given().spec(specJson).when().get("/{pp1}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("id", Matchers.hasSize(100));}
@Test
    public void baseurl2() {
      /*  2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
            request gonderdigimizde donen response’un status code’unun 200 oldugunu
            ve “title” degerinin “optio dolor molestias sit” oldugunu test edin
         */
        specJson.pathParams("pp1","posts","pp2",44);
        Response response = given().spec(specJson).when().get("/{pp1}/{pp2}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("title",Matchers.equalTo("optio dolor molestias sit"));
        }
    @Test
    public void baseurl3() {
    /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
            response body’sinin null oldugunu test edin
         */
    specJson.pathParams("pp1","posts","pp2",50);
    Response response=given().spec(specJson).when().delete("/{pp1}/{pp2}");
    response.prettyPrint();
    response.then().assertThat().statusCode(200)
            .body("body",Matchers.nullValue());
}}
