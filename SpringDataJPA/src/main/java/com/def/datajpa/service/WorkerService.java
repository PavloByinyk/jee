package com.def.datajpa.service;

import com.def.datajpa.entity.Worker;

import java.util.List;

public interface WorkerService {

    Worker addBank(Worker bank);

    void delete(long id);

    Worker getByName(String name);

    Worker editBank(Worker bank);

    List<Worker> getAll();
}
