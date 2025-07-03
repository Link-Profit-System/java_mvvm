package service;

import com.example.generated.tables.pojos.UsersVo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jooq.DSLContext;
import repository.UsersRepository;

import static com.example.generated.tables.JUsers.USERS;

@ApplicationScoped
public class GreetingService {

    @Inject
    private UsersRepository usersRepository;

    public String getGreeting() {
        UsersVo User = usersRepository.getUserById(1);
        if (User == null) {
            return "User not found";
        }
        return User.getId().toString() + "：" + User.getName();
    }
}
