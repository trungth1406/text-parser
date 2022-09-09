package com.interview.file.formatvalidation;

import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

/**
 * @author Trung Tran
 **/
public interface HasInvalidDateFormat {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    default Predicate<String> isNotDateFormat() {
        return (String fieldValue) -> {
            try {
                dateTimeFormatter.parse(fieldValue);
                return false;
            } catch (Exception e) {
                return true;
            }
        };
    }
}
