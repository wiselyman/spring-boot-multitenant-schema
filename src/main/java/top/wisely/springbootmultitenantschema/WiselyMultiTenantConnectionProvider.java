package top.wisely.springbootmultitenantschema;


import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@Component
public class WiselyMultiTenantConnectionProvider implements MultiTenantConnectionProvider {

    private final DataSource dataSource;

    public WiselyMultiTenantConnectionProvider(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Connection getAnyConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        String schema = tenantIdentifier;
        final Connection connection = getAnyConnection();
        connection.setSchema(schema);
        return connection;
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        connection.setSchema("public");
        connection.close();
    }


    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public boolean isUnwrappableAs(Class<?> unwrapType) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        throw new UnsupportedOperationException("Can't unwrap this.");
    }
}
