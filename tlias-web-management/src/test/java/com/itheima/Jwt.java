package com.itheima;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;

public class Jwt {

    @Test
    public void TestJwt() {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "Tom");

        String jwt = Jwts.builder()
                .setClaims(claims) // 自定义内容(载荷)
                .signWith(SignatureAlgorithm.HS256, "itheima") // 签名算法
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 3600 * 1000)) // 有效期
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void parseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("itheima") // 指定签名密钥(必须保证和生成令牌时使用相同的签名密钥)
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjg2OTg2OTc4LCJ1c2VybmFtZSI6IlRvbSJ9.Fs5oVQLrw-ECPFvxf7IryioeTSymIwBAMTa2jvR2RPE")
                .getBody();
        System.out.println(claims);
    }
}
