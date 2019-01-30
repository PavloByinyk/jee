package com.example.spboot.repository;

import com.example.spboot.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    List<Message> findByTagLike(String tag);
}
