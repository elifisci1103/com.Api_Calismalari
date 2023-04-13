package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOluşturma {

@Test
        public void jsonObject(){

    //Asağıdaki json objesini oluşturup konsolda yazdırın.
   //{
   //      "title":"Ahmet",
   //     "body":"Merhaba",
   //     "user id":1
   // }

   JSONObject jsonObject=new JSONObject();
   jsonObject.put("title","Ahmet");
   jsonObject.put("body","Merhaba");
   jsonObject.put("user id",1);
    System.out.println(jsonObject);
}

@Test
public void jsonObject2(){
    JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");

    JSONObject outerJson = new JSONObject();

        outerJson.put("firstname","Jim");
        outerJson.put("additionalneeds","Breakfast");
        outerJson.put("bookingdates",bookingdates);
        outerJson.put("totalprice",111);
        outerJson.put("depositpaid",true);
        outerJson.put("lastname","Brown");

        System.out.println(outerJson);






}



}