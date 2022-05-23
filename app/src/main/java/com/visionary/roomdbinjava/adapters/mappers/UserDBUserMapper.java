package com.visionary.roomdbinjava.adapters.mappers;

import android.util.Log;

import com.visionary.roomdbinjava.adapters.helpers.DBUser;
import com.visionary.roomdbinjava.domain.User;

public class UserDBUserMapper implements Mapper<User, DBUser> {
    @Override
    public DBUser map(User user) {
        DBUser dbu = new DBUser(user.name.firstName, user.name.lastName);
        Log.d("NewUser", "generated DBUSER successfully");
        return dbu;
    }
}
