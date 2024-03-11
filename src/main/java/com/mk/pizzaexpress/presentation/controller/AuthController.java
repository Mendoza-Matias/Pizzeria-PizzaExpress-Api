package com.mk.pizzaexpress.presentation.controller;


import com.mk.pizzaexpress.bussines.services.security.AuthServices;
import com.mk.pizzaexpress.domain.dto.auth.AuthenticationRequest;
import com.mk.pizzaexpress.domain.dto.auth.AuthenticationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "1. Auth", description = "API para la autenticación de usuarios | clientes")

@RestController
@RequestMapping("api/auth")

public class AuthController {

    @Autowired
    private AuthServices authenticationService;

    @Operation(summary = "Autenticación de usuario", description = "Autenticación de usuario")
    @ApiResponse(responseCode = "200", description = "Devuelve el token del usuario.")

    @PreAuthorize("permitAll")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest){
      AuthenticationResponse jwtDto = authenticationService.login(authenticationRequest);
      return ResponseEntity.status(HttpStatus.OK).body(jwtDto);
    }

}
