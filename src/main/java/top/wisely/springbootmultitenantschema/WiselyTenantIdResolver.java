package top.wisely.springbootmultitenantschema;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

import java.util.Optional;

public class WiselyTenantIdResolver implements CurrentTenantIdentifierResolver {
    private static final ThreadLocal<String> CURRENT_TENANT = new ThreadLocal<>();
    public void setCurrentTenant(String currentTenant) {
        CURRENT_TENANT.set(currentTenant);
    }

    @Override
    public String resolveCurrentTenantIdentifier() {
        return Optional.ofNullable(CURRENT_TENANT.get()).orElse("unknown");
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }

}
