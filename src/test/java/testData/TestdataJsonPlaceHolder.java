package testData;

import baseUrl.JsonPlaceHolderBaseUrl;
import org.json.JSONObject;

public class TestdataJsonPlaceHolder {
    public int basariliStatusCode=200;
    public JSONObject expectedBodyOlusturJson(){

        JSONObject expectedBody=new JSONObject();
        expectedBody.put("userId",3);
        expectedBody.put("id",22);
        expectedBody.put( "title","dolor sint quo a velit explicabo quia nam");
        expectedBody.put( "body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");


        return expectedBody;
    }
}
