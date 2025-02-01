package org.muo.controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.muo.document.UserProfile;
import org.muo.dto.request.CreateUserRequestDto;
import org.muo.service.UserProfileService;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import static org.muo.config.RestApis.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(USERPROFILE)
public class UserProfileController {
    private final UserProfileService userProfileService;
    private final CacheManager cacheManager;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        userProfileService.createUser(createUserRequestDto);
        return ResponseEntity.ok(true);
    }
    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll() {
    return ResponseEntity.ok(userProfileService.getAll());
    }

    @Cacheable("upper-case")
    @GetMapping("/upper-name")
    public ResponseEntity<String> getUpperName(String name) {
        return ResponseEntity.ok(userProfileService.upperName(name));

    }
    public void ClearCache() {
        cacheManager.getCache("upper-case").clear();
    }
}
