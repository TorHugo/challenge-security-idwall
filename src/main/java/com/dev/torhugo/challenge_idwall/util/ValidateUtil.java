package com.dev.torhugo.challenge_idwall.util;

import java.util.ArrayList;
import java.util.Objects;

public class ValidateUtil {
    public ValidateUtil(){

    }

    public static <T> Boolean validateObjectNull(final T item){
        return Objects.isNull(item);
    }

    public static <T> Boolean validateObjectNonNull(final T item){
        return Objects.nonNull(item);
    }

    public static <T> Boolean validateEmptyList(final T item){
        if (validateObjectNonNull(item) &&
                item instanceof ArrayList<?> list &&
                !list.isEmpty())
                return Boolean.TRUE;

        return Boolean.FALSE;
    }
}
