package biz.pagodatech.foodtruckfinder.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name="app_user")
public class AppUserEntity extends  StandardEntity {
    private String username;
}
