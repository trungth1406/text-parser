package com.interview.file.formatvalidation;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.function.Predicate;

/**
 * @author Trung Tran
 **/
public interface HasInvalidCurrencyFormat {

    default Predicate<String> isNotCurrencyFormat() {
        return (String fieldValue) -> !NumberUtils.isCreatable(fieldValue);
    }
}

