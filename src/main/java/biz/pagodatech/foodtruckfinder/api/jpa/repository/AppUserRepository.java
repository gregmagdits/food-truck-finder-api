package biz.pagodatech.foodtruckfinder.api.jpa.repository;

import biz.pagodatech.foodtruckfinder.api.entity.AppUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface AppUserRepository extends CrudRepository<AppUserEntity, Long>, QueryByExampleExecutor<AppUserEntity> {
    public AppUserEntity findByUsername(String username);
}
