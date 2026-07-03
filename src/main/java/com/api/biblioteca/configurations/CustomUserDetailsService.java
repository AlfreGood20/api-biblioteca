package com.api.biblioteca.configurations;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.api.biblioteca.models.Credencial;
import com.api.biblioteca.repositorys.CredencialRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

    private final CredencialRepository credencialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credencial credencial = credencialRepository.findByCorreo(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: "+username));

        return new CustomUserDetails(credencial.getUsuario());
    }
}