package com.example.demo.Repositories;

import com.example.demo.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<user,Long> {
    user findByemail(String email);
}
