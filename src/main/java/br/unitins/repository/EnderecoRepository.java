package br.unitins.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import br.unitins.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EnderecoRepository implements PanacheRepository<Endereco> {

        public List<Endereco> findByNome(String nome) {
            if (nome == null)
                return null;
            return find("UPPER (id) LIKE ?1 ", "%" + nome + "%").list();
        }
}
