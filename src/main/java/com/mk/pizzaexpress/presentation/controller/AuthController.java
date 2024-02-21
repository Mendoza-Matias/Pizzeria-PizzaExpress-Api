package com.mk.pizzaexpress.presentation.controller;


import com.mk.pizzaexpress.bussines.services.security.AuthServices;
import com.mk.pizzaexpress.domain.dto.auth.AuthenticationRequest;
import com.mk.pizzaexpress.domain.dto.auth.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    private AuthServices authenticationService;

    @PreAuthorize("permitAll")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest){
      AuthenticationResponse jwtDto = authenticationService.login(authenticationRequest);
      return ResponseEntity.status(HttpStatus.OK).body(jwtDto);
    }

}
