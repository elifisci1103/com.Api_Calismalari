package testData;

import baseUrl.JsonPlaceHolderBaseUrl;
import org.json.JSONObject;

import java.util.HashMap;

public class TestdataJsonPlaceHolder {
    public int basariliStatusCode=200;
    public String contentType="application/json; charset=utf-8";
    public String coonectionHeader="keep-alive";
    public JSONObject expectedBodyOlusturJson(){

        JSONObject expectedBody=new JSONObject();
        expectedBody.put("userId",3);
        expectedBody.put("id",22);
        expectedBody.put( "title","dolor sint quo a velit explicabo quia nam");
        expectedBody.put( "body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");


        return expectedBody;
    }
    public JSONObject reqbodyOlustur(){
        JSONObject reqBody =new JSONObject();
        reqBody.put("title", "Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put( "id",70);
     return reqBody;
    }
    /*Expected Data :
    {
       title": "Ahmet" ",
            "body": "Merhaba",
            "userId": 10,
            "id": 70*/

    public JSONObject expectedData(){
        JSONObject expected = new JSONObject();
        expected.put("Expected Data",reqbodyOlustur());
    return expected;}

    public HashMap requestBody(){
        HashMap<String,Object>reqBody=new HashMap<>();
        reqBody.put( "title", "Ahmet");
        reqBody.put("body", "Merhaba");
        reqBody.put("userId", 10.0);
        reqBody.put("id", 70.0);
        return reqBody;

        }
}
