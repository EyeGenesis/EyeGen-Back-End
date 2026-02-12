package br.com.eyegen.api_eyegen.services;


import br.com.eyegen.api_eyegen.domain.usuario.DadosCadastroUsuario;
import br.com.eyegen.api_eyegen.domain.usuario.Usuario;
import br.com.eyegen.api_eyegen.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CadastroUsuarioService {

   private UsuarioRepository repository;

    public CadastroUsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario cadastrar(DadosCadastroUsuario dadosCadastroUsuario){
       if (this.repository.findByEmail(dadosCadastroUsuario.email()) != null){
           throw new RuntimeException("O usuário já está cadastrado");
       }

       String encryptedPassword = new BCryptPasswordEncoder().encode(dadosCadastroUsuario.senha());

       var usuario = new Usuario(dadosCadastroUsuario, encryptedPassword);

       return this.repository.save(usuario);
   }

}
