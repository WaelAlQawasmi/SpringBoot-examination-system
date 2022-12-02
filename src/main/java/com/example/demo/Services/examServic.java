package com.example.demo.Services;

import com.example.demo.Entity.exams;
import com.example.demo.Rebosotory.examRebosotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class examServic {
    @Autowired
    examRebosotory examRebosotory;

    public List<exams>allExams(){
        return  examRebosotory.findAll();
    }
    public Optional<exams> showExam(Long id){
        return examRebosotory.findById(id);

    }

    public  void  createExam(exams exam){
        examRebosotory.save(exam);
    }



}
