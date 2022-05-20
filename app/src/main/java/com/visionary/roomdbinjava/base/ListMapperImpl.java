package com.visionary.roomdbinjava.base;

import com.visionary.roomdbinjava.base.ListMapper;
import com.visionary.roomdbinjava.base.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ListMapperImpl<I,O> implements ListMapper<I,O> {
    private Mapper<I, O> mapper;

    public ListMapperImpl(Mapper<I, O> mapper) {
        this.mapper = mapper;
    }
    public List<O> map(List<I> iList) {
        if (null == iList)
           throw new IllegalArgumentException("null list");
        if (null == this.mapper)
           throw new IllegalArgumentException("null mapper");
        List<O> oList = new ArrayList<>();
        for (I i : iList) {
            oList.add(mapper.map(i));
        }
        return oList;
    }
}
