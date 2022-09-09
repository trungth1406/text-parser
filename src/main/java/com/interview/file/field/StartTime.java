package com.interview.file.field;

import com.interview.file.formatvalidation.HasInvalidDateFormat;
import com.interview.model.RecordModel;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Trung Tran
 **/
final class StartTime extends Field implements HasInvalidDateFormat {

    StartTime(Field prevField) {
        super(prevField);
    }

    @Override
    int defaultMaximumLength() {
        return 14;
    }

    @Override
    void updateModel(RecordModel recordModel) {
        recordModel.setStartTime(this.fieldValue);
    }

    @Override
    protected List<Predicate<String>> appendingFalsyRules() {
        return List.of(isNotDateFormat());
    }
}
