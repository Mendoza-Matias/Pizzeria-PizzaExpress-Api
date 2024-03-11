package com.mk.pizzaexpress.bussines.services.servicesImpl;

import com.mk.pizzaexpress.bussines.mapper.implMapper.UsuarioMapper;
import com.mk.pizzaexpress.bussines.services.UsuarioService;
import com.mk.pizzaexpress.domain.dto.usuario.AdminRequest;
import com.mk.pizzaexpress.domain.dto.usuario.CrearUsuarioDto;
import com.mk.pizzaexpress.domain.dto.usuario.UsuarioClaveDto;
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

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Value("${spring.llave-maestra}")
    private String llaveMaestra;
    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public List<UsuarioDto> listarTodosLosUsuarios() {
        return usuarioMapper.toDtoList(usuarioRepository.findAll());
    }
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
    public UsuarioDto modificarClaveDeUsuario(UsuarioClaveDto usuarioClave) {
        Usuario usuario = usuarioRepository.findByEmail(usuarioClave.getEmail()).orElseThrow(()-> new NotFoundException("Usuario no encontrado"));

        if(!passwordEncoder.matches(usuario.getClave(), usuarioClave.getClave())){
            throw new UsuarioException("Clave incorrecta");
        }

        usuario.setClave(passwordEncoder.encode(usuarioClave.getNuevaClave()));

        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }
    @Override
    public UsuarioDto modificarRolUsuario(int id, AdminRequest adminRequest) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new NotFoundException("Usuario no encontrado"));

        if(usuario.getRol().equals(Rol.ADMINISTRADOR)){
            throw new UsuarioException("Este usuario ya es administrador");
        }

        System.out.print(adminRequest.getLlaveMaestra());

        if(!adminRequest.getLlaveMaestra().equals(this.llaveMaestra)){
            throw new UsuarioException("La llave maestra no es correcta");
        }

        usuario.setRol(adminRequest.getRol());

        return usuarioMapper.toDto(usuarioRepository.save(usuario));
    }
    @Override
    public UsuarioDto eliminarUsuario(UsuarioClaveDto usuarioClave) {
        Usuario usuario = usuarioRepository.findByEmail(usuarioClave.getEmail()).orElseThrow(()-> new NotFoundException("El email ingresado no se ha encontrado."));
        if(!passwordEncoder.matches(usuarioClave.getClave(),usuario.getPassword())){
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
