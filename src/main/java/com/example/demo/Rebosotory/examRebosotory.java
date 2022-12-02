package com.example.demo.Rebosotory;
import  com.example.demo.Entity.exams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface examRebosotory extends JpaRepository<exams,Long> {
}
