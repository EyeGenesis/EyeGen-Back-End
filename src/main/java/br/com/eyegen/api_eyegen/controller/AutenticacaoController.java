package br.com.eyegen.api_eyegen.controller;

import br.com.eyegen.api_eyegen.domain.usuario.DadosAutenticacao;
import br.com.eyegen.api_eyegen.domain.usuario.Usuario;
import br.com.eyegen.api_eyegen.infra.security.DadosTokenJWT;
import br.com.eyegen.api_eyegen.infra.security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    private TokenService tokenService;

    @Transactional
    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadosAutenticacao dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
