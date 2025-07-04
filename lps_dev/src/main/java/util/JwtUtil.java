package util;

import io.smallrye.jwt.build.Jwt;

import java.time.Duration;

public class JwtUtil {
    public static String generateToken(String username) {
        return Jwt.issuer("lpsdev")
                .subject(username)
                .expiresIn(Duration.ofHours(1))
                .sign();
    }
}