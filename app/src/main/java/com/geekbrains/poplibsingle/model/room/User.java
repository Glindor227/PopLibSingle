package com.geekbrains.poplibsingle.model.room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tablet_user")
public class User {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String surname;
    public int age;

    @NonNull
    @Override
    public String toString() {
        return "User {" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "surname = " + surname + ", " +
                "age = " + age +
                "} ";
    }

}
