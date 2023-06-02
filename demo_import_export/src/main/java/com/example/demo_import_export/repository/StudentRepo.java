package com.example.demo_import_export.repository;

import com.example.demo_import_export.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    Student findByCode(String code);


}

