package com.interview;

import com.interview.file.field.RecordRow;
import com.interview.grouper.RecordGrouper;
import com.interview.model.ReportModel;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Trung Tran
 **/
public class Parser {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter input file path");
        String inputFilePath = scanner.nextLine();

        if (!Files.isRegularFile(new File(inputFilePath).toPath())) {
            System.out.println("Input path is not a File");
            return;
        }



        System.out.println("Enter output directory path");
        String outputFilePath = scanner.nextLine();
        if (!FileUtils.isDirectory(new File(outputFilePath))) {
            System.out.println("Output path is not a directory");
            return;
        }
        scanner.close();

        File inputFileContent = FileUtils.getFile(inputFilePath);

        List<RecordRow> rows = new ArrayList<>();
        for (String line : FileUtils.readLines(inputFileContent, "UTF-8")) {
            RecordRow recordRow = new RecordRow(line.trim());
            rows.add(recordRow);
        }

        Map<String, Integer> groupByAccountNumber = RecordGrouper.groupByAccountNumber(rows);
        Map<String, Integer> groupByCallType = RecordGrouper.groupByCallType(rows);
        Map<String, Integer> groupByDay = RecordGrouper.groupByDay(rows);

        System.out.println("groupByAccountNumber: " + groupByAccountNumber);
        System.out.println("groupByCallType: " + groupByCallType);
        System.out.println("groupByDay: " + groupByDay);


        ReportModel reportModel = new ReportModel(groupByAccountNumber);
        reportModel.setHeaderName(List.of("Account Number", "Total Call Cost"));



        File outputFile = new File(outputFilePath + "groupByAccountNumber.txt");
        FileUtils.write(outputFile, reportModel.toString(), "UTF-8");

        reportModel.setRowValue(groupByCallType);
        reportModel.setHeaderName(List.of("Call Type", "Total Call Cost"));
        outputFile = new File(outputFilePath + "groupByCallType.txt");
        FileUtils.write(outputFile, reportModel.toString(), "UTF-8");


        reportModel.setRowValue(groupByDay);
        reportModel.setHeaderName(List.of("Day", "Total Call Cost"));
        outputFile = new File(outputFilePath + "groupByDay.txt");
        FileUtils.write(outputFile, reportModel.toString(), "UTF-8");


    }


}
