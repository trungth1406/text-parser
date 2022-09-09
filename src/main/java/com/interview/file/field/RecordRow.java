package com.interview.file.field;


import com.interview.model.RecordModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Hold a list of field as per requirement. More field can be added and add to the list.
 *
 * @author Trung Tran
 **/
public final class RecordRow {

    private final List<Field> fields;

    public RecordRow(String originalLine) {
        this(originalLine, new ArrayList<>());
    }


    // Self defined fields should be carefully linked
    public RecordRow(String originalString, List<Field> fields) {
        this.fields = fields;
        if (!fields.isEmpty() && hasNoStartingField(fields)) {
            throw new IllegalArgumentException("At least on of the field should start with no previous field. One Cycle might happens");
        } else {
            Field accountNumber = new AccountNumber().extractValue(originalString);
            Field callingNumber = new CallingNumber(accountNumber).extractValue(originalString);
            Field dialledNumber = new DialledNumber(callingNumber).extractValue(originalString);
            Field startTime = new StartTime(dialledNumber).extractValue(originalString);
            Field endTime = new EndTime(startTime).extractValue(originalString);
            Field callType = new CallType(endTime).extractValue(originalString);
            Field callCost = new CallCost(callType).extractValue(originalString);

            this.fields.add(accountNumber);
            this.fields.add(callingNumber);
            this.fields.add(dialledNumber);
            this.fields.add(startTime);
            this.fields.add(endTime);
            this.fields.add(callingNumber);
            this.fields.add(callType);
            this.fields.add(callCost);
        }
    }

    private boolean hasNoStartingField(List<Field> fields) {
        return fields.stream().noneMatch(field -> field.previousField == null);
    }

    // Main method to extract the model for later grouping
    public RecordModel getRecordModel() {
        RecordModel recordModel = new RecordModel();
        for (Field field : fields) {
            field.updateModel(recordModel);
        }
        return recordModel;
    }


}
