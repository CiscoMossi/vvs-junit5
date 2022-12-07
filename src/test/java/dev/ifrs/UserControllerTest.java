package dev.ifrs;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
class UserControllerTest {
  @Test
  void testRegisterInvalidUser() {
      given()
        .when()
        .header("Content-Type", "application/json")
        .post("/user/register")
        .then()
           .statusCode(400)
           .body("message", is("Usuário inválido"));
  }

  @Test
  void testRegisterInvalidName() {
      given()
        .when()
        .header("Content-Type", "application/json")
        .body("{\"name\":\"\",\"email\":\"Teste@teste.com\",\"password\":\"1234567890\",\"passwordConfirmation\":\"1234567890\"}")
        .post("/user/register")
        .then()
           .statusCode(400)
           .body(containsString("Nome inválido"));
  }

  @Test
  void testRegisterInvalidEmail() {
      given()
        .when()
        .header("Content-Type", "application/json")
        .body("{\"name\":\"Teste\",\"email\":\"teste.com\",\"password\":\"1234567890\",\"passwordConfirmation\":\"1234567890\"}")
        .post("/user/register")
        .then()
           .statusCode(400)
           .body(containsString("Email inválido"));
  }

  @Test
  void testRegisterInvalidPassword() {
      given()
        .when()
        .header("Content-Type", "application/json")
        .body("{\"name\":\"Teste\",\"email\":\"Teste@teste.com\",\"password\":\"123\",\"passwordConfirmation\":\"123\"}")
        .post("/user/register")
        .then()
           .statusCode(400)
           .body("message", is("Senha inválida"));
  }

  @Test
  void testRegisterIncorrectPasswordConfirmation() {
      given()
        .when()
        .header("Content-Type", "application/json")
        .body("{\"name\":\"Teste\",\"email\":\"Teste@teste.com\",\"password\":\"1234567890\",\"passwordConfirmation\":\"teste123\"}")
        .post("/user/register")
        .then()
           .statusCode(400)
           .body("message", is("As senhas não conferem"));
  }
  
  @Test
  void testRegisterInvalidPasswordConfirmation() {
      given()
        .when()
        .header("Content-Type", "application/json")
        .body("{\"name\":\"Teste\",\"email\":\"teste@teste.com\",\"password\":\"1234567890\"}")
        .post("/user/register")
        .then()
           .statusCode(400)
           .body(containsString("Confirmação de senha inválida"));
  }

  @Test
  void testRegisterInvalidBody() {
      given()
        .when()
        .body("{\"name\":\"Teste\",\"password\":\"123\"}")
        .post("/user/register")
        .then()
           .statusCode(415);
  }

  @Test
  void testRegisterValidUser() {
      given()
        .when()
        .header("Content-Type", "application/json")
        .body("{\"name\":\"Teste\",\"email\":\"Teste@teste.com\",\"password\":\"1234567890\",\"passwordConfirmation\":\"1234567890\"}")
        .post("/user/register")
        .then()
           .statusCode(201);
  }
}
