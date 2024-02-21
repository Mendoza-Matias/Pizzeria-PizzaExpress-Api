package com.mk.pizzaexpress.bussines.services.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.UsuarioMapper;
import com.mk.pizzaexpress.bussines.services.UsuarioService;
import com.mk.pizzaexpress.domain.dto.usuario.AdminRequest;
import com.mk.pizzaexpress.domain.dto.usuario.CrearUsuarioDto;
import com.mk.pizzaexpress.domain.dto.usuario.UsuarioDto;
import com.mk.pizzaexpress.domain.entity.enums.Rol;
import com.mk.pizzaexpress.domain.entity.usuarios.Usuario;
import com.mk.pizzaexpress.domain.exceptions.NotFoundException;
import com.mk.pizzaexpress.domain.exceptions.UsuarioException;
import com.mk.pizzaexpress.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Value("${spring.llave_maestra}")
    private int CLAVE_MAESTRA;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto crearUsuario(CrearUsuarioDto crearUsuarioDTO) {
        if(existeUsuarioConEmail(crearUsuarioDTO.getEmail())){
            throw new UsuarioException("Existe un usuario con este email");
        }
        Usuario usuario = usuarioMapper.deCrearUsuarioDtoAUsuario(crearUsuarioDTO);
        usuario.setClave(passwordEncoder.encode(crearUsuarioDTO.getClave()));
        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDto eliminarUsuario(String email, String clave) {

        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(()-> new NotFoundException("El usuario con email" + email + " no se encuentra"));

        if(passwordEncoder.matches(clave,usuario.getPassword())){
            throw new UsuarioException("Los datos ingresados no son correctos");
        }

        usuarioRepository.deleteById(usuario.getId());

        return usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioDto obtenerUsuarioPorId(int id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new NotFoundException("El usuario no se encuentra"));
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioDto modificarClaveDeUsuario(String email, String clave) {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(()-> new NotFoundException("El usuario con email" + email + " no se encuentra"));
        usuario.setClave(passwordEncoder.encode(clave));
        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDto modificarRolUsuario(int id, int claveMaestra, AdminRequest adminRequest) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Usuario no encontrado"));

        if(usuario.getRol().equals(Rol.ADMINISTRADOR)){
            throw new UsuarioException("Este usuario ya es administrador");
        }

        if(usuario.getRol().equals(Rol.PROVEEDOR)){
            throw new UsuarioException("Este usuario ya es proveedor");
        }

        if(!(adminRequest.getLlaveMaestra() == claveMaestra)){
            throw new UsuarioException("La clave maestra no es correcta");
        }

        usuario.setRol(adminRequest.getRol());

        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }

    @Override
    public boolean existeUsuarioConEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

}
