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
    private int LLAVE_MAESTRA;
    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UsuarioDto obtenerUsuarioPorId(int id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new NotFoundException("El usuario no se encuentra"));
        return usuarioMapper.toDto(usuario);
    }
    @Override
    public UsuarioDto crearUsuario(CrearUsuarioDto crearUsuario) {
        if(existeUsuarioConEmail(crearUsuario.getEmail())){
            throw new UsuarioException("Existe un usuario con este email");
        }
        Usuario usuario = usuarioMapper.deCrearUsuarioDtoAUsuario(crearUsuario);
        usuario.setNombre(crearUsuario.getNombre());
        usuario.setEmail(crearUsuario.getEmail());
        usuario.setRol(Rol.EMPLEADO);
        usuario.setClave(passwordEncoder.encode(crearUsuario.getClave()));
        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }
    @Override
    public UsuarioDto modificarClaveDeUsuario(int id,String email, String clave) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Usuario no encontrado"));

        if(email != usuario.getEmail()){
            throw new UsuarioException("Email no encontrado");
        }

        usuario.setClave(passwordEncoder.encode(clave));
        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }
    @Override
    public UsuarioDto modificarRolUsuario(int id, AdminRequest adminRequest) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Usuario no encontrado"));

        if(usuario.getRol().equals(Rol.ADMINISTRADOR)){
            throw new UsuarioException("Este usuario ya es administrador");
        }
        if(!(adminRequest.getLlaveMaestra() == LLAVE_MAESTRA)){
            throw new UsuarioException("La clave maestra no es correcta");
        }
        usuario.setRol(adminRequest.getRol());
        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }
    @Override
    public UsuarioDto eliminarUsuario(String email, String claveUsuario) {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(()-> new NotFoundException("El usuario con email" + email + " no se encuentra"));
        if(passwordEncoder.matches(claveUsuario,usuario.getPassword())){
            throw new UsuarioException("Los datos ingresados no son correctos");
        }
        usuarioRepository.deleteById(usuario.getId());
        return usuarioMapper.toDto(usuario);
    }
    @Override
    public boolean existeUsuarioConEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

}
