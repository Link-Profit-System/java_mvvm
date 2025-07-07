package repository;

import com.example.generated.tables.pojos.PermissionsVo;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import security.PermissionAugmentor;

import java.util.List;

import static com.example.generated.tables.JGroupsRoles.GROUPS_ROLES;
import static com.example.generated.tables.JPermissions.PERMISSIONS;
import static com.example.generated.tables.JRolesPermissions.ROLES_PERMISSIONS;
import static com.example.generated.tables.JUsers.USERS;
import static com.example.generated.tables.JUsersGroups.USERS_GROUPS;

@ApplicationScoped
public class PermissionsRepository implements PanacheRepositoryBase<PermissionsVo, Integer> {

    @Inject
    DSLContext dsl;

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
