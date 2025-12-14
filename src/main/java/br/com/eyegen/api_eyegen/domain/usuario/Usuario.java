package br.com.eyegen.api_eyegen.domain.usuario;

import br.com.eyegen.api_eyegen.domain.assinatura.Assinatura;
import br.com.eyegen.api_eyegen.domain.dispositivo.Dispositivo;
import br.com.eyegen.api_eyegen.domain.pedido.Pedido;
import br.com.eyegen.api_eyegen.domain.usuario.enums.TipoDeficienciaVisual;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "usuarios")
@Entity(name = "Usuario")
public class Usuario implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome_usuario")
    private String nomeUsuario;
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private String senha;
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_def_visual")
    private TipoDeficienciaVisual tipoDeficienciaVisual;

    @OneToMany(mappedBy = "usuario")
    private Set<Dispositivo> dispositivos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_assinatura")
    private Assinatura assinatura;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    public Usuario(DadosCadastroUsuario dados, String senha) {
        this.nomeUsuario = dados.nome();
        this.email = dados.email();
        this.senha = senha;
        this.dataNascimento = dados.dataNascimento();
        this.tipoDeficienciaVisual = dados.deficienciaVisual();
        this.telefone = dados.telefone();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
