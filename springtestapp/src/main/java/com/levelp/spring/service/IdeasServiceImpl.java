package com.levelp.spring.service;

import com.levelp.spring.dao.IdeasDAO;
import com.levelp.spring.model.Idea;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IdeasServiceImpl implements IdeasService {

    @Autowired
    IdeasDAO dao;

    @Override
    public int addIdea(Idea idea) {
        return dao.addIdea(idea);
    }

    @Override
    public int updateIdea(Idea idea) {
        return dao.updateIdea(idea);
    }

    @Override
    public int deleteIdea(int id) {
        return dao.deleteIdea(id);
    }

    @Override
    public Idea getIdea(int id) {
        return dao.getIdea(id);
    }

    @Override
    public List<Idea> list() {
        return dao.list();
    }
}
