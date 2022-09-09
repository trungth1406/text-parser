package com.interview.file.field;

import com.interview.model.RecordModel;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Trung Tran
 **/
final class CallType extends Field {

    private static final List<String> enumValues = Arrays.stream(CallTypeEnum.values()).map(Enum::name)
            .collect(Collectors.toList());


    CallType(Field prevField) {
        super(prevField);
    }

    @Override
    int defaultMaximumLength() {
        return 1;
    }

    @Override
    void updateModel(RecordModel recordModel) {
        recordModel.setCallType(this.fieldValue);
    }


    @Override
    protected List<Predicate<String>> appendingFalsyRules() {
        return List.of(
                (String fieldValue) ->  !enumValues.contains(fieldValue)
        );
    }


    // For the sake of simplicity
    private enum CallTypeEnum {
        P, M, S
    }
}
