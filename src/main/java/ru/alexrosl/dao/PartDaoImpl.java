package ru.alexrosl.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.alexrosl.model.Part;

import java.io.Serializable;
import java.util.List;

public class PartDaoImpl implements PartDao {

    @Autowired
    SessionFactory factory;

    @Override
    public int add(Part part) {
        Session session = factory.openSession();
        Serializable id = session.save(part);
        return (Integer) id;
    }

    @Override
    public int update(Part part) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public Part get(int id) {
        return null;
    }

    @Override
    public List<Part> list() {
        Session session = factory.openSession();
        List list = session.createQuery("from Part").list();
        return list;
    }
}
