package test;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoHerOkuAppExpected;
import pojos.PojoHerokuAppBooking;
import pojos.PojoHerokuAppBookingDates;

import static io.restassured.RestAssured.given;

public class C26_Post_Pojo extends HerokuAppBaseUrl {
    @Test
    public void post(){
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ali",
    	                "lastname" : “Bak",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }


    	            	Response Body = Expected Data
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
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */
        //1)Url ve body hazırla
        specHerokuApp.pathParam("pp1","booking");
        PojoHerokuAppBookingDates bookingDates = new PojoHerokuAppBookingDates("2021-06-01","2021-06-10");
        PojoHerokuAppBooking reqBody = new PojoHerokuAppBooking("Ali","Bak",500,false,bookingDates,"wi-fi");
        //Expected data hazırla
        PojoHerOkuAppExpected expectedData = new PojoHerOkuAppExpected(24,reqBody);
        //Response
        Response response=given().spec(specHerokuApp).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");
        response.prettyPrint();
         PojoHerOkuAppExpected resPojo = response.as(PojoHerOkuAppExpected.class);

        Assert.assertEquals(expectedData.getBookingid(),resPojo.getBookingid());
        Assert.assertEquals(expectedData.getBooking().getFirstname(),resPojo.getBooking().getFirstname());
        Assert.assertEquals(expectedData.getBooking().getLastname(),resPojo.getBooking().getLastname());
        Assert.assertEquals(expectedData.getBooking().getTotalprice(),resPojo.getBooking().getTotalprice());
        Assert.assertEquals(expectedData.getBooking().isDepositpaid(),resPojo.getBooking().isDepositpaid());
        Assert.assertEquals(expectedData.getBooking().getBookingDates().getCheckin(),resPojo.getBooking().getBookingDates().getCheckin());
        Assert.assertEquals(expectedData.getBooking().getBookingDates().getCheckin(),resPojo.getBooking().getBookingDates().getCheckout());
        Assert.assertEquals(expectedData.getBooking().getAdditionalneeds(),resPojo.getBooking().getAdditionalneeds());

}}
