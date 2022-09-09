package com.interview.model;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Simple Report model for output file format.
 * [ Col A   Col B ]
 * ...rowValue.keys() rowValue.values()
 *
 * @author Trung Tran
 **/
public class ReportModel {

    private List<String> headerName;
    private Map<String, Integer> rowValue;

    public ReportModel(Map<String, Integer> rowValue) {
        this.rowValue = rowValue;
    }

    public void setHeaderName(List<String> headerName) {
        this.headerName = headerName;
    }

    public void setRowValue(Map<String, Integer> rowValue) {
        this.rowValue = rowValue;
    }


    @Override
    public String toString() {
        return Arrays.toString(headerName.toArray()) + "\n"
                + join() + "\n";
    }

    private String join() {
        return Joiner.on("\n").withKeyValueSeparator("  ").join(this.rowValue);
    }
}
