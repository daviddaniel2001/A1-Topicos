package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Plataforma;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PlataformaRepository implements PanacheRepository<Plataforma> {

    public List<Plataforma> findByNome(String nome) {
        if (nome == null)
            return null;
        return find("Upper(nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%").list();
    }
}
