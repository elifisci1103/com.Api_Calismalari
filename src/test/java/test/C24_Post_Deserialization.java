package test;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataHerOkuapp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C24_Post_Deserialization extends HerokuAppBaseUrl {
    @Test
    public void postDeSerialization(){
    /*
      https://restful-booker.herokuapp.com/booking url'ine asagidaki
      body'ye sahip bir POST request gonderdigimizde donen response'un
      id haric asagidaki gibi oldugunu test edin.

        Request body
   {
        "firstname" : "Ali",
        "lastname" : "Bak",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
                 "checkin" : "2021-06-01",
                 "checkout" : "2021-06-10"
                          },
        "additionalneeds" : "wi-fi"
    }

       Response Body
       {
       "bookingid":24,
       "booking":{
           "firstname":"Ali",
           "lastname":"Bak",
           "totalprice":500,
           "depositpaid":false,
           "bookingdates":{
               "checkin":"2021-06-01",
               "checkout":"2021-06-10"
           },
           "additionalneeds":"wi-fi"
           }
       }
   */
        //1)Url ve body
        specHerokuApp.pathParam("pp1","booking");
        TestDataHerOkuapp testDataHerOkuapp = new TestDataHerOkuapp();
        HashMap<String,Object>reqBody=testDataHerOkuapp.reqBodyMap();
        //2)Expected hazırla
        HashMap<String,Object>expBody=testDataHerOkuapp.expBodyMap();
        //Response hazırla
        Response response=given().spec(specHerokuApp).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");
        HashMap<String,Object> resMap=response.as(HashMap.class);
        //Assert et
        Assert.assertEquals(((Map)expBody.get("booking")).get("firstname"),((Map)resMap.get("booking")).get("firstname"));
        Assert.assertEquals(((Map)expBody.get("booking")).get("lastname"),((Map)resMap.get("booking")).get("lastname"));
        Assert.assertEquals(((Map)expBody.get("booking")).get("totalprice"),((Map)resMap.get("booking")).get("totalprice"));
        Assert.assertEquals(((Map)expBody.get("booking")).get("depositpaid"),((Map)resMap.get("booking")).get("depositpaid"));
        Assert.assertEquals(((Map)((Map)expBody.get("booking")).get("bookingdates")).get("checkin"), ((Map)((Map)resMap.get("booking")).get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map)((Map)expBody.get("booking")).get("bookingdates")).get("checkout"), ((Map)((Map)resMap.get("booking")).get("bookingdates")).get("checkout"));
        Assert.assertEquals(((Map)expBody.get("booking")).get("wi-fi"),((Map)resMap.get("booking")).get("wi-fi"));

}}
