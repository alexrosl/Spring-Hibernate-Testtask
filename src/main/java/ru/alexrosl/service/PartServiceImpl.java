package ru.alexrosl.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.alexrosl.dao.PartDao;
import ru.alexrosl.model.Part;

import java.util.List;

public class PartServiceImpl implements PartService {
    @Autowired
    PartDao dao;

    @Override
    public int add(Part part) {
        return dao.add(part);
    }

    @Override
    public int update(Part part) {
        return dao.update(part);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public Part get(int id) {
        return dao.get(id);
    }

    @Override
    public Part get(String name) {
        return dao.get(name);
    }

    @Override
    public List<Part> list() {
        return dao.list();
    }
}
