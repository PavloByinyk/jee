package com.def.datajpa.service;

import com.def.datajpa.entity.BankAccount;

import java.util.List;

public interface BankAccountService {

    BankAccount addBank(BankAccount bank);

    void delete(long id);

    BankAccount getByName(String name);

    BankAccount editBank(BankAccount bank);

    List<BankAccount> getAll();
}
