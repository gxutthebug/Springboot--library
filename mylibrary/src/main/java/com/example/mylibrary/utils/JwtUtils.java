package com.example.mylibrary.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {

    // 7天过期时限
    private static long expire = 604800;

    // 32位密钥; 每个加密算法都要求不同长度的密钥
    private static String secret = "abcdfghiabcdfghiabcdfghiabcdfghi" ;

    public static String generateToken(String username){ // 携带的用户信息取决于你自己
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * expire);
        return Jwts.builder().
                setHeaderParam (  "type" ,"JWT").
                setSubject(username). // 携带的用户信息
                setIssuedAt(now).  // token生成的时间
                setExpiration(expiration). //过期时间
                signWith(SignatureAlgorithm.HS512,secret).compact(); // 加密算法与密钥
    }


    // 获取载荷中携带的用户信息
    public static Claims getClaimsByToken(String token){
        return Jwts.parser().
                setSigningKey (secret).  // 利用密钥解密
                parseClaimsJws(token).
                getBody();
    }
}
