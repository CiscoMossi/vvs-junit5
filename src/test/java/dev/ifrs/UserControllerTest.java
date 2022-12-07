package dev.ifrs;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UserControllerTest {
  @Test
  public void testCreateInvalidUser() {
      given()
        .when()
        .header("Content-Type", "application/json")
        .post("/user/register")
        .then()
           .statusCode(400)
           .body("message", is("Usuário Invalido"));
  }

  @Test
  public void testCreateInvalidPassword() {
      given()
        .when()
        .header("Content-Type", "application/json")
        .body("{\"name\":\"Teste\",\"password\":\"123\"}")
        .post("/user/register")
        .then()
           .statusCode(400)
           .body("message", is("Senha Invalida"));
  }

  @Test
  public void testCreateValidUser() {
      given()
        .when()
        .header("Content-Type", "application/json")
        .body("{\"name\":\"Teste\",\"password\":\"12345678910\"}")
        .post("/user/register")
        .then()
           .statusCode(201);
  }
}
