package com.def.datajpa.service;

import com.def.datajpa.entity.Client;

import java.util.List;

public interface ClientService {

    Client addBank(Client bank);

    void delete(long id);

    Client getByName(String name);

    Client editBank(Client bank);

    List<Client> getAll();
}
