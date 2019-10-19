package biz.pagodatech.foodtruckfinder.api.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
@Component
public class CollectionUtils {
    public <T> Collection toCollection(Iterable<T> it){
        Collection e = new ArrayList<T>();
        it.iterator().forEachRemaining(e::add);
        return e;
    }
}
