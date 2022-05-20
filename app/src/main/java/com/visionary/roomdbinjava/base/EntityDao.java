package com.visionary.roomdbinjava.base;

import java.util.List;


public interface EntityDao <E> {

    List<E> getAll();

    E getById(int uid);

    void add(E... e);

    void delete(E e);

}
