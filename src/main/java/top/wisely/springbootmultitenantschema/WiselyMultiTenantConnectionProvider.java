package top.wisely.springbootmultitenantschema;


import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;


import javax.sql.DataSource;


public class WiselyMultiTenantConnectionProvider extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {


    @Override
    protected DataSource selectAnyDataSource() {
        return null;
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        return null;
    }
}
