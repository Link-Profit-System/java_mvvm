package security;

import com.example.generated.tables.pojos.PermissionsVo;
import com.example.generated.tables.pojos.UsersVo;
import io.quarkus.cache.CacheResult;
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
import repository.PermissionsRepository;
import repository.UsersRepository;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@ApplicationScoped
public class PermissionAugmentor implements SecurityIdentityAugmentor {

    @Inject
    private PermissionsRepository permissionsRepository;

    public static final String PERMISSION_CACHE_NAME = "permission-cache";

    @Override
    public Uni<SecurityIdentity> augment(SecurityIdentity identity, AuthenticationRequestContext context) {
        // 未認証ユーザーの場合は、何もせずにそのまま返す
        if (identity.isAnonymous()) {
            return Uni.createFrom().item(identity);
        }

        // キャッシュからパーミッションを取得、存在しない場合はデータベースから取得
        return getPermissionsFromCacheOrDb(identity.getPrincipal().getName())
                .map(permissions -> {
                    // パーミッションが見つからない場合は、元のSecurityIdentityをそのまま返す
                    if (permissions.isEmpty()) {
                        return identity;
                    }

                    // パーミッションのSetを作成
                    Set<String> permissionSet = permissions.stream().collect(Collectors.toSet());

                    // 元のSecurityIdentityをベースに新しいSecurityIdentityを作成
                    QuarkusSecurityIdentity.Builder builder = QuarkusSecurityIdentity.builder(identity);

                    // パーミッションをロールとして追加
                    builder.addRoles(permissionSet);

                    return builder.build();
                });
    }

    @CacheResult(cacheName = PERMISSION_CACHE_NAME)
    public Uni<Set<String>> getPermissionsFromCacheOrDb(String email) {
        // パーミッションをemailを用いデータベースから取得
        return Uni.createFrom().item(permissionsRepository.findPermissionsByUserEmail(email)
                .stream()
                .map(PermissionsVo::getPermissionName)
                .collect(Collectors.toSet()));
    }
}
