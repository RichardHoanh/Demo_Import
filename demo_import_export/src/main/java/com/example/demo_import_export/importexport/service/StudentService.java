package com.example.demo_import_export.importexport.service;

import com.example.demo_import_export.entity.Student;

public interface StudentService {
       void create(Student student) ;

       Student findStudentByCode(String code);

       Student edit (Student student);


}
