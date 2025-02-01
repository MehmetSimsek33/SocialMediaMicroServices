package org.muo.service;

import lombok.RequiredArgsConstructor;
import org.muo.document.UserProfile;
import org.muo.dto.request.CreateUserRequestDto;
import org.muo.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    public void createUser(CreateUserRequestDto createUserRequestDto) {
        userProfileRepository.save(UserProfile.builder()
                        .authId(createUserRequestDto.getAuthId())
                        .userName(createUserRequestDto.getUserName())
                        .email(createUserRequestDto.getEmail())
                .build());
    }

    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }

    public String upperName(String name) {
        String result = name.toUpperCase();
        try {
            Thread.sleep(3000L);
        }
        catch (Exception e) {}
        return result;
    }
}
