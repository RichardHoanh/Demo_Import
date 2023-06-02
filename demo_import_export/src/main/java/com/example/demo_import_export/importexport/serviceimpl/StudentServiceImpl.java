package com.example.demo_import_export.importexport.serviceimpl;


import com.example.demo_import_export.entity.Student;
import com.example.demo_import_export.importexport.service.StudentService;
import com.example.demo_import_export.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;


    @Override
    public void create(Student student) {
        studentRepo.save(student);

    }

    @Override
    public Student findStudentByCode(String code) {
        Student student = studentRepo.findByCode(code);
        return student;
    }

    @Override
    public Student edit(Student student) {
        studentRepo.save(student);
        return null;
    }
}



