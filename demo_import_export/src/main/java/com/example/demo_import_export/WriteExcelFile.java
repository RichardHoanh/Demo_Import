package com.example.demo_import_export;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class WriteExcelFile {

    public static void main(String[] args) throws IOException {

        Workbook workbook = new XSSFWorkbook();

        // Đặt tên cho Sheet
        Sheet sheet = workbook.createSheet("hoanh");

        // Tạo dữ liệu mẫu
        Object[][] data = {
                {"Name", "Age", "Gender"},
                {"Hùng", 25, "Nữ"},
                {"Đức Anh", 30, "Nam"},
                {"Tom", 35, "Male"},
                {"Lisa", 28, "Female"}
        };


        // Ghi dữ liệu vào bảng
        int rowNum = 0;
        for (Object[] rowData : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : rowData) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                } else {
                    cell.setCellValue((String) field.toString());
                }
            }
        }

        // Lưu tệp tin Excel
        File file = new File("D:\\Hoanh\\Import_Export_Excel\\demo_import_export\\src\\main\\java\\com\\example\\demo_import_export\\data\\hoanh.xlsx");
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("Dữ liệu đã được ghi vào file Excel");
    }

}
