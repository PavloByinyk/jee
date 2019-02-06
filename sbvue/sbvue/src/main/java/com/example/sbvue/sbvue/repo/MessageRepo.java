package com.example.sbvue.sbvue.repo;

import com.example.sbvue.sbvue.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
