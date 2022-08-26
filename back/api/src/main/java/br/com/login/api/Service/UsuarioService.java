package br.com.login.api.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.login.api.Model.Usuario;
import br.com.login.api.Repository.IUsuario;

@Service
public class UsuarioService {
    private IUsuario repository;

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
    }
    //get
    public List<Usuario> listaUsuario(){
        List<Usuario> lista = repository.findAll();
        return lista;
    }
    //post
    public Usuario criarUsuario(Usuario usuario){
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }
    //put
    public Usuario editarUsuario(Usuario usuario){
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }
    //delete
    public boolean excluirUsuario(Integer id){
        repository.deleteById(id);
        return true;
    }

}
