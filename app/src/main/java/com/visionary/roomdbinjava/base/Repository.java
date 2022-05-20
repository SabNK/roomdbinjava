package com.visionary.roomdbinjava.base;

import java.util.List;

public interface Repository<E> {

    E getById(int uid);

    void add(E e);

    List<E> getAll();
}
