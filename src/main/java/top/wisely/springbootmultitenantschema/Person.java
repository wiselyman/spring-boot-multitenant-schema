package top.wisely.springbootmultitenantschema;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.TenantId;

@Entity
@Data

public class Person {
    @Id
    private Long id;
    @TenantId
    private String tenantId;
    private String name;
    private Integer age;

}
