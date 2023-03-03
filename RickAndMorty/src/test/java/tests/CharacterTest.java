package tests;


import dataProvider.ConfigProvider;
import entities.Character;
import entities.Root;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CharacterTest extends BaseRestAssured{
    @Test
    public void chechCharacter() {
        Root root = given()
                .log().all()
                .when()
                .contentType(ContentType.JSON)
                .get(ConfigProvider.CHARACTER)
                .then()
                .log().all()
                .statusCode(200)
                .extract().jsonPath().getObject("", Root.class);

        List<Character> list = Arrays.stream(root.getResults()).toList();

    }

}
