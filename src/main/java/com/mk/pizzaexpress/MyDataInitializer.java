package com.mk.pizzaexpress;

import com.mk.pizzaexpress.domain.entity.enums.Rol;
import com.mk.pizzaexpress.domain.entity.usuarios.Usuario;
import com.mk.pizzaexpress.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyDataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private boolean initialize = false;

    @Override
    public void run(String... args) throws Exception {
       if(!initialize){
           Usuario usuario = Usuario.builder()
                   .nombre("user")
                   .clave(passwordEncoder.encode("1234"))
                   .email("user@gmail.com")
                   .rol(Rol.ADMINISTRADOR)
                   .build();
           usuarioRepository.save(usuario);

           initialize = true;
       }

    }
}
