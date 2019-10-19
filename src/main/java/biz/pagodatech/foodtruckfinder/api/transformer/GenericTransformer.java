package biz.pagodatech.foodtruckfinder.api.transformer;

import lombok.SneakyThrows;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenericTransformer <T,U> {

    @SneakyThrows
    public <T,U> Object transform(T entity, Class resource){
        ArrayList<Object> constructorFields = new ArrayList();
        List<String> resourceFields = FieldUtils.getAllFieldsList(resource).stream().map(Field::getName).collect(Collectors.toList());
        for (Field f : FieldUtils.getAllFieldsList(entity.getClass())) {
            if (resourceFields.contains(f.getName())){
                PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(entity.getClass(), f.getName());
                Object propertyValue = pd.getReadMethod().invoke(entity);
                if (Collection.class.isAssignableFrom(pd.getPropertyType())){
                    // run transform on
                }
                constructorFields.add(propertyValue);
            }
        }
        List<Class> typesList = constructorFields.stream().map(Object::getClass).collect(Collectors.toList());

        Class[] typesArray = typesList.toArray(new Class[typesList.size()]);
        // check if class object extends a collection object
        // Collection.class.isAssignableFrom(typesList.get(5));

        Object []  args = constructorFields.toArray(new Object[constructorFields.size()]);
        return resource.getConstructor(typesArray).newInstance(args);
    }
}
