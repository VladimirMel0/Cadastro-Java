package br.com.login.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.login.api.Model.Usuario;

public interface IUsuario  extends JpaRepository<Usuario, Integer> {
    
}
