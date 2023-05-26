package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoJsonReqBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_PojoClass extends JsonPlaceHolderBaseUrl {
    @Test
    public void put(){
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

    Expected Body

    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */
    //Url ve body hazırla
        specJson.pathParams("pp1","posts","pp2",70);
        PojoJsonReqBody reqBody = new PojoJsonReqBody("Ahmet","Merhaba",10,70);
        System.out.println(reqBody);
        //Expected Data hazırla
        PojoJsonReqBody expBody = new PojoJsonReqBody("Ahmet","Merhaba",10,70);//req ve exp aynı
        //Response kaydet
        Response response=given().spec(specJson).contentType(ContentType.JSON).when().body(reqBody).put("{pp1}/{pp2}");
        response.prettyPrint();
        PojoJsonReqBody resPojo = response.as(PojoJsonReqBody.class);

        //Assert et
        assertEquals(expBody.getTitle(),resPojo.getTitle());
        assertEquals(expBody.getBody(),resPojo.getBody());
        assertEquals(expBody.getUserId(),resPojo.getUserId());
        assertEquals(expBody.getId(),resPojo.getId());


}}
