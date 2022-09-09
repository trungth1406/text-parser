package com.interview.grouper;


import com.interview.file.field.RecordRow;
import com.interview.model.RecordModel;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 *
 *
 * Some kind of Util class for grouping records
 * @author Trung Tran
 *
 *
 **/
public class RecordGrouper {


    public static Map<String, Integer> groupByAccountNumber(List<RecordRow> rows) {
        return rows.stream().map(RecordRow::getRecordModel).collect(Collectors.groupingBy(RecordModel::getAccountNumber,
                Collectors.summingInt((RecordModel recordModel) -> Integer.parseInt(recordModel.getCallCost()))));
    }

    public static Map<String, Integer> groupByCallType(List<RecordRow> rows) {
        return rows.stream().map(RecordRow::getRecordModel).collect(Collectors.groupingBy(RecordModel::getCallType,
                Collectors.summingInt((RecordModel recordModel) -> Integer.parseInt(recordModel.getCallCost()))));
    }


    // Keep the original string , format it later
    public static Map<String, Integer> groupByDay(List<RecordRow> rows) {
        return rows.stream().map(RecordRow::getRecordModel).collect(Collectors.groupingBy(RecordModel::getStartTime,
                Collectors.summingInt((RecordModel recordModel) -> Integer.parseInt(recordModel.getCallCost()))));
    }

}
