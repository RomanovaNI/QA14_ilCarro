package com.ilCarro.qa14.API;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredTest {

    RequestSpecification httpRequest=io.restassured.RestAssured.given();

    @Test
    public void postNewUserRegistrationTest(){


        Response response = httpRequest.given().contentType(ContentType.JSON).
                given().header("Authorization", "bG92ZTFAbGwudWE6MTIzNEtLS0traw==").
                request().body("{\n" +
                "  \"first_name\": \"Zaza\",\n" +
                "  \"second_name\": \"ZZ\"\n" +
                "}").
                when().post("https://java-3-ilcarro-team-b.herokuapp.com/registration");

        String responseBody=response.getBody().asString();
        System.out.println(responseBody);

        int statusCode=response.getStatusCode();
        System.out.println(statusCode);

        JsonElement parsed=new JsonParser().parse(responseBody);
        String fName=parsed.getAsJsonObject().get("first_name").toString();
        System.out.println(fName);

        Assert.assertEquals(statusCode,200, "Bug: status code is coming different");
    }

    @Test
    public void deleteRegisteredUser(){
        Response response=httpRequest.given().header("Authorization", "bG92ZTFAbGwudWE6MTIzNEtLS0traw==").
                when().delete("https://java-3-ilcarro-team-b.herokuapp.com/user");

        int statusCode=response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode,200, "Bug: status code is coming different");
    }
}
