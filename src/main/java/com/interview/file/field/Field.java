package com.interview.file.field;


import com.interview.model.RecordModel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Field represents different type of column cells on each row of .txt file.
 * There can be many types of fields, each field has its own implementation of extractValue() method. See {@link #extractValue(String)for more details.
 * Field with null previous field should be the one that is the first field in the row.
 * All implementation should not be exposed to outside of this package i.e default or protected only.
 * @author Trung Tran
 **/
abstract class Field {


    private int maximumLength;
    private List<Predicate<String>> validateRules;

    protected Field previousField;
    protected String fieldValue;


    protected Field() {
        this(0, null);

    }

    protected Field(Field previousField) {
        this(0, previousField);
    }


    @SuppressWarnings("Unchecked")
    protected Field(int maximumLength) {
        this(maximumLength, null);
    }


    // previous field previousField should be carefully linked
    protected Field(int maximumLength, Field previousField) {
        this.maximumLength = maximumLength <= 0 ? defaultMaximumLength() : maximumLength;
        this.previousField = previousField;
        this.validateRules = new ArrayList<>();
        this.validateRules.add(this::validateFieldLength);
        this.validateRules.addAll(this.appendingFalsyRules());
    }


    protected Field(String fieldValue) {
        this.fieldValue = fieldValue;

    }


    /**
     * This can be replaced with linked list implementation.
     *
     * @return Update field value from the original String and return current instance .
     */
    protected Field extractValue(String line) {
        int lastEndPos = 0;
        Field previousField = this.previousField;
        // Any instance with non-null previous field will have it start index by sum of its previous fields
        while (previousField != null) {
            lastEndPos += previousField.getMaximumLength();
            previousField = previousField.previousField;
        }
        int endIndex = lastEndPos + getMaximumLength();
        int lineLength = line.length();
        // If end index is greater than line length, then it means that the field maximum length is not reached
        // This happens with last field in the row
        if (endIndex > lineLength - 1) {
            while (endIndex > lineLength) {
                endIndex--;
            }
        }
        // trim is used because some field does not reach its maximum length
        this.fieldValue = line.substring(lastEndPos, endIndex).trim();
        this.validate();
        return this;
    }

    abstract int defaultMaximumLength();


    // This fieldValue can be used to set to one or more properties of RecordModel if necessary.
    // For the requirement is  to set the correct RecordModel  properties with this field value.
    abstract void updateModel(RecordModel recordModel);

    // Any appending rules for validating should be added to this method. For e.g: date format , call type format
    protected List<Predicate<String>> appendingFalsyRules() {
        return new ArrayList<>();
    }

    // Validate after extractValue() is called
    private void validate() {
        for (Predicate<String> rule : this.validateRules) {
            if (rule.test(this.fieldValue)) {
                throw new IllegalArgumentException(String.format("Field %s 's value is invalid", this.getClass().getSimpleName()));
            }
        }
    }

    // Default validate rule
    private boolean validateFieldLength(String fieldValue) {
        return fieldValue == null || fieldValue.trim().isBlank();
    }


    protected int getMaximumLength() {
        return this.maximumLength <= 0 ? defaultMaximumLength() : this.maximumLength;
    }


}
