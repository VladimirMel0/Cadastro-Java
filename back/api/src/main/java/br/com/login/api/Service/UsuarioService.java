package br.com.login.api.Service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.login.api.Model.Usuario;
import br.com.login.api.Repository.IUsuario;

@Service
public class UsuarioService {
    private IUsuario repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    //get
    public List<Usuario> listaUsuario(){
        List<Usuario> lista = repository.findAll();
        return lista;
    }
    //post
    public Usuario criarUsuario(Usuario usuario){
        String enconder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(enconder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }
    //put
    public Usuario editarUsuario(Usuario usuario){
        String enconder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(enconder);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }
    //delete
    public boolean excluirUsuario(Integer id){
        repository.deleteById(id);
        return true;
    }

    public Boolean validarSenha(Usuario usuario){
        String senha = repository.getById(usuario.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        return valid;
    }

    
}
