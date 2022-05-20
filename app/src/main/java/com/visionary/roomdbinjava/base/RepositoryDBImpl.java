package com.visionary.roomdbinjava.base;

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
