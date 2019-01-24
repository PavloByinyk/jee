package net.springsecurity.dao;

import net.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
