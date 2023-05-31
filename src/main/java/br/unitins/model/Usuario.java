package br.unitins.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario {

    private Long id;
    private String login;
    private String senha;
    private String nomeImagem;
    private Assinaturas assinaturas;

    public Assinaturas getAssinaturas() {
        return assinaturas;
    }

    public void setAssinaturas(Assinaturas assinaturas) {
        this.assinaturas = assinaturas;
    }

    @ElementCollection
    @CollectionTable(name = "perfis", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"))
    @Column(name = "perfis", length = 30)
    private Set<Perfil> perfis;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_telefone_celular", unique = true)
    private Telefone celular;

    @OneToOne
    @JoinColumn(name = "id_telefone_whatsapp", unique = true)
    private Telefone whatsapp;

    @OneToMany
    private List<Endereco> listaEndereco;

    @OneToOne
    @JoinColumn(name = "id_pessoa_fisica", unique = true)
    private PessoaFisica pessoaFisica;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }

    public Telefone getCelular() {
        return celular;
    }

    public void setCelular(Telefone celular) {
        this.celular = celular;
    }

    public Telefone getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(Telefone whatsapp) {
        this.whatsapp = whatsapp;
    }

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
