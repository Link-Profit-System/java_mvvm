package service;

import com.example.generated.tables.pojos.UsersVo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.UsersRepository;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    private UsersRepository usersRepository;

    public UsersVo getUser(Integer id) {
        return usersRepository.findUserById(id);
    }

    public List<UsersVo> getUsers() {
        return usersRepository.findAllUsers();
    }

    public UsersVo createUser(UsersVo user) {
        return usersRepository.createUser(user);
    }

    public UsersVo updateUser(Integer id, UsersVo user) {
        return usersRepository.updateUserById(id, user);
    }

    public void deleteUser(Integer id) {
        usersRepository.deleteUserById(id);
    }

}
