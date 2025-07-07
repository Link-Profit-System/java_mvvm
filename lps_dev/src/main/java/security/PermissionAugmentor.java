package security;

import com.example.generated.tables.pojos.PermissionsVo;
import com.example.generated.tables.pojos.UsersVo;
import io.quarkus.security.identity.AuthenticationRequestContext;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.identity.SecurityIdentityAugmentor;
import io.quarkus.security.runtime.QuarkusSecurityIdentity;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.UsersRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@ApplicationScoped
public class PermissionAugmentor implements SecurityIdentityAugmentor {

    @Inject
    private UsersRepository usersRepository;

    @Override
    public Uni<SecurityIdentity> augment(SecurityIdentity identity, AuthenticationRequestContext context) {
        // 未認証ユーザーの場合は、何もせずにそのまま返す
        if (identity.isAnonymous()) {
            return Uni.createFrom().item(identity);
        }

        // Supplierを使うことで、パーミッションの計算を遅延実行できる
        return Uni.createFrom().item(build(identity));
    }

    private SecurityIdentity build(SecurityIdentity identity) {
        // JWTの'sub'や'upn'クレームからユーザーのメールアドレスを取得
        String email = identity.getPrincipal().getName();

        // emailからユーザのパーミッションを取得
        List<PermissionsVo> permissionsVoList = usersRepository.findPermissionsByUserEmail(email);
        if (CollectionUtils.isEmpty(permissionsVoList)) {
            // パーミッションが見つからない場合は、元のidentityを返す
            return identity;
        }

        // パーミッションのSetを作成
        Set<String> permissions = permissionsVoList.stream()
                .map(PermissionsVo::getPermissionName)
                .collect(Collectors.toSet());

        // 元のSecurityIdentityをベースに新しいSecurityIdentityを作成
        QuarkusSecurityIdentity.Builder builder = QuarkusSecurityIdentity.builder(identity);

        // パーミッションをロールとして追加
        builder.addRoles(permissions);

        return builder.build();
    }
}
