package com.ilCarro.qa14.API;


import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class APITest {
    String baseUrl = "https://java-3-ilcarro-team-b.herokuapp.com";

    @Test
    public void loginRegisteredUserPositiveTest() throws IOException {
        String response = getAuthorizationUser(baseUrl + "/user/login", "Authorization", "bGxAbGwudWE6MTIzNEtLS0traw==");
        System.out.println(response);

        JsonElement parsed = new JsonParser().parse(response);

        JsonElement name = parsed.getAsJsonObject().get("first_name");
        Assert.assertEquals(name.toString(), "\"Leila\"");

        JsonElement registrationDate = parsed.getAsJsonObject().get("registration_date");
        Assert.assertEquals(registrationDate.toString(), "\"2021-06-07\"");

    }

    @Test
    public void loginRegisteredUserWithWrongPasswordNegativeTest() throws IOException {
        int statusCode = Request.Get(baseUrl + "/user/login").
                addHeader("Authorization", "bGxAbGwudWE6MTIzNEtLS0aw==").
                execute().returnResponse().getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 400);
    }

    public String getAuthorizationUser(String controller, String key, String value) throws IOException {
        return Request.Get(controller)
                .addHeader(key, value)
                .execute().returnContent().asString();
    }

    @Test
    public void postNewUserRegistrationTest() throws IOException {
        String response = Request.Post(baseUrl + "/registration").
                addHeader("Authorization", "bG92ZUBsbC51YToxMjM0S0tLS2tr").
                bodyString("{\n" +
                        "  \"first_name\": \"Test\",\n" +
                        "  \"second_name\": \"Test\"\n" +
                        "}", ContentType.APPLICATION_JSON).
                execute().returnContent().asString();
        System.out.println(response);
    }

    @Test
    public void deleteRegisteredUser() throws IOException {
        int statusCode = Request.Delete(baseUrl + "/user").
                addHeader("Authorization", "bG92ZUBsbC51YToxMjM0S0tLS2tr").
                execute().returnResponse().getStatusLine().getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
    }
@Test
    public void deleteRegisteredUser2() throws IOException {
    String response = Request.Delete(baseUrl + "/user").
            addHeader("Authorization", "a3dAa3cuY29tOjEyM0tlbldpbGxpYW1z").
            execute().returnContent().asString();
    System.out.println(response);
    }

//267dd4c32f4445b08558cfc3cb56077d


}
