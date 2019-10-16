package biz.pagodatech.foodtruckfinder.api.transformer;

import biz.pagodatech.foodtruckfinder.api.entity.FoodTruckFoodItemEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodTruckFoodItemResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodTruckFoodItemTransformer {

    public FoodTruckFoodItemResource transform(FoodTruckFoodItemEntity ent){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication!=null ? authentication.getName() : null;
        FoodTruckFoodItemResource res
                = new FoodTruckFoodItemResource( ent.getId(), ent.getName(), ent.getDescription(), ent.getPrice().doubleValue(), ent.getPhoto());
        res.setCanLike(!ent.getLikes().stream().filter(like -> like.getUser().getUsername().equals(currentPrincipalName)).findAny().isPresent());
        res.setNumberLikes(ent.getLikes().size());
        return res;
    }

    public List<FoodTruckFoodItemResource> transform(Collection<FoodTruckFoodItemEntity> entities){
        return entities.stream().map(this::transform).collect(Collectors.toList());
    }

}
