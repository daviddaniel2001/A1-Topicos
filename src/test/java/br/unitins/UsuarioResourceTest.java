package br.unitins;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import br.unitins.model.Usuario;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.transaction.Transactional;

@QuarkusTest
public class UsuarioResourceTest {

    @Test
    @Transactional
    public void testGetAll() {
        given()
                .when().get("/usuarios")
                .then()
                .statusCode(200)
                .body(is("[Joao, 25, joao@example.com , 103]"));
    }

    @Test
    @Transactional
    public void testInsert() {
        Usuario dto = new Usuario();
        dto.setNome("Joao");

        given()
                .body(dto)
                .contentType(ContentType.JSON)
                .when().post("/usuarios")
                .then()
                .statusCode(201)
                .body("nome", is("Joao"));
    }

    @Test
    @Transactional
    public void testUpdate() {
        Usuario dto = new Usuario();
        dto.setNome("Joao");

        given()
                .body(dto)
                .contentType(ContentType.JSON)
                .when().put("/usuarios/1")
                .then()
                .statusCode(200)
                .body("nome", is("Joao"));
    }

    @Test
    @Transactional
    public void testCount() {
        given()
                .when().get("/usuarios/count")
                .then()
                .statusCode(200)
                .body(is("0"));
    }

    @Test
    @Transactional
    public void testSearch() {
        given()
                .when().get("/usuarios/search/Teste")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    @Transactional
    public void testDelete() {
        given()
                .when().delete("/usuarios/1")
                .then()
                .statusCode(204);
    }
}
