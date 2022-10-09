package top.wisely.springbootmultitenantschema;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WiselyTenantIdResolver implements CurrentTenantIdentifierResolver {
    private static final ThreadLocal<String> CURRENT_TENANT = new ThreadLocal<>();
    public void setCurrentTenant(String currentTenant) {
        CURRENT_TENANT.set(currentTenant);
    }

    @Override
    public String resolveCurrentTenantIdentifier() {
        return Optional.ofNullable(CURRENT_TENANT.get()).orElse("public");
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }

}
