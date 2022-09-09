package com.interview.file.formatvalidation;

import java.util.function.Predicate;

/**
 * @author Trung Tran
 **/
public interface HasInvalidPhoneFormat {

    default Predicate<String> isNotPhoneNumberFormat() {
        return (String fieldValue) -> {
            try {
                Long.parseLong(fieldValue);
                return false;
            } catch (Exception e) {
                return true;
            }
        };
    }
}
