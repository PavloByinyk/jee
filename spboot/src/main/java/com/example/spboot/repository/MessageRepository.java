package com.example.spboot.repository;

import com.example.spboot.domain.Message;
import com.example.spboot.domain.User;
import com.example.spboot.domain.dto.MessageDTO;
import javafx.scene.control.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

//    Page<Message> findAll(Pageable pageable);
//
//    Page<Message> findByTagLike(String tag, Pageable pageable);
//
//    Page<MessageDto> findByUser(Pageable pageable, User author, User currentUser);



    @Query("select new com.example.sweater.domain.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :user then 1 else 0 end) > 0" +
            ") " +
            "from Message m left join m.likes ml " +
            "group by m")
    Page<MessageDTO> findAll(Pageable pageable, @Param("user") User user);

    @Query("select new com.example.sweater.domain.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :user then 1 else 0 end) > 0" +
            ") " +
            "from Message m left join m.likes ml " +
            "where m.tag = :tag " +
            "group by m")
    Page<MessageDTO> findByTagLike(@Param("tag") String tag, Pageable pageable, @Param("user") User user);

    @Query("select new com.example.sweater.domain.dto.MessageDto(" +
            "   m, " +
            "   count(ml), " +
            "   sum(case when ml = :user then 1 else 0 end) > 0" +
            ") " +
            "from Message m left join m.likes ml " +
            "where m.author = :author " +
            "group by m")
    Page<MessageDTO> findByUser(Pageable pageable, @Param("author") User author, @Param("user") User user);
}
