package br.com.login.api.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank (message = "O nome é obrigatório!")
    @Size(min = 3, message = "O nome deve ter no minimo 3 caracteres!")
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;
    
    @Email (message = "Insira um email válido!")
    @NotBlank (message = "O email é obrigatório!")
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @NotBlank (message = "A senha é obrigatório!")
    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

    @NotBlank (message = "O telefone é obrigatório!")
    @Size(min = 11, max = 11, message = "Insira um telefone válido!")
    @Column(name = "telefone", length = 11, nullable = false)
    private String telefone;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
