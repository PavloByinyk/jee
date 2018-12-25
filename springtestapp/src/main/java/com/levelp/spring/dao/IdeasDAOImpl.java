package com.levelp.spring.dao;

import com.levelp.spring.model.Idea;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public class IdeasDAOImpl implements IdeasDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    @Override
    public int addIdea(Idea idea) {
        Session session = sessionFactory.openSession();
        Serializable id = session.save(idea);
        session.close();
        return (Integer)id;
    }

    @Transactional
    @Override
    public int updateIdea(Idea idea) {
        Session session = sessionFactory.openSession();
        session.update(idea);
        Serializable identifier = session.getIdentifier(idea);
        session.flush();
        session.close();
        return (Integer) identifier;
    }

    @Transactional
    @Override
    public int deleteIdea(int id) {
        Session session = sessionFactory.openSession();
        Idea idea = (Idea) session.get(Idea.class, id);
        session.delete(idea);
        Serializable identifier = session.getIdentifier(idea);
        session.flush();
        session.close();
        return (Integer) identifier;
    }

    @Transactional
    @Override
    public Idea getIdea(int id) {
        Session session = sessionFactory.openSession();
        Idea idea = (Idea) session.get(Idea.class, id);
        session.close();
        return idea;
    }

    @Transactional
    @Override
    public List<Idea> list() {
        Session session = sessionFactory.openSession();
        List ideas = session.createQuery("from Idea").list();
        session.close();
        return ideas;
    }
}
