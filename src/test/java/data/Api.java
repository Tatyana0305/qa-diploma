package data;

import io.restassured.http.ContentType;

import static data.DataHelper.validUser;
import static io.restassured.RestAssured.given;

public class Api {

    private final static String baseUri = "http://localhost:8080/api/v1";

    public static void payCard(String cardType, String post, int statusCode) {
        given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .body(validUser(cardType))
                .when()
                .post(post)
                .then()
                .statusCode(statusCode);
    }
}