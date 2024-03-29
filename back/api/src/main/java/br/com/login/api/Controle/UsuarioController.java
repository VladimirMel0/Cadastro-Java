package br.com.login.api.Controle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.login.api.Model.Usuario;
import br.com.login.api.Service.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        return ResponseEntity.status(200).body(usuarioService.listaUsuario());
    }

    @PostMapping()
    public ResponseEntity <Usuario> cadastrar(@Valid @RequestBody Usuario usuarios) {
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuarios));
    }

    @PutMapping()
    public ResponseEntity <Usuario> editarUsuarios(@Valid @RequestBody Usuario usuarios) {
        return ResponseEntity.status(200).body(usuarioService.editarUsuario(usuarios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id) {
        usuarioService.excluirUsuario(id);
        return  ResponseEntity.status(204).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> validarSenha(@Valid @RequestBody Usuario usuario) {
        Boolean valid = usuarioService.validarSenha(usuario);
        if(!valid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return  ResponseEntity.status(200).build();
    }
    //chamada de erro validação
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error .getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        return errors;
    }

}