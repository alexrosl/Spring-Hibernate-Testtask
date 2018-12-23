package ru.alexrosl.dao;

import ru.alexrosl.model.Part;

import java.util.List;

public interface PartDao {
    int add (Part part);
    int update (Part part);
    int delete (int id);
    Part get (int id);
    List<Part> list();
}
