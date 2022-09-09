package com.interview.file.field;

import com.interview.file.formatvalidation.HasInvalidPhoneFormat;
import com.interview.model.RecordModel;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Trung Tran
 **/
final class CallingNumber extends Field implements HasInvalidPhoneFormat {

    CallingNumber(Field prevField) {
        super(prevField);
    }


    @Override
    int defaultMaximumLength() {
        return 15;
    }

    @Override
    void updateModel(RecordModel recordModel) {
        recordModel.setCallingNumber(this.fieldValue);
    }


    @Override
    protected List<Predicate<String>> appendingFalsyRules() {
        return List.of(isNotPhoneNumberFormat());
    }
}
