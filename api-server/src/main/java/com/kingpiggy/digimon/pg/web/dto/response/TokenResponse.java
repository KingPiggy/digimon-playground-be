package com.kingpiggy.digimon.pg.web.dto.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TokenResponse {

    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpireDate;

}
