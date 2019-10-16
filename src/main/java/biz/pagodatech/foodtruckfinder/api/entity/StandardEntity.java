package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class StandardEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Long id;
    @ManyToOne
    @JoinColumn(name="created_by")
    @EqualsAndHashCode.Exclude
    private AppUserEntity createdBy;
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name="modified_by")
    @EqualsAndHashCode.Exclude
    private AppUserEntity modifiedBy;
    private Date modifiedDate;

}
