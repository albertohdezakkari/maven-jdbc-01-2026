package org.example.DAO;

import java.util.ArrayList;

public interface DAO<X> {
    void add(X object);
    void update(int id, X object);
    void delete(int id);
    X find(int id);
    ArrayList<X> findAll(); // SELECT * FROM TAB
}
