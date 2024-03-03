package com.mk.pizzaexpress.bussines.services.security;

import com.mk.pizzaexpress.config.filter.JwtService;
import com.mk.pizzaexpress.domain.dto.auth.AuthenticationRequest;
import com.mk.pizzaexpress.domain.dto.auth.AuthenticationResponse;
import com.mk.pizzaexpress.domain.entity.usuarios.Usuario;
import com.mk.pizzaexpress.domain.exceptions.NotFoundException;
import com.mk.pizzaexpress.domain.exceptions.UsuarioException;
import com.mk.pizzaexpress.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class AuthServices {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepository userRepository;

    public AuthenticationResponse login (AuthenticationRequest authenticationRequest){

        Usuario usuario = userRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow(()-> new NotFoundException("Usuario no encontrado"));

        if(!passwordEncoder.matches(authenticationRequest.getClave(),usuario.getClave())){
            throw new UsuarioException("Las clave no es correcta");
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getEmail(),authenticationRequest.getClave()
        );
        authenticationManager.authenticate(usernamePasswordAuthenticationToken).getPrincipal();

        String jwt = jwtService.generateToken(usuario,generateExtraClaims(usuario));

        return AuthenticationResponse.builder()
                .jwt(jwt)
                .build();

    }

    private Map <String,Object> generateExtraClaims(Usuario user){
        Map<String,Object> extraClaims = new HashMap<>();
        extraClaims.put("name",user.getNombre());
        extraClaims.put("role",user.getRol().name());
        extraClaims.put("authorities",user.getAuthorities());
        return extraClaims;
    }
}
