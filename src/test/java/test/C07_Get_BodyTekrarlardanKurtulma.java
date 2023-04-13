package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;

public class C07_Get_BodyTekrarlardanKurtulma {
    @Test
    public void tekrarlardanKurtarma(){
         /*
                https://restful-booker.herokuapp.com/booking/14018 url’ine
                bir GET request gonderdigimizde donen Response’un,

                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"James",
                    ve "lastname“in, "Brown",
                    ve "totalprice“in, 111,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin

         */
       /* String url="https://restful-booker.herokuapp.com/booking/10";
        Response response =given().when().get(url);
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Susan"),
                        "lastname", Matchers.equalTo("Smith"),
                            "totalprice", Matchers.equalTo(563),
                        "depositpaid",Matchers.equalTo(false),"additionalneeds",Matchers.nullValue());*/

        String url="https://restful-booker.herokuapp.com/booking/10";
        Response response =given().when().get(url);
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("firstname", equalTo("Susan"),
                        "lastname", equalTo("Smith"),
                        "totalprice", equalTo(563),
                        "depositpaid",equalTo(false),"additionalneeds",nullValue());
        //Matchers clasını silsek bile equal to metodunu import edersek hata vermez.Yukarıdaki import kısmına equal to
        //yerine * koyarsak o classdaki her metodu kullanablrz.
    }
}
