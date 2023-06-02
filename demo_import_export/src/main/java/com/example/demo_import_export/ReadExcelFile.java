package com.example.demo_import_export;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// Đọc dữ liệu từ file Excel ra màn hình terminal
public class ReadExcelFile {

    public static void main(String[] args) throws IOException {

        File file = new File("D:\\Demo\\DemoCreateProject\\src\\main\\java\\data\\hoanh.xlsx");
        FileInputStream inputStream = new FileInputStream(file);

        /** Bước 1:
         * Tạo đối tượng Workbook đại từ 1 FileInputStream đại diện cho 1 tệp Excel
         */
        Workbook workbook = new XSSFWorkbook(inputStream);

        /** Bước 2:
         * Lấy ra Sheet đầu tiên trong Workbook
         */
        Sheet sheet = workbook.getSheetAt(0);

        /** Bước 3:
         * Duyệt qua từng hàng, từng cột của bảng với điều kiện là nhận diện được loại dữ liệu của ô
         * Nếu không nhận diện được kiểu dự liệu của ô thì báo "Unknown cell type"
         */

//        for (Row row : sheet) {
//            for (Cell cell : row) {
//                switch (cell.getCellType()) {
//                    case 1 :
//                        System.out.print(cell.getStringCellValue() + "\t");
//                        break;
//                    case 2:
//                        System.out.print(cell.getNumericCellValue() + "\t");
//                        break;
//                    case 3:
//                        System.out.print(cell.getBooleanCellValue() + "\t");
//                        break;
//                    default:
//                        System.out.print("Unknown cell type");
//                        break;
//                }
//            }
//            System.out.println();
//        }

        workbook.close();
        inputStream.close();
    }
}
