package com.ueg.nutshellbackend.common.util;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

public class CollectionUtil {
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }
}
