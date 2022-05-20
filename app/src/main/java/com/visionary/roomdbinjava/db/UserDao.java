package com.visionary.roomdbinjava.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.visionary.roomdbinjava.base.EntityDao;

import java.util.List;

@Dao
public interface UserDao extends EntityDao<DBUser> {

    @Query("SELECT * FROM users")
    List<DBUser> getAll();

    @Query("SELECT * FROM users WHERE id =:uid")
    DBUser getById(int uid);

    @Override
    @Insert
    void add(DBUser... e);

    @Override
    @Delete
    void delete(DBUser dbUser);
}

