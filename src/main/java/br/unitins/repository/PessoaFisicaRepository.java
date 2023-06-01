package br.unitins.repository;

import java.util.List;

import br.unitins.model.PessoaFisica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaFisicaRepository implements PanacheRepository <PessoaFisica> {
        public List<PessoaFisica> findyByCpf(String cpf) {
            if(cpf == null)
                return null;
            return find("UPPER (cpf) LIKE ?1 ", "%" + cpf + "%").list();
        }
}
