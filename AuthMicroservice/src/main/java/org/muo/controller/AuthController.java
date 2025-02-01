package org.muo.controller;

import com.fasterxml.jackson.databind.node.POJONode;
import lombok.RequiredArgsConstructor;
import org.muo.dto.request.RegisterRequestDto;
import org.muo.dto.response.LoginResponseDto;
import org.muo.entity.Auth;
import org.muo.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.muo.config.RestApis.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto requestDto) {
        if(!requestDto.getPassword().equals(requestDto.getRepassword()))
            throw new RuntimeException("Şifreler uyuşmuyor");

        return ResponseEntity.ok(authService.register(requestDto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginResponseDto loginResponseDto) {
        return ResponseEntity.ok(authService.login(loginResponseDto));

    }
}
