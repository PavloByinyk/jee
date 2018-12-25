package com.levelp.spring.dao;

import com.levelp.spring.model.Idea;

import java.util.List;

public interface IdeasDAO {

    int addIdea(Idea idea);
    int updateIdea(Idea idea);
    int deleteIdea(int id);
    Idea getIdea(int id);
    List<Idea> list();

}
