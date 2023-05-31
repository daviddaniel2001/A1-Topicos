package br.unitins.model;

import jakarta.persistence.Entity;

@Entity
public class RegistroPagamento extends Pagamento {

    private Long id;
    private Boolean pago;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

}
