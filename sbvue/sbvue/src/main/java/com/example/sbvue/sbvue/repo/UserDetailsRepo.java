package com.example.sbvue.sbvue.repo;

import com.example.sbvue.sbvue.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
