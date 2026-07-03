package com.api.biblioteca.configurations;

import java.util.Collection;
import java.util.List;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.api.biblioteca.enums.EstadoUsuarioNombre;
import com.api.biblioteca.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserDetails implements UserDetails{

    private Usuario usuario;

    public Long id(){
        return usuario.getId();
    }

    public String nombreCompleto(){
        return "%s %s %s"
            .formatted(usuario.getNombre(),usuario.getApellidoPaterno(),usuario.getApellidoMaterno());
    }

    public String fotoUrl(){
        return usuario.getFotoUrl();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+usuario.getRol().getNombre()));
    }

    @Override
    public @Nullable String getPassword() {
        return usuario.getCredencial().getContrasena();
    }

    @Override
    public String getUsername() {
        return usuario.getCredencial().getCorreo();
    }

    @Override
    public boolean isAccountNonLocked() {
        return usuario.getEstado().getNombre() != EstadoUsuarioNombre.BLOQUEADO;
    }

    @Override
    public boolean isEnabled() {
        return usuario.getEstado().getNombre() == EstadoUsuarioNombre.ACTIVO;
    }

}
