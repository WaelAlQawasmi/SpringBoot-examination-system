package com.example.demo.Rebosotory;

import com.example.demo.Entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRebosotory extends JpaRepository<users,Long> {
    users  findByusername(String username);  //to find userName

}
