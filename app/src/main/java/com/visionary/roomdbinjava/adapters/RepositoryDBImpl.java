package com.visionary.roomdbinjava.adapters;

import com.visionary.roomdbinjava.adapters.db.EntityDao;
import com.visionary.roomdbinjava.adapters.mappers.ListMapper;
import com.visionary.roomdbinjava.adapters.mappers.ListMapperImpl;
import com.visionary.roomdbinjava.adapters.mappers.Mapper;
import com.visionary.roomdbinjava.domain.Repository;

import java.util.List;

public class RepositoryDBImpl<I,O> implements Repository<O> {
    private EntityDao<I> api;
    private Mapper<I, O> mapperFromDB;
    private Mapper<O, I> mapperToDB;

    public RepositoryDBImpl(EntityDao<I> api,
                            Mapper<I, O> mapperFromDB,
                            Mapper<O, I> mapperToDB){
        this.api = api;
        this.mapperFromDB = mapperFromDB;
        this.mapperToDB = mapperToDB;
    }

    @Override
    public O getById(int uid) {
        return mapperFromDB.map(api.getById(uid));
    }

    @Override
    public void add(O o) {
        api.add(mapperToDB.map(o));
    }

    @Override
    public List<O> getAll() {
        ListMapper<I, O> listMapper = new ListMapperImpl<I, O>(this.mapperFromDB);
        return listMapper.map(api.getAll());
    }
}
