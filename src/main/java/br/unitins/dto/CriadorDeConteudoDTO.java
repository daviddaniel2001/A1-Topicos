package br.unitins.dto;

<<<<<<< HEAD
import javax.validation.constraints.NotBlank;

public record CriadorDeConteudoDTO(
        Long id, 

        @NotBlank(message = "O nome deve ser informado.")
        String nome, 

        Integer idade, 

        @NotBlank(message = "O cpf deve ser informado.")
        String cpf, 

        @NotBlank(message = "O email deve ser informado.")
        String email,
        
        EnderecoDTO enderecoDTO

){
=======
public class CriadorDeConteudoDTO {
    private String nome;
    private int idade;
    private Long idPlataforma;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Long getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Long idPlataforma) {
        this.idPlataforma = idPlataforma;
    }
>>>>>>> c997eaa80096eab5e3c4265a343ecf9ee1398862

}
