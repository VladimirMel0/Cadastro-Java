package br.com.login.api.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.login.api.Modal.Usuario;

public interface IUsuario  extends CrudRepository<Usuario, Integer> {
    
}
