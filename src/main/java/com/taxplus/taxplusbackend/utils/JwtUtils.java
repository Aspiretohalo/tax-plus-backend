package com.taxplus.taxplusbackend.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String signKey = "abcabcabcabcbacbacacbabcbaaaaaaaaaaaaaaaaaaa";//key要足够长才满足其安全条件
    private static final Long expire = 43200000L;

    /**
     * 生成JWT令牌
     *
     * @param claims JWT第二部分负载 payload 中存储的内容
     */
    public static String generateJwt(Map<String, Object> claims) {
        byte[] keyBytes = Decoders.BASE64.decode(signKey);
        Key key = Keys.hmacShaKeyFor(keyBytes);
        return Jwts.builder().setClaims(claims).setExpiration(new Date(System.currentTimeMillis() + expire)).signWith(key).compact();
    }

    /**
     * 解析JWT令牌
     *
     * @param jwt JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseJWT(String jwt) {
        return Jwts.parserBuilder()
                .setSigningKey(signKey)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }
}
