package repository;

import com.example.generated.tables.pojos.PermissionsVo;
import com.example.generated.tables.pojos.UsersVo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jooq.DSLContext;

import java.util.List;

import static com.example.generated.tables.JGroupsRoles.GROUPS_ROLES;
import static com.example.generated.tables.JPermissions.PERMISSIONS;
import static com.example.generated.tables.JRolesPermissions.ROLES_PERMISSIONS;
import static com.example.generated.tables.JUsers.USERS;
import static com.example.generated.tables.JUsersGroups.USERS_GROUPS;

@ApplicationScoped
public class UsersRepository {

    @Inject
    DSLContext dsl;

    public UsersVo findUserById(Integer id) {
        return dsl.selectFrom(USERS)
                .where(USERS.ID.equal(id))
                .fetchOneInto(UsersVo.class);
    }

    public UsersVo findUserByEmailAndPassword(String email, String password) {
        return dsl.selectFrom(USERS)
                .where(USERS.EMAIL.equal(email)
                        .and(USERS.PASSWORD.equal(password)))
                .fetchOneInto(UsersVo.class);
    }

    public List<UsersVo> findAllUsers() {
        return dsl.selectFrom(USERS)
                .fetchInto(UsersVo.class);
    }

    public UsersVo createUser(UsersVo user) {
        return dsl.insertInto(USERS)
                .set(USERS.EMAIL, user.getEmail())
                .set(USERS.PASSWORD, user.getPassword())
                .set(USERS.NAME, user.getName())
                .returning(USERS.ID, USERS.NAME)
                .fetchOne()
                .into(UsersVo.class);
    }

    public UsersVo updateUserById(Integer id, UsersVo user) {
        return dsl.update(USERS)
                .set(USERS.PASSWORD, user.getPassword())
                .set(USERS.NAME, user.getName())
                .where(USERS.ID.equal(id))
                .returning(USERS.ID, USERS.NAME)
                .fetchOne()
                .into(UsersVo.class);
    }

    public void deleteUserById(Integer id) {
        dsl.deleteFrom(USERS)
                .where(USERS.ID.equal(id))
                .execute();
    }

    public List<PermissionsVo> findPermissionsByUserEmail(String email) {
        return dsl.selectDistinct(PERMISSIONS.PERMISSION_NAME)
                .from(USERS)
                .join(USERS_GROUPS).on(USERS_GROUPS.USER_ID.equal(USERS.ID))
                .join(GROUPS_ROLES).on(GROUPS_ROLES.GROUP_ID.equal(USERS_GROUPS.GROUP_ID))
                .join(ROLES_PERMISSIONS).on(ROLES_PERMISSIONS.ROLE_ID.equal(GROUPS_ROLES.ROLE_ID))
                .join(PERMISSIONS).on(PERMISSIONS.ID.equal(ROLES_PERMISSIONS.PERMISSION_ID))
                .where(USERS.EMAIL.equal(email))
                .fetchInto(PermissionsVo.class);
    }
}
