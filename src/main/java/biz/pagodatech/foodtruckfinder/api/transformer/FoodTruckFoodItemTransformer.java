package biz.pagodatech.foodtruckfinder.api.transformer;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckFoodItemEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckFoodItemResource;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckFoodItemReviewResource;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FoodTruckFoodItemTransformer {

    private FoodTruckFoodItemReviewTransformer transformer;

    public FoodTruckFoodItemResource transform(FoodTruckFoodItemEntity ent){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication!=null ? authentication.getName() : null;

        List<FoodTruckFoodItemReviewResource> reviews = ent.getReviews().stream().map(transformer::transform).collect(Collectors.toList());
        FoodTruckFoodItemResource res
                = new FoodTruckFoodItemResource( ent.getId(), ent.getName(), ent.getDescription(), ent.getPrice().doubleValue(), ent.getPhoto(), reviews);
        res.setCanLike(!ent.getLikes().stream().filter(like -> like.getUser().getUsername().equals(currentPrincipalName)).findAny().isPresent());
        res.setNumberLikes(ent.getLikes().size());
        return res;
    }

    public List<FoodTruckFoodItemResource> transform(Collection<FoodTruckFoodItemEntity> entities){
        return entities.stream().map(this::transform).collect(Collectors.toList());
    }

}
