package com.geekbrains.poplibsingle.model.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM tablet_user")
    Single<List<User>> getAllUser();

    @Insert
    Single<Long> addUser(User user);

    @Insert
    Single<List<Long>> addUsers(List<User> users);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    Single<Integer> updateUser(User user);

    @Delete
    Single<Integer> deleteUser(User user);


}
