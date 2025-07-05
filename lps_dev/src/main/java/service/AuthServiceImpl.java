package service;

import com.example.generated.tables.pojos.UsersVo;
import dto.AuthRequest;
import dto.AuthResponse;
import jakarta.inject.Inject;
import repository.UsersRepository;
import util.JwtUtil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

    @Inject
    private UsersRepository usersRepository;

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        UsersVo user = usersRepository.findUserByEmailAndPassword(request.getEmail(), request.getPassword());
        if (user != null) {
            String token = JwtUtil.generateToken(user.getEmail());
            return new AuthResponse(user, token);
        }
        return null;
    }
}