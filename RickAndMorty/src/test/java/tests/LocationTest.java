package tests;

import dataProvider.ConfigProvider;
import entities.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class LocationTest extends BaseRestAssured {
    @Test
    public void checkAllLocations() {
        List<Location> locations = given()
                .log().all()
                .when()
                .get(ConfigProvider.LOCATION)
                .then()
                .log().all()
                .statusCode(200)
                .extract().jsonPath().getList("results", Location.class);

        Assertions.assertEquals(20, locations.size());
    }

    @Test
    public void checkMultipleLocations() {
        int firstNumber = 5;
        int secondNumber = 15;
        List<Location> twoLocations = given()
                .log().all()
                .when()
                .get(String.format("%s/%d,%d", ConfigProvider.LOCATION, firstNumber, secondNumber))
                .then()
                .log().all()
                .statusCode(200)
                .extract().jsonPath().getList("", Location.class);

        Assertions.assertEquals(2, twoLocations.size());
        Assertions.assertArrayEquals(new int[]{firstNumber, secondNumber}, new int[]{twoLocations.get(0).getId(), twoLocations.get(1).getId()} );
    }
}
