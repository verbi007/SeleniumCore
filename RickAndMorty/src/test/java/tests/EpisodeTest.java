package tests;

import dataProvider.ConfigProvider;
import entities.Episode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

import static io.restassured.RestAssured.given;

public class EpisodeTest extends BaseRestAssured {
    @Test
    public void checkAllEpisodes() {
        List<Episode> episodes = given()
                .log().all()
                .when()
                .get(ConfigProvider.EPISODE)
                .then()
                .log().all()
                .statusCode(200)
                .extract().jsonPath().getList("results", Episode.class);
        Assertions.assertEquals(20, episodes.size());
    }
}
