package br.unitins.repository;

import java.util.List;

import br.unitins.model.Cartao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CartaoRepository implements PanacheRepository<Cartao> {

    public List<Cartao> findByNomeTitular(String nomeTitular){
        if(nomeTitular == null)
            return null;
        return findByNomeTitular(nomeTitular);
    }
}
