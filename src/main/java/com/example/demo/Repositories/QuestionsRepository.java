package com.example.demo.Repositories;

import com.example.demo.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuestionsRepository  extends JpaRepository<Questions,Long>
{
}
