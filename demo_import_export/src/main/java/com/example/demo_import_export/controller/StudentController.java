package com.example.demo_import_export.controller;

import com.example.demo_import_export.entity.Student;
import com.example.demo_import_export.importexport.serviceimpl.StudentServiceImpl;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

@CrossOrigin("*")
@RestController
public class StudentController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @PostMapping("/api/upload")
    public void uploadAndFillExcelFile(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Đã nhận được api và đang ghi");


        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(inputStream);

//            // Tạo một trang tính trong workbook
//            workbook.createSheet("Sheet 1");

            // Truy xuất đến Sheet để ghi dữ liệu vào file Excel
            Sheet sheet = workbook.getSheetAt(0);

            // Đọc dữ liệu từ MultipartFile và ghi vào các ô tương ứng trong file Excel
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            int rowNumber = 0;
            while ((line = reader.readLine()) != null) {
                Row row = sheet.createRow(rowNumber++);
                String[] splitLine = line.split(",");
                int cellNumber = 0;
                for (String cellValue : splitLine) {
                    Cell cell = row.createCell(cellNumber++);
                    cell.setCellValue(cellValue);
                }
            }

            // Lưu Workbook vào một file Excel
            try (FileOutputStream outputStream = new FileOutputStream("D:\\Hoanh\\Import_Export_Excel\\demo_import_export\\src\\main\\java\\com\\example\\demo_import_export\\data\\ImportExcel.xlsx")) {
                workbook.write(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PostMapping("/api/uploadDB")
    public void uploadAndFillDB(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Đã nhận được api và đang ghi vào DB");

        try (InputStream inputStream = file.getInputStream()) {
//            Tạo 1 workbook
            Workbook workbook = WorkbookFactory.create(inputStream);
//            Lấy ra trang tính đầu tiên
            Sheet sheet = workbook.getSheetAt(0);

            int rowNum = 0;
            for (Row row : sheet) {
                // Bỏ qua hàng đầu tiên (có chỉ số 0)
                if (rowNum == 0) {
                    rowNum++;
                    continue;
                }
                String code = row.getCell(0).getStringCellValue();
                System.out.println(code);
                String name = row.getCell(1).getStringCellValue();
                System.out.println(name);
                int age = (int) row.getCell(2).getNumericCellValue();
                System.out.println(age);
                Student student = studentServiceImpl.findStudentByCode(code);

                if ( student == null) {
                    student = new Student(code, name, age);
                    studentServiceImpl.create(student);
                }else {
                    student.setCode(code);
                    student.setName(name);
                    student.setAge(age);
                    studentServiceImpl.edit(student);
                }
                rowNum++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}










