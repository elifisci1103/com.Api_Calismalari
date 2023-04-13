package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C09_Post_JsonPathIleBodyTesti {
    @Test
    public void jsonPath(){
    /*
            https://restful-booker.herokuapp.com/booking
             url’ine asagidaki body'ye sahip
            bir POST request gonderdigimizde
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
            donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
                "firstname“in,"Ali",
                ve "lastname“in, "Bak",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2021-06-01
                ve "checkout" tarihinin 2021-06-10
                ve "additionalneeds“in,"wi-fi"
            oldugunu test edin
     */
     //1-Url ve body hazırla
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject bookindDates=new JSONObject();
        bookindDates.put("checkin","2021-06-01");
        bookindDates.put("checkout","2021-06-10");

        JSONObject reqbody = new JSONObject();
        reqbody.put( "firstname" ,"Ali");
        reqbody.put( "lastname" , "Bak");
        reqbody.put( "totalprice" , 500);
        reqbody.put( "depositpaid" , false);
        reqbody.put( "bookingdates" ,bookindDates);
        reqbody.put("additionalneeds", "wi-fi");


    // Expected data hazırla
    // Response kaydet
        Response response=given().contentType(ContentType.JSON).when().body(reqbody.toString()).post(url);
        response.prettyPrint();

    //Assertion yap
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("booking.firstname", equalTo("Ali"),"booking.lastname"
                        ,equalTo("Bak"),"booking.bookingdates.checkin",equalTo("2021-06-01"));

    //Nested dönen responselarda response bodysini body matcher classı ile test edemeyiz.Bunun için response ı jsonpath formatına
        //dönüştürmemiz gerekir.




}}

