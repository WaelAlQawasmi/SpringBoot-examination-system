package com.example.demo.Repositories;

import com.example.demo.Entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<users,Long> {
    users findByemail(String email);
}
