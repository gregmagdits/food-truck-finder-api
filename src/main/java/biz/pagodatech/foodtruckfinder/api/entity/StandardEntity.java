package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class StandardEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    @Column(name="created_by")
    @EqualsAndHashCode.Exclude
    private String createdBy;
    private Date createdDate;
    @Column(name="modified_by")
    @EqualsAndHashCode.Exclude
    private String modifiedBy;
    private Date modifiedDate;

}
