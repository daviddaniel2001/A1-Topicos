package br.unitins.repository;

import java.util.List;

import br.unitins.model.Pix;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PixRepository implements PanacheRepository<Pix> {

    public List<Pix> findByNome(String nome) {
        if (nome == null)
            return null;
        return findByNome(nome);
    }
}
