package com.ho.edcustom;

import com.ho.edcustom.entity.Member;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private String secretKey = Base64.getEncoder().encodeToString("rlaghdus_guswlgns_dlcodhks_qkqhemf_secret_key".getBytes());

    // JWT 토큰 생성
    public String generateToken(Member member) {
        Date now = new Date();
        return Jwts.builder()//key-value 쌍의 정보들 해싱해서 저장
                .setHeader(createHeader())   // (1) Header는 타입(jwt)과 해싱 알고리즘(HS256)정보저장
                .setClaims(createClaims(member))  // (2)Claims는 payload,즉 정보들에 관한것들 저장
                .setIssuedAt(now)  // (3)발급 시간
                .setExpiration(new Date(now.getTime()+ Duration.ofHours(3).toMillis())) // (4)유효기간
                .signWith(SignatureAlgorithm.HS256, secretKey)  // (5)sercetKey와 함께 서명(sign)
                .compact();//(6) compact를 통해 jwt토큰 생성
    }
    private Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();
        header.put("typ","JWT");
        header.put("alg","HS256"); // 해시 256 암호화
        return header;
    }
    private Map<String, Object> createClaims(Member member) { // payload
        Map<String, Object> claims = new HashMap<>();
        claims.put("email",member.getEmail());
        claims.put("password",member.getPassword());
        return claims;
    }
    private Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            // 토큰 유효성 확인
        } catch (SecurityException e) {
            log.info("Invalid JWT signature.");
            //throw new CustomJwtRuntimeException();
        } catch (MalformedJwtException e) {
            log.info("Invalid JWT token.");
            //throw new CustomJwtRuntimeException();
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            //throw new CustomJwtRuntimeException();
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
            //throw new CustomJwtRuntimeException();
        } catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid.");
            //throw new CustomJwtRuntimeException();
        }
        return null;
    }
    public String getEamilFromToken(String token) {
        return (String) getClaims(token).get("email");
    }
}
