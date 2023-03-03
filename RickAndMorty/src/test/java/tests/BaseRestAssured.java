package tests;


import dataProvider.ConfigProvider;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseRestAssured {
    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = ConfigProvider.BASE_URL;
    }

}
