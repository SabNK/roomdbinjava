package com.visionary.roomdbinjava.adapters.helpers;

import com.google.gson.annotations.SerializedName;

public class DTOUser {
    @SerializedName("id")
    public int uid;

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;
}
