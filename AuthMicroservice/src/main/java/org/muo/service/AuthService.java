package org.muo.service;

import lombok.RequiredArgsConstructor;
import org.muo.dto.request.CreateUserRequestDto;
import org.muo.dto.request.RegisterRequestDto;
import org.muo.dto.response.LoginResponseDto;
import org.muo.entity.Auth;
import org.muo.manager.UserProfileManager;
import org.muo.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;

//@transaction kullanılacak hata olursa donecek geri alınacak
        public Auth register(RegisterRequestDto requestDto) {
        Auth auth= repository.save(Auth.builder()
                        .userName(requestDto.getUserName())
                        .email(requestDto.getEmail())
                        .password(requestDto.getPassword())
                .build());
        userProfileManager.createUser(CreateUserRequestDto.builder()
                        .authId(auth.getId())
                        .userName(auth.getUserName())
                        .email(auth.getEmail())
                .build());
             return auth;

    }

    public Boolean login(LoginResponseDto loginResponseDto) {
        return repository.existsByUserNameAndPassword(loginResponseDto.getUserName(),loginResponseDto.getPassword());
    }
}
