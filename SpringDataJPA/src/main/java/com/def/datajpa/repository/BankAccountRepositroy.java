package com.def.datajpa.repository;

import com.def.datajpa.entity.Bank;
import com.def.datajpa.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepositroy extends JpaRepository<BankAccount, Long> {
}
