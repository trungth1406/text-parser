package com.interview.file.field;


import com.interview.model.RecordModel;

/**
 * @author Trung Tran
 **/
final class AccountNumber extends Field {


    AccountNumber() {
        super();
    }

    @Override
    int defaultMaximumLength() {
        return 10;
    }

    @Override
    void updateModel(RecordModel recordModel) {
        recordModel.setAccountNumber(this.fieldValue);
    }



}
