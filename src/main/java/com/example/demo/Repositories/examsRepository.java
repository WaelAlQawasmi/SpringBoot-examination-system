package com.example.demo.Repositories;

import com.example.demo.Entity.exams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface examsRepository extends JpaRepository<exams,Long> {


}
