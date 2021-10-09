package com.example.myrestaurant.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryDbRepositoryAbstract<T> implements MemoryDbRepositoryIfs<T> {

    private final List<T> db = new ArrayList<>();

    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        return Optional.empty();
    }

    @Override
    public T save(T entity) {
        return null;
    }

    @Override
    public void deleteById(int index) {

    }

    @Override
    public List<T> listAll() {
        return null;
    }
}
