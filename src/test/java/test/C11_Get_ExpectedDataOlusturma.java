package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {
    @Test
    public void expectedDataOlusturma(){
        /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda donen response body’sinin
    asagida verilen ile ayni oldugunu test ediniz

   Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */
       // 1)Url hazırla
        String url=" https://jsonplaceholder.typicode.com/posts/22 ";
        //2)Expected data hazırla
        JSONObject expBody= new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put(    "title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
        //Response ı kaydet
        Response response=given().when().get(url);//Dönen responseın bodysi ile işlem yapmak istiyorsak bunu jSonpath objesine
        //dönüştürmemiz gerekiyor.Response bize jsonobject vermiyor.Response restassuredan geliyor.Jsonpath de restassurdan geliyor.
        JsonPath jsPath = response.jsonPath();
        response.prettyPrint();
        //Assert et
        Assert.assertEquals(expBody.get("userId"),jsPath.get("userId"));
        Assert.assertEquals(expBody.get("id"),jsPath.get("id"));
        Assert.assertEquals(expBody.get("title"),jsPath.get("title"));
        Assert.assertEquals(expBody.get("body"),jsPath.get("body"));

    }
}
