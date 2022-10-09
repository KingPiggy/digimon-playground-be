package com.kingpiggy.digimon.pg.service;

import com.kingpiggy.digimon.pg.domain.user.User;
import com.kingpiggy.digimon.pg.domain.user.UserRepository;
import com.kingpiggy.digimon.pg.enumclass.ErrorCode;
import com.kingpiggy.digimon.pg.util.JwtTokenProvider;
import com.kingpiggy.digimon.pg.web.ApiResponse;
import com.kingpiggy.digimon.pg.web.BusinessException;
import com.kingpiggy.digimon.pg.web.dto.response.TokenResponse;
import com.kingpiggy.digimon.pg.web.dto.request.UserLoginRequest;
import com.kingpiggy.digimon.pg.web.dto.request.UserSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

/**
 * AuthService class
 * service for auth service
 *
 * @author SEUNGHOON
 * @version 0.0.1, 2022-06-05
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(rollbackFor = Exception.class)
    public ApiResponse login(UserLoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BusinessException(ErrorCode.EMAIL_NOT_FOUND));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BusinessException(ErrorCode.PASSWORD_NOT_EQUAL);
        }

        TokenResponse tokenResponse = jwtTokenProvider.createTokenDto(user.getId(), user.getRoles());

        user.setRefreshToken(tokenResponse.getRefreshToken());

        return ApiResponse.OK(tokenResponse);
    }

    @Transactional(rollbackFor = Exception.class)
    public ApiResponse signUp(UserSignUpRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());

        if (user.isPresent()) {
            throw new BusinessException(ErrorCode.DUPLICATED_EMAIL);
        }

        User savedUser = userRepository.save(User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Collections.singletonList("ROLE_USER"))
                .build());

        return ApiResponse.OK("Saved user ID : " + savedUser.getId());
    }

    @Transactional(readOnly = true)
    public ApiResponse checkDuplicatedEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            throw new BusinessException(ErrorCode.DUPLICATED_EMAIL);
        }

        return ApiResponse.OK("Not duplicated");
    }

    @Transactional
    public ApiResponse grantAdminRole(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.EMAIL_NOT_FOUND));

        user.getRoles().add("ROLE_ADMIN");

        return ApiResponse.OK(user.getRoles());
    }

}
