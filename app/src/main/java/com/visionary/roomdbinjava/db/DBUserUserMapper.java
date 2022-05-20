package com.visionary.roomdbinjava.db;

import com.visionary.roomdbinjava.base.Mapper;

public class DBUserUserMapper implements Mapper<DBUser, User> {

    @Override
    public User map(DBUser dbUser) {
        User.Name uname = new User.Name(dbUser.firstName, dbUser.lastName);
        return new User(dbUser.uid, uname);
    }
}
