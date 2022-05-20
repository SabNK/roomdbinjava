package com.visionary.roomdbinjava.db;

import com.visionary.roomdbinjava.base.Mapper;

public class UserDBUserMapper implements Mapper<User, DBUser> {
    @Override
    public DBUser map(User user) {
        return new DBUser(user.uid, user.name.firstName, user.name.lastName);
    }
}
