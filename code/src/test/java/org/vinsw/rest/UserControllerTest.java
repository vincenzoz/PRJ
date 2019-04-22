package org.vinsw.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.vinsw.security.builder.UserBuilder;
import org.vinsw.security.entity.User;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class UserControllerTest {

    @Before
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8082;
        RestAssured.basePath = "/user";
    }

    @Test
    public void pingTest() {
        given().when().get().then().statusCode(200).body(containsString("UP"));
    }

    @Test
    public void verifyJsonResponseType() {
        given().when().get("1").then().contentType(ContentType.JSON);
    }

    @Test
    public void checkPasswordValue() {
        Response response =
                given()
                        .when().get("1").then()
                        .contentType(ContentType.JSON).extract().response();
        response.jsonPath().getString("password").contentEquals("secret");
    }

    @Test
    public void checkUsernameValue() {
        given()
                .pathParam("userId", 1)
                .when().get("{userId}").then()
                .body(containsString("user"))
                .body("id", equalTo(1));
    }

    @Test
    public void addUser_OK() {
        given()
                .contentType(ContentType.JSON)
                .body(userBody())
                .when().post().then()
                .statusCode(200)
                .body(containsString(String.valueOf(CommonResponse.Status.SUCCESS)));
    }

    @Test
    public void addUser_KO_BadRequest() {
        given()
                .contentType(ContentType.JSON)
                .body(new UserBuilder().setId(20L).build())
                .when().post().then()
                .statusCode(400)
                .body(containsString(String.valueOf(CommonResponse.Status.INVALID_INPUT)));
    }

    private User userBody() {
        return new UserBuilder()
                .setId(1L)
                .setUsername("user")
                .setPassword("secret")
                .build();
    }
}
