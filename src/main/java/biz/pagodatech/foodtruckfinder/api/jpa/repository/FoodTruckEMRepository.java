package biz.pagodatech.foodtruckfinder.api.jpa.repository;

import biz.pagodatech.foodtruckfinder.api.auth.AppUserPrincipal;
import biz.pagodatech.foodtruckfinder.api.entity.AppUserEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodItemEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodItemLikesEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodItemReviewEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckLikesEntity;
import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckReviewEntity;
import biz.pagodatech.foodtruckfinder.api.exception.AppUserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class FoodTruckEMRepository {
    private EntityManager em;
    private AppUserRepository userRepo;

    public List<FoodTruckEntity> getFoodTrucks(){
        EntityGraph entityGraph = em.getEntityGraph("food-truck-with-items-fully-populated");
        return em.createQuery("SELECT f FROM FoodTruckEntity f", FoodTruckEntity.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
    }

    private AppUserEntity getAppUserByUsername(String username){
        AppUserEntity au = new AppUserEntity();
        au.setUsername(username);
        Example<AppUserEntity> example = Example.of(au);
        Optional<AppUserEntity> optional = userRepo.findOne(example);
        return optional.orElseThrow(() -> new AppUserNotFoundException(username));
    }

    public void createFoodTruckReview(AppUserPrincipal principal, FoodTruckEntity truckEntity, Long rating, String review) {
        AppUserEntity user = getAppUserByUsername(principal.getUsername());
        FoodTruckReviewEntity e = new FoodTruckReviewEntity(rating, review, user, truckEntity);
        em.persist(e);
    }

    public void createFoodItemReview(AppUserPrincipal principal, FoodItemEntity foodItemEntity, Long rating, String review) {
        AppUserEntity user = getAppUserByUsername(principal.getUsername());
        FoodItemReviewEntity e = new FoodItemReviewEntity(rating, review, user, foodItemEntity);
        em.persist(e);
    }

    public void createFoodItemLike(AppUserPrincipal principal, FoodItemEntity foodItemEntity) {
        AppUserEntity user = getAppUserByUsername(principal.getUsername());
        FoodItemLikesEntity e = new FoodItemLikesEntity(foodItemEntity, user);
        em.persist(e);
    }

    public void createFoodTruckLike(AppUserPrincipal principal, FoodTruckEntity foodTruckEntity) {
        AppUserEntity user = getAppUserByUsername(principal.getUsername());
        FoodTruckLikesEntity e = new FoodTruckLikesEntity(foodTruckEntity, user);
        em.persist(e);
    }
}