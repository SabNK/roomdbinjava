package com.visionary.roomdbinjava.base;

public interface Mapper <I, O> {
    O map(I i);
}
