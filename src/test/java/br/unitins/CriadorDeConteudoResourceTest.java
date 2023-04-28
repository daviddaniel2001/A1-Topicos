package br.unitins;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import br.unitins.model.CriadorDeConteudo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.transaction.Transactional;

@QuarkusTest
public class CriadorDeConteudoResourceTest {

    @Test
    @Transactional
    public void testGetAll() {
        given()
                .when().get("/CriadorDeConteudo")
                .then()
                .statusCode(200)
                .body(is("[124, Carlos, 25, 12345678901,carlos@example.com, 100]"));
    }

    @Test
    @Transactional
    public void testInsert() {
        CriadorDeConteudo dto = new CriadorDeConteudo();
        dto.setNome("Joao");

        given()
                .body(dto)
                .contentType(ContentType.JSON)
                .when().post("/CriadorDeConteudo")
                .then()
                .statusCode(201)
                .body("nome", is("Joao"));
    }

    @Test
    @Transactional
    public void testUpdate() {
        CriadorDeConteudo dto = new CriadorDeConteudo();
        dto.setNome("Jane Doe");

        given()
                .body(dto)
                .contentType(ContentType.JSON)
                .when().put("/CriadorDeConteudo/1")
                .then()
                .statusCode(200)
                .body("nome", is("Maria"));
    }

    @Test
    @Transactional
    public void testCount() {
        given()
                .when().get("/CriadorDeConteudo/count")
                .then()
                .statusCode(200)
                .body(is("1"));
    }

    @Test
    @Transactional
    public void testDelete() {
        given()
                .when().delete("/CriadorDeConteudo/1")
                .then()
                .statusCode(204);
    }

    @Test
    @Transactional
    public void testSearchId() {
        given()
                .when().get("/CriadorDeConteudo/search/1")
                .then()
                .statusCode(200)
                .body("nome", is("Joao"));
    }

    @Test
    @Transactional
    public void testSearch() {
        given()
            .when().get("/CriadorDeConteudo/search/Joao");
    }

}
