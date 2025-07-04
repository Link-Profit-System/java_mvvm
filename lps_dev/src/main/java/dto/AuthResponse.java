package dto;

import com.example.generated.tables.pojos.UsersVo;

public class AuthResponse {

    private UsersVo user;
    private String token;

    public AuthResponse() {}

    public AuthResponse(UsersVo user, String token) {
        this.user = user;
        this.token = token;
    }

    public UsersVo getUser() { return user; }
    public void setUser(UsersVo user) { this.user = user; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}