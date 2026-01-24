package com.example.ebearrestapi.config;

import com.example.ebearrestapi.utils.JwtToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfig {
    @Value("${jwt.secret}")
    private String accessTokenSecret;

    @Value("${jwt.access-token-expire-time}")
    private Long accessTokenExpireTime;

    // 액세스 토큰 발급용, 리프레시 토큰 발급용은 각각 별도의 키와 유효기간을 갖는다.
    @Bean
    public JwtToken jwtToken() {
        return new JwtToken(accessTokenSecret, accessTokenExpireTime);
    }
}
