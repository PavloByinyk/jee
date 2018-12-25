package com.def.datajpa.repository;

import com.def.datajpa.entity.Bank;
import com.def.datajpa.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
