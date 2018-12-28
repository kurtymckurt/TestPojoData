package org.kurtymckurt.TestPojoData.generators.collections;

import org.kurtymckurt.TestPojoData.PojoBuilder;
import org.kurtymckurt.TestPojoData.PojoBuilderConfiguration;
import org.kurtymckurt.TestPojoData.generators.Generator;
import org.kurtymckurt.TestPojoData.limiters.Limiter;
import org.kurtymckurt.TestPojoData.util.LimiterUtils;
import org.kurtymckurt.TestPojoData.util.NullSafeLimits;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public abstract class GenericCollectionGenerator implements Generator {
    @Override
    public Object generate(Class<?> clazz, Field field, Limiter limiter) {
        Collection<Object> instance = createInstance();
        Class<?> newClazz = (Class<?>)((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
        PojoBuilder pojoBuilder = new PojoBuilder(
                PojoBuilderConfiguration.builder()
                        .clazz(newClazz)
                        .build());
        NullSafeLimits nullSafeLimits = LimiterUtils.getNullSafeLimits(0, 100, 100, limiter);
        for(int i = 0; i < nullSafeLimits.size; i++){
            instance.add(pojoBuilder.buildObject());
        }

        return instance;
    }

    @Override
    public boolean supportsType(Class<?> clazz) {
        return supports(clazz);
    }

    abstract boolean supports(Class<?> clazz);
    abstract <T> Collection<T> createInstance();
}
