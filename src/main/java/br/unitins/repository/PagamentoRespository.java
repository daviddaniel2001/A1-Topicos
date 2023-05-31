package br.unitins.repository;

import java.util.List;

import br.unitins.model.Pagamento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PagamentoRespository implements PanacheRepository<Pagamento> {
    
    public List<Pagamento> findByValor (Float valor){
        if(valor == null)
            return null;
        return findByValor(valor);
    }
}
