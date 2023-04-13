package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {
    @Test
    public void jsonPathAssertion(){
        /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
    	                Request body
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
    	            }


    	            	Response Body-expected body
    	           {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":  "wi-fi";
                             }
                    }
         */
        //1)Body ve url hazırla
        String url="https://restful-booker.herokuapp.com/booking";
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
        System.out.println("req :"+booking);

        //2)Expected hazırla
        JSONObject expBody=new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",booking);
        System.out.println("expected body :" +expBody);
        //3)Response kaydet
        Response response = given().contentType(ContentType.JSON).body(booking.toString()).post(url);
        JsonPath jsonPath = response.jsonPath();
        response.prettyPrint();
        //Assert et
        Assert.assertEquals(expBody.getJSONObject("booking").get("firstname"),jsonPath.get("booking.firstname"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("lastname"),jsonPath.get("booking.lastname"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("totalprice"),jsonPath.get("booking.totalprice"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("depositpaid"),jsonPath.get("booking.depositpaid"));
        Assert.assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),jsonPath.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),jsonPath.get("booking.bookingdates.checkout"));
}}
