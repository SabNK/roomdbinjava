package com.visionary.roomdbinjava.adapters.helpers;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class DBUser {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    public int uid = 0;

    @ColumnInfo(name="first_name")
    public String firstName;

    @ColumnInfo(name="last_name")
    public String lastName;

    public DBUser(){}
    @Ignore
    public DBUser(int uid, String firstName, String lastName) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Ignore
    public DBUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
