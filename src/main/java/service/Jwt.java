package service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;

import java.util.Date;

public class Jwt {

    private static final String SECRET_KEY = "secret";
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";
    private static final long EXPIRATION_TIME = 3600000; // 1 hour

    public static String generateToken(String email, String role , String fullname) {
        String token = JWT.create()
                .withSubject(email)
                .withClaim("role", role)
                .withClaim("fullname", fullname)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET_KEY.getBytes()));

        return token;
    }
    public static boolean isTokenExpired(String token) {
        try {
            Date expiration = JWT.require(Algorithm.HMAC512(SECRET_KEY.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getExpiresAt();
            return expiration.before(new Date());
        } catch (JWTDecodeException exception){
            return false;
        }
    }

    // decodeToken return data[]
    public static String[] decodeToken(String token) {
        String[] data = new String[2];
        try {
            data[0] = JWT.require(Algorithm.HMAC512(SECRET_KEY.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getClaim("fullname")
                    .asString();
            data[1] = JWT.require(Algorithm.HMAC512(SECRET_KEY.getBytes()))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();
        } catch (JWTDecodeException exception){
            return null;
        }
        return data;
    }




}
