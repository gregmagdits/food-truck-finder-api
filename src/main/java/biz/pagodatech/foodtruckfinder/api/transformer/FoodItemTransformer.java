package biz.pagodatech.foodtruckfinder.api.transformer;

import biz.pagodatech.foodtruckfinder.api.entity.FoodItemEntity;
import biz.pagodatech.foodtruckfinder.api.resource.FoodItemResource;
import biz.pagodatech.foodtruckfinder.api.resource.FoodItemReviewResource;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FoodItemTransformer {

    private FoodItemReviewTransformer transformer;

    public FoodItemResource transform(FoodItemEntity ent){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication!=null ? authentication.getName() : null;

        List<FoodItemReviewResource> reviews = ent.getReviews().stream().map(transformer::transform).collect(Collectors.toList());
        FoodItemResource res
                = new FoodItemResource( ent.getId(), ent.getName(), ent.getDescription(), ent.getPrice().doubleValue(), ent.getPhoto(), reviews);
        res.setCanLike(!ent.getLikes().stream().filter(like -> like.getUser().getUsername().equals(currentPrincipalName)).findAny().isPresent());
        res.setNumberLikes(ent.getLikes().size());
        return res;
    }

    public List<FoodItemResource> transform(Collection<FoodItemEntity> entities){
        return entities.stream().map(this::transform).collect(Collectors.toList());
    }

}
