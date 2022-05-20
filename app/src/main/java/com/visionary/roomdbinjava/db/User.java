package com.visionary.roomdbinjava.db;

import java.util.Objects;

public class User {
    public int uid;
    public Name name;

    public User(int uid, Name name) {
        this.uid = uid;
        this.name = name;
    }

    public User(Name name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uid == user.uid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }

    public static class Name {
        public String firstName;
        public String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}
