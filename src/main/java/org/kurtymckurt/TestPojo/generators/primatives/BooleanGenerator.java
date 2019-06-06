package org.kurtymckurt.TestPojo.generators.primatives;

import org.kurtymckurt.TestPojo.generators.Generator;
import org.kurtymckurt.TestPojo.limiters.Limiter;
import org.kurtymckurt.TestPojo.util.RandomUtils;

import java.lang.reflect.Field;

public class BooleanGenerator implements Generator {

    @Override
    public Object generate(Class<?> clazz, Field field, Limiter limiter) {
        return RandomUtils.getRandomBoolean();
    }

    @Override
    public boolean supportsType(Class<?> clazz) {
        return clazz.isAssignableFrom(Boolean.class);
    }
}