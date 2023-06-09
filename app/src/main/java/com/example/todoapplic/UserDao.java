package com.example.todoapplic;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Query("DELETE FROM user")
    public void nukeTable();

    @Insert
    Long insertAll(User user);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertAllWithReplace(User user);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertAllWithIgnore(User user);

    @Delete
    void delete(User user);
}