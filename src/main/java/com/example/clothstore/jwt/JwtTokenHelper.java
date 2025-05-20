package com.example.clothstore.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenHelper {

    private long expiredDate = 8 * 60 * 60 * 1000;
    private String strKey = "xJHDonkgbMOgIGNodeG7l2kgYuG6o28gbeG6rXQgxJHhuqd5IMSR4bunIDI1NiBiaXQ="; // Chuỗi base 64

    public String generateToken(String data) {
        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + this.expiredDate);
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(strKey));

        return Jwts.builder()
                .setSubject(data) // Lưu trữ dữ liệu vào trong token kiểu string
                .setIssuedAt(now) // Thời gian tạo token
                .setExpiration(expiredDate) // Thời gian hết hạn của token
                .signWith(SignatureAlgorithm.forSigningKey(secretKey), secretKey) // Thuật toán mã hóa và secret key
                .compact(); // Trả về chuổi đã được mã hóa
    }

    public String decodeToken(String token) {
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(strKey));
        return Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }
}
