package br.unitins;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import br.unitins.model.Endereco;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.transaction.Transactional;

@QuarkusTest
public class EnderecoResourceTest {

    @Test
    @Transactional
    public void testGetAll() {
        given()
                .when().get("/enderecos")
                .then()
                .statusCode(200)
                .body(is("[100, Rua A, Bairro A, 123, Complemento A, 12345-678, ]"));
    }

    @Test
    @Transactional
    public void testInsert() {
        Endereco dto = new Endereco();
        dto.setBairro("Bairro do Teste");

        given()
                .body(dto)
                .contentType(ContentType.JSON)
                .when().post("/enderecos")
                .then()
                .statusCode(201)
                .body("bairro", is("Bairro do Teste"));
    }

    @Test
    @Transactional
    public void testUpdate() {
        Endereco dto = new Endereco();
        dto.setBairro("Bairro do Teste Atualizada");

        given()
                .body(dto)
                .contentType(ContentType.JSON)
                .when().put("/enderecos/1")
                .then()
                .statusCode(200)
                .body("baixo", is("Bairro do Teste Atualizada"));
    }

    @Test
    @Transactional
    public void testCount() {
        given()
                .when().get("/enderecos/count")
                .then()
                .statusCode(200)
                .body(is("1"));
    }

    @Test
    @Transactional
    public void testSearch() {
        given()
                .when().get("/enderecos/search/Bairro do Teste")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    @Transactional
    public void testDelete() {
        given()
                .when().delete("/enderecos/1")
                .then()
                .statusCode(204);
    }


}
