package com.interview.file.field;

import com.interview.file.formatvalidation.HasInvalidCurrencyFormat;
import com.interview.model.RecordModel;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author Trung Tran
 **/
final class CallCost extends Field implements HasInvalidCurrencyFormat {

    CallCost(Field prevField) {
        super(prevField);
    }

    @Override
    int defaultMaximumLength() {
        return 5;
    }

    @Override
    void updateModel(RecordModel recordModel) {
        recordModel.setCallCost(this.fieldValue);
    }


    @Override
    protected List<Predicate<String>> appendingFalsyRules() {
        return List.of(isNotCurrencyFormat());
    }

}
