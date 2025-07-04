package service;

import com.example.generated.tables.pojos.UsersVo;
import dto.AuthRequest;
import dto.AuthResponse;

public interface AuthService {
    AuthResponse authenticate(AuthRequest request);
}