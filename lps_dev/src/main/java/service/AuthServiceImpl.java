package service;

import com.example.generated.tables.pojos.UsersVo;
import dto.AuthRequest;
import dto.AuthResponse;
import util.JwtUtil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse authenticate(AuthRequest request) {
        // 本来はDBでユーザー認証
        if ("user".equals(request.getUsername()) && "pass".equals(request.getPassword())) {
            UsersVo user = new UsersVo();
            user.setId(1);
            user.setName(request.getUsername());
            String token = JwtUtil.generateToken(request.getUsername());
            return new AuthResponse(user, token);
        }
        return null;
    }
}