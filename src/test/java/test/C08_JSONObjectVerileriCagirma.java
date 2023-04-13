package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JSONObjectVerileriCagirma {
    @Test
    public void jsonPath(){
    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888"
        },
        {
            "type": "home",
            "number": "0123-4567-8910"
        }
    ]
}
     */
        JSONObject homePhone = new JSONObject();
        homePhone.put("type","home");
        homePhone.put("number","0123-4567-8910");

        JSONObject ipPhone = new JSONObject();
        ipPhone.put("type","iphone");
        ipPhone.put("number","0123-4567-8888");

        JSONArray phoneNumbers =new JSONArray();
        phoneNumbers.put(0,ipPhone);
        phoneNumbers.put(1,homePhone);

        JSONObject address = new JSONObject();
        address.put( "streetAddress", "naist street");
        address.put("city", "Nara");
        address.put("postalCode", "630-0192");

        JSONObject profil = new JSONObject();
        profil.put( "firstName", "John");
        profil.put( "lastName", "doe");
        profil.put( "age", 26);
        profil.put( "address", address);
        profil.put( "phoneNumbers",phoneNumbers);

        System.out.println(profil);

//{"firstName":"John","lastName":"doe","address":{"streetAddress":"naist street","city":"Nara","postalCode":"630-0192"},
// "age":26,"phoneNumbers":[{"number":"0123-4567-8888","type":"iphone"},{"number":"0123-4567-8910","type":"home"}]}

        System.out.println("Kişi isim : "
                                       + profil.get("firstName"));
        System.out.println("Kişi soyisim :" +
                "                     "+ profil.get("lastName"));
        System.out.println("Kişi yaş : " +
                "                      "+ profil.get("age"));
        System.out.println("Sokak adı: "
                                        + profil.getJSONObject("address").get("streetAddress"));
        System.out.println("Sehir: "
                                         +profil.getJSONObject("address").get("city"));
        System.out.println("Tel: "
                                         + profil.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println("Type: "
                                          + profil.getJSONArray("phoneNumbers").getJSONObject(1).get("type"));






    }}

