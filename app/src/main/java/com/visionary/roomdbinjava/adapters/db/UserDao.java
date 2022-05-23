package com.visionary.roomdbinjava.adapters.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.visionary.roomdbinjava.adapters.helpers.DBUser;

import java.util.List;

@Dao
public interface UserDao extends EntityDao<DBUser> {

    @Override
    @Query("SELECT * FROM users")
    List<DBUser> getAll();

    @Override
    @Query("SELECT * FROM users WHERE id =:uid")
    DBUser getById(int uid);

    @Override
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(DBUser... e);

    @Override
    @Delete
    void delete(DBUser dbUser);
}

