package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class StandardEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name="created_by")
    private AppUserEntity createdBy;
    private Date createdDate;
    @OneToOne
    @JoinColumn(name="modified_by")
    private AppUserEntity modifiedBy;
    private Date modifiedDate;

}
