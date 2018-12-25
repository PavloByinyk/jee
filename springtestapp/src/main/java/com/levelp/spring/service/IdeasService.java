package com.levelp.spring.service;

import com.levelp.spring.model.Idea;

import java.util.List;

public interface IdeasService {

    int addIdea(Idea idea);
    int updateIdea(Idea idea);
    int deleteIdea(int id);
    Idea getIdea(int id);
    List<Idea> list();
}
