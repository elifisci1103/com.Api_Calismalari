package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataHerOkuapp {
    public int basariliStatusCode = 200;

    public TestDataHerOkuapp() {
    }

    public JSONObject bookingdatesJson() {
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");
        return bookingdates;
    }

    public JSONObject reqBodyJson() {
        JSONObject booking = new JSONObject();
        booking.put("firstname", "Ali");
        booking.put("lastname", "Bak");
        booking.put("totalprice", 500);
        booking.put("depositpaid", false);
        booking.put("bookingdates", bookingdatesJson());
        booking.put("additionalneeds", "wi-fi");
        return booking;
    }

    public JSONObject expBodyJson() {
        JSONObject expBody = new JSONObject();
        expBody.put("bookingid", 24);
        expBody.put("booking", reqBodyJson());
        return expBody;}

    public HashMap bookingdatesMap() {
            HashMap<String,Object>bookingdatesMap = new HashMap<>();
            bookingdatesMap.put("checkin", "2021-06-01");
            bookingdatesMap.put("checkout", "2021-06-10");
            return bookingdatesMap;}

        public HashMap reqBodyMap() {
            HashMap<String,Object> booking = new HashMap<>();
            booking.put("firstname", "Ali");
            booking.put("lastname", "Bak");
            booking.put("totalprice", 500.0);
            booking.put("depositpaid", false);
            booking.put("bookingdates", bookingdatesMap());
            booking.put("additionalneeds", "wi-fi");
            return booking;
        }

    public HashMap expBodyMap() {
        HashMap<String,Object> expBody = new HashMap<>();
        expBody.put("bookingid", 24);
        expBody.put("booking",reqBodyMap());
        return expBody;}
    }

