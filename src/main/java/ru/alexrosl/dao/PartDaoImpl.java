package ru.alexrosl.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import ru.alexrosl.model.Part;

import java.io.Serializable;
import java.util.List;

@EnableTransactionManagement
@Transactional
public class PartDaoImpl implements PartDao {

    @Autowired
    SessionFactory factory;

    @Override
    public int add(Part part) {
        Session session = factory.openSession();
        Serializable id = session.save(part);
        session.close();
        return (Integer) id;
    }

    @Override
    public int update(Part part) {
        Session session = factory.openSession();
        session.update(part);
        Serializable id = session.getIdentifier(part);
        session.flush();
        session.close();
        return (int) id;
    }

    @Override
    public int delete(int id) {
        Session session = factory.openSession();
        Part part = (Part) session.get(Part.class, id);
        session.delete(part);
        Serializable identifier = session.getIdentifier(part);
        session.flush();
        session.close();
        return (int) identifier;
    }

    @Override
    public Part get(int id) {
        Session session = factory.openSession();
        Part identifier = (Part) session.get(Part.class, id);
        session.close();
        return identifier;
    }

    @Override
    public Part get(String name) {
        Session session = factory.openSession();

        List parts = session.createCriteria(Part.class)
                .add(Restrictions.eq("name", name))
                .addOrder(Order.desc("created"))
                .list();

        Part part;
        if (parts != null && parts.size() > 0) {
            part = (Part) parts.get(0);
        } else {
            part = null;
        }

        return part;
    }

    @Override
    public List<Part> list() {
        Session session = factory.openSession();
        List list = session.createQuery("from Part").list();
        session.close();
        return list;
    }
}
