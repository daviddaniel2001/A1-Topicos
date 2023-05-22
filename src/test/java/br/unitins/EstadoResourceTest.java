package br.unitins;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import br.unitins.model.Estado;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import jakarta.transaction.Transactional;

@QuarkusTest
public class EstadoResourceTest {

    @Test
    @Transactional
    public void testGetAll() {
        given()
                .when().get("/estados")
                .then()
                .statusCode(200)
                .body(is("[4, São Paulo, 4]"));
    }

    @Test
    @Transactional
    public void testInsert() {
        Estado dto = new Estado();
        dto.setNome("São Paulo");

        given()
                .body(dto)
                .contentType(ContentType.JSON)
                .when().post("/estados")
                .then()
                .statusCode(201)
                .body("nome", is("São Paulo"));
    }

    @Test
    @Transactional
    public void testUpdate() {
        Estado dto = new Estado();
        dto.setNome("São Paulo");

        given()
                .body(dto)
                .contentType(ContentType.JSON)
                .when().put("/estados/1")
                .then()
                .statusCode(200)
                .body("nome", is("São Paulo"));
    }

    @Test
    @Transactional
    public void testCount() {
        given()
                .when().get("/estados/count")
                .then()
                .statusCode(200)
                .body(is("1"));
    }

    @Test
    @Transactional
    public void testSearch() {
        given()
                .when().get("/estados/search/Teste")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    @Transactional
    public void testDelete() {
        given()
                .when().delete("/estados/1")
                .then()
                .statusCode(204);
    }
}
