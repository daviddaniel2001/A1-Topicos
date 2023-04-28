package br.unitins;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import br.unitins.model.Municipio;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.transaction.Transactional;

@QuarkusTest
public class MunicipioResourceTest {

    @Test
    @Transactional
    public void testGetAll() {
        given()
                .when().get("/municipios")
                .then()
                .statusCode(200)
                .body(is("[Rio de Janeiro, 2]"));
    }

    @Test
    @Transactional
    public void testInsert() {
        Municipio dto = new Municipio();
        dto.setNome("Rio de Janeiro");

        given()
                .body(dto)
                .contentType(ContentType.JSON)
                .when().post("/municipios")
                .then()
                .statusCode(201)
                .body("nome", is("Rio de Janeiro"));
    }

    @Test
    @Transactional
    public void testUpdate() {
        Municipio dto = new Municipio();
        dto.setNome("Rio de Janeiro");

        given()
                .body(dto)
                .contentType(ContentType.JSON)
                .when().put("/municipios/1")
                .then()
                .statusCode(200)
                .body("nome", is("Rio de Janeiro"));
    }

    @Test
    @Transactional
    public void testCount() {
        given()
                .when().get("/municipios/count")
                .then()
                .statusCode(200)
                .body(is("0"));
    }

    @Test
    @Transactional
    public void testSearch() {
        given()
                .when().get("/municipios/search/Teste")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    @Transactional
    public void testDelete() {
        given()
                .when().delete("/municipios/1")
                .then()
                .statusCode(204);
    }
}
