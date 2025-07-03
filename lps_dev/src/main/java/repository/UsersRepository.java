package repository;

import com.example.generated.tables.pojos.UsersVo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jooq.DSLContext;

import static com.example.generated.tables.JUsers.USERS;

@ApplicationScoped
public class UsersRepository {

    @Inject
    DSLContext dsl;

     public UsersVo getUserById(Integer id) {
         return dsl.selectFrom(USERS)
                 .where(USERS.ID.equal(id))
                 .fetchOneInto(UsersVo.class);
     }
}
