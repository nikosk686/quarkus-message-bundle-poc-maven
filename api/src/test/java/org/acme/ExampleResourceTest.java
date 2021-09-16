package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ExampleResourceTest {

    @ParameterizedTest
    @CsvSource({"en, Hello. Hello Nikos", "el, Γειά. Γειά σου Nikos"})
    void testHelloEndpoint(String lang, String output) {
        given()
          .when().get("/hello/" + lang)
          .then()
             .statusCode(200)
             .body(is(output));
    }

}