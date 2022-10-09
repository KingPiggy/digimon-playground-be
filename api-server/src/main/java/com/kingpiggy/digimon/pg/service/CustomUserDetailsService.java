package com.kingpiggy.digimon.pg.service;

import com.kingpiggy.digimon.pg.domain.user.CustomUserDetails;
import com.kingpiggy.digimon.pg.domain.user.User;
import com.kingpiggy.digimon.pg.domain.user.UserRepository;
import com.kingpiggy.digimon.pg.enumclass.ErrorCode;
import com.kingpiggy.digimon.pg.web.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userIdStr) throws UsernameNotFoundException {
        User user = userRepository.findById(Long.parseLong(userIdStr))
                .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND));

        CustomUserDetails userDetails = CustomUserDetails.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .name(user.getName())
                .authorities(user.getRoles().stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()))
                .build();

        return userDetails;
    }
}
