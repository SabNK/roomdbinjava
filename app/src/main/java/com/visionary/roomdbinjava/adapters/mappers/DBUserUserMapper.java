package com.visionary.roomdbinjava.adapters.mappers;

import com.visionary.roomdbinjava.adapters.helpers.DBUser;
import com.visionary.roomdbinjava.domain.User;

public class DBUserUserMapper implements Mapper<DBUser, User> {

    @Override
    public User map(DBUser dbUser) {
        User.Name uname = new User.Name(dbUser.firstName, dbUser.lastName);
        return new User(dbUser.uid, uname);
    }
}
