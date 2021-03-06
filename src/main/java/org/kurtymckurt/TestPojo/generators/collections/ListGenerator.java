package org.kurtymckurt.TestPojo.generators.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListGenerator<T> extends GenericCollectionGenerator<Collection<T>> {

    @Override
    boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(List.class) || clazz.isAssignableFrom(Collection.class);
    }

    @Override
    <T> Collection<T> createInstance() {
        return new ArrayList<>();
    }
}
