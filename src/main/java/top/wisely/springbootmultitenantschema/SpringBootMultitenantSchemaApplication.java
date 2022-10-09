package top.wisely.springbootmultitenantschema;

import org.hibernate.engine.jdbc.connections.spi.DataSourceBasedMultiTenantConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootMultitenantSchemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultitenantSchemaApplication.class, args);
	}

	@Bean
	public MultiTenantConnectionProvider multiTenantConnectionProvider (){
		return new DataSourceBasedMultiTenantConnectionProviderImpl();
	}

}
