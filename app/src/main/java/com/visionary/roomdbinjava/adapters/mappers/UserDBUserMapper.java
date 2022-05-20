package com.visionary.roomdbinjava.adapters.mappers;

import com.visionary.roomdbinjava.adapters.helpers.DBUser;
import com.visionary.roomdbinjava.domain.User;

public class UserDBUserMapper implements Mapper<User, DBUser> {
    @Override
    public DBUser map(User user) {
        return new DBUser(user.uid, user.name.firstName, user.name.lastName);
    }
}
