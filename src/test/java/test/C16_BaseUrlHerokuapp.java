package test;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C16_BaseUrlHerokuapp extends HerokuAppBaseUrl {
   /* Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin

    {
        "firstname" : "Ahmet",
            "lastname" : “Bulut",
        "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
        "checkin" : "2021-06-01",
                "checkout" : "2021-06-10"
    },
        "additionalneeds" : "wi-fi"
    }*/

    @Test
    public void get01(){
       /* 1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve
        Response’ta 12 booking oldugunu test edin*/

        specHerokuApp.pathParam("pp1","booking");
        Response response=given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200)
                .body("booking", Matchers.hasSize(12));

    }
    @Test
    public void get02(){
       /* 2- https://restful-booker.herokuapp.com/booking
        endpointine asagidaki body’ye sahip bir POST
        request gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve “firstname”
        degerinin “Ahmet” oldugunu test edin*/
        specHerokuApp.pathParam("pp1","booking");
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin" , "2021-06-01");
        bookingdates.put("checkout" , "2021-06-10");
        JSONObject booking=new JSONObject();
        booking.put("firstname", "Ahmet");
        booking.put("lastname" , "Bulut");
        booking.put("totalprice" , 500);
        booking.put( "depositpaid", false);
        booking.put("bookingdates",bookingdates);
        booking.put( "additionalsneeds","wi-fi" );
        Response response = given().contentType(ContentType.JSON).spec(specHerokuApp).when().body(booking.toString()).post("/{pp1}");
       response.prettyPrint();
       response.then().assertThat().body("booking.firstname",Matchers.equalTo("Ahmet")).statusCode(200);


}}
