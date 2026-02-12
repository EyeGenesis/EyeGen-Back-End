package br.com.eyegen.api_eyegen.controller;

import br.com.eyegen.api_eyegen.domain.usuario.DadosAutenticacao;
import br.com.eyegen.api_eyegen.domain.usuario.DadosCadastroUsuario;
import br.com.eyegen.api_eyegen.domain.usuario.Usuario;
import br.com.eyegen.api_eyegen.infra.security.DadosTokenJWT;
import br.com.eyegen.api_eyegen.infra.security.TokenService;
import br.com.eyegen.api_eyegen.domain.usuario.DadosRespostaUsuario;
import br.com.eyegen.api_eyegen.services.CadastroUsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@RestController
@RequestMapping("/usuarios")
public class AutenticacaoController {
    private AuthenticationManager manager;

    private TokenService tokenService;

    private CadastroUsuarioService service;

    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService, CadastroUsuarioService service) {
        this.manager = manager;
        this.tokenService = tokenService;
        this.service = service;
    }

    @Transactional
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) Objects.requireNonNull(authentication.getPrincipal()));
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder builder) {

        Usuario usuario = this.service.cadastrar(dados);

        var uri = builder
                .path("/usuarios/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new DadosRespostaUsuario(usuario));

    }
}
